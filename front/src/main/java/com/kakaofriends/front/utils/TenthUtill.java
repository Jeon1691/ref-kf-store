package com.kakaofriends.front.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class TenthUtill {
	@Value("${kakaofriends.tenth2.thumb.orgHost}")
	public String host;

	@Value("${kakaofriends.tenth2.prefixPath}")
	public String prefixPath;

	@Value("${kakaofriends.tenth2.thumb.host}")
	public String thumbHost;

	@Value("${kakaofriends.tenth2.thumb.size}")
	public String size;


	public String tenth2ThumbnailPath(String fileName, String type) {
		StringBuilder stringBuilder = new StringBuilder();
		String encoded = null;
		String fullUrl = host + prefixPath + "/" + type + "/" + fileName.replaceAll( "JPG","jpg" );
		try {
			encoded = URLEncoder.encode(fullUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) { }

		stringBuilder.append(thumbHost).append(size).append("/?fname=").append(encoded);

		return stringBuilder.toString();
	}

}