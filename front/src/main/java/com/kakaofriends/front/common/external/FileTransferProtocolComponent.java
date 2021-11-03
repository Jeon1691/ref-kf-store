package com.kakaofriends.front.common.external;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
@Component
public class FileTransferProtocolComponent {

	/**
	 * tenth2 파일 업로드설정
	 * 2017-03-30 keany.song
	*/
	@Value("${kakaofriends.tenth2.host}")
	private String host;

	@Value("${kakaofriends.tenth2.prefixPath}")
	private String prefixPath;

	@Value("${kakaofriends.tenth2.accessKey}")
	private String accessKey;

	@Value("${kakaofriends.tenth2.secretKey}")
	private String secretKey;

	@Value("${kakaofriends.tenth2.downloadUrl}")
	private String downloadUrl;

	@Value("${kakaofriends.tenth2.thumb.host}")
	public String thumbHost;

	@Value("${kakaofriends.tenth2.thumb.size}")
	public String size;


	public boolean uploadFile (String filePath, String fileName, MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();

		String pathAndFile = prefixPath + filePath + "/" + fileName;

		String method = "PUT";

		// 업로드 옵션 cplace 지정
		String xtwgPutKey = "X-Twg-Put-Option";
		String xtwgPutValue = "cplace";
		String xtwg = String.format("%s:%s", xtwgPutKey.toLowerCase(), xtwgPutValue);
		String date = getHttpDate();

		// Web Interface host (beta)
		String content_md5 = "";
		String content_type = "text/plain";

		// 헤더 인증 값 생성
		String canonic = method + "\n" + content_md5 + "\n" + content_type + "\n" + date + "\n" + xtwg + "\n" + pathAndFile;
		String authkey = encryptTWG(canonic, secretKey);

		System.out.printf("canonic: %s\nauth: %s\n", canonic, authkey);

		// 업로드 URL
		URL url = new URL(host + pathAndFile);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("x-twg-ucc-upload", "");
		conn.setRequestProperty("type", "image");
		conn.setRequestProperty("Date", date);
		conn.setRequestProperty("Content-Type", content_type);
		conn.setRequestProperty("Authorization", String.format("TWG %s:%s", accessKey, authkey));
		conn.setRequestProperty(xtwgPutKey, xtwgPutValue);
		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

		OutputStream output = conn.getOutputStream();
		byte[] buffer = new byte[4096];
		int length;
		while ((length = is.read(buffer)) > 0) {
			output.write(buffer, 0, length);
		}

		//200이 아니면 파일 업로드 오류로 판단
		int r = conn.getResponseCode();
		if ( r != 200 ) {
			throw new RuntimeException("file upload fail");
		}

		String msg = conn.getResponseMessage();

		output.flush();
		out.close();

		return true;
	}

	/**
	 * hmac-sha1후 base64로 인코딩한다.
	 */
	private static String encryptTWG(String data, String key)
			throws SignatureException {
		final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
		byte[] hmac = null;

		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);
			hmac = mac.doFinal(data.getBytes());

			byte[] base64buf = Base64.encodeBase64(hmac);
			return new String(base64buf);
		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
	}

	/**
	 * 현재 시각을 http date형식으로 리턴한다. (Thu, 17 Nov 2005 18:49:58 GMT)
	 */
	private static String getHttpDate() {
		// Thu, 17 Nov 2005 18:49:58 GMT
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return dateFormat.format(calendar.getTime());
	}
}