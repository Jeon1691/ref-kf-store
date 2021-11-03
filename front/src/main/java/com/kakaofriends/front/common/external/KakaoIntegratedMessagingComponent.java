package com.kakaofriends.front.common.external;

import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.kims.MultimediaMessageServiceDto;
import com.kakaofriends.front.domain.kims.ShortMessageServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.HTTP_WAITING_TIME;
import static com.kakaofriends.front.utils.FriendsUtil.processMessageByLocale;

@Slf4j
@Component
public class KakaoIntegratedMessagingComponent {

	@Value("${kims.domain}")
	private String domain;

	@Value("${kims.appName}")
	private String appName;

	@Value("${kims.sms.path}")
	private String smsPath;

	@Value("${kims.mms.path}")
	private String mmsPath;

    @Value("${kims.msg.path}")
    private String msgPath;

	@Value("${kims.callerNumber}")
	private String callerNumber;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ObjectMapper objectMapper;

	public void sendOrderCompleteSms(String orderNumber, String memberName, String phoneNumber, Country country) {
		log.info("SMS 발송 발신번호 = {}, 주문번호 = {}, 주문자 = {}", phoneNumber, orderNumber, memberName);
		String countryCode = "82";
		String[] phoneNumArr = null;

		if(StringUtils.isNotEmpty(phoneNumber)) {
			phoneNumArr = phoneNumber.split("-");
			// 해외 및 국내 문자 발송 ex:) 82-10-1111-2222 , 61-1111-2222-15
			if (phoneNumArr != null && phoneNumArr.length > 1) {
				phoneNumber = "";
				countryCode = phoneNumArr[0];
				for (int i = 1; i < phoneNumArr.length; i++) {
					phoneNumber += phoneNumArr[i];
				}
				log.info("SMS 해외 및 국내 문자 발송 정보  국가코드 = {} , 발신번호 = {}", countryCode, phoneNumber);
			} else if (!phoneNumber.startsWith("0")) {    // 기존 국내 문자 발송 소스 ex:) 01011112222 , 010-1111-2222 , 10-1111-2222
				phoneNumber = "0" + phoneNumber.substring(phoneNumber.indexOf('-') + 1);
			}
		}

		try {
			this.sendMessageService(
					ShortMessageServiceDto.builder()
							.callerNumber(callerNumber)
							.receiverNumber(phoneNumber)
							.message(processMessageByLocale(country.getCode(), messageSource, "sms.order.complete", new Object[]{orderNumber}))
							.type("normal")
							.countryCode(countryCode)
							.build());
		} catch (Exception e) {
			log.error("SMS 발송 장애 발신번호 = {}, 주문번호 = {}, 주문자 = {}", phoneNumber, orderNumber, memberName);
			log.error("Stack Trace", e);
		}
	}

	/**
	 * 관리자SMS발송용(레이, 애슐리)
	 * @param receiveNumber
	 * @param messageStr
	 */
	public void sendAdminSms(String receiveNumber, String messageStr) {
		log.info("SMS 발송 발신번호 = {}, 메시지 = {}", receiveNumber, messageStr);
		try {
			this.sendShortMessageService(
					ShortMessageServiceDto.builder()
							.callerNumber(callerNumber)
							.receiverNumber(receiveNumber)
							.message(messageStr)
							.type("normal")
							.countryCode("82")
							.build());
		} catch (Exception e) {
			log.error("Stack Trace", e);
		}
	}

	public void sendSalesDataMms(String receiveNumber, String message){
		log.info("SMS 발송 발신번호 = {}, 메시지 = {}", receiveNumber, message);
		try {
			this.multimediatMessageService(
					MultimediaMessageServiceDto.builder()
							.callerNumber(callerNumber)
							.receiverNumber(receiveNumber)
							.message(message)
							.subject("kakaofriends.com")
							.build());
		} catch (Exception e) {
			log.error("Stack Trace", e);
		}
	}

	public void sendShortMessageService(ShortMessageServiceDto shortMessageServiceDto) throws Exception {

		shortMessageServiceDto.setCallerNumber(callerNumber);

		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.set("appName", appName);
		request.set("msgJson", objectMapper.writeValueAsString(shortMessageServiceDto));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(HTTP_WAITING_TIME);
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.postForEntity(domain + smsPath, new HttpEntity<>(request, headers), String.class);
	}


	/**
	 *
	 * 작성자 : dave
	 * 날짜 : 2017. 7. 5.
	 *
	 * kims mms 전송
	 * file 포함 안되면 lms로 전송
	 */
	public void multimediatMessageService(MultimediaMessageServiceDto multimediaMessageServiceDto) throws Exception {

		multimediaMessageServiceDto.setCallerNumber(callerNumber);

		MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.set("appName", appName);
		request.set("msgJson", objectMapper.writeValueAsString(multimediaMessageServiceDto));

		// 파일 포함시
//		request.set("file1", null);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(HTTP_WAITING_TIME);
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.postForEntity(domain + mmsPath, new HttpEntity<>(request, headers), String.class);
	}

    /**
     * SMS, LMS, MMS 전송 (통합)
     * 국내외 SMS, 국내 LMS, MMS 메시지를 전송합니다.
     * 제목이 없고 euc-kr 기준 90 bytes 이하이면 SMS로 전송합니다.
     * 제목이 있거나 euc-kr 기준 90 bytes를 초과하면 LMS로 전송합니다.
     * 첨부 이미지가 있으면 MMS로 전송됩니다.
     * @param shortMessageServiceDto
     * @throws Exception
     */
    public void sendMessageService(ShortMessageServiceDto shortMessageServiceDto) throws Exception {

        shortMessageServiceDto.setCallerNumber(callerNumber);

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.set("appName", appName);
        request.set("msgJson", objectMapper.writeValueAsString(shortMessageServiceDto));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(HTTP_WAITING_TIME);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.postForEntity(domain + msgPath, new HttpEntity<>(request, headers), String.class);
    }
}