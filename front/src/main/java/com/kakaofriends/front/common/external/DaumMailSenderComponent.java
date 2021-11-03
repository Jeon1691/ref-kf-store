package com.kakaofriends.front.common.external;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.front.domain.payment.PayResultData;
import com.kakaofriends.front.service.order.vo.Order;
import com.kakaofriends.front.service.order.vo.OrderAddress;
import com.kakaofriends.front.service.order.vo.OrderMain;
import com.kakaofriends.front.service.order.vo.OrderSubProduct;
import com.kakaofriends.front.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.ToDoubleFunction;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.KAKAO_FRIENDS_ENCODING;
import static com.kakaofriends.front.utils.FriendsUtil.processMessage;
import static java.util.stream.Collectors.toList;

@Slf4j
@Component
public class DaumMailSenderComponent {

	@Value("${mail.smtp.sender.addr}")
	private String senderAddress;

	@Value("${mail.smtp.sender.name}")
	private String senderName;

	@Value("${mail.smtp.sender.name.en}")
	private String senderNameEn;

	@Value("${mail.smtp.cc.add}")
	private String ccAddress;

	@Value("${kakaofriends.cdn.product}")
	private String kakaofriendsCdnProduct;

	@Value("${kakaoFriends.online.store.url}")
	private String kakaofriendsOnlineStoreUrl;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine emailTemplateEngine;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	@Autowired
	private ProductService productService;

	private ToDoubleFunction<OrderSub> doubleFunction = i -> i.getExchangeSaleMoney() * i.getOsEa() ;

	public void sendCompleteMail(PayResultData payResultData, Locale locale) {

		log.info("####################### 메일 발송 Start ####################");
		log.info("## 메일주소 : {}, 주문번호 : {}, 주문자 : {}, 전화번호 : {}, 총 금액 : {} ", payResultData.getOrderMail(), payResultData.getOrderMain().getOmNum(), payResultData.getOrderName(), payResultData.getOrderPhone(), payResultData.getAmt());
		log.info("## 우편번호 : {}, 주소 : {}, 주소2 : {}, 배송메모 : {} ", payResultData.getOrderAddress().getOaZoneCode(), payResultData.getOrderAddress().getOaAddr1(), payResultData.getOrderAddress().getOaAddr2(), payResultData.getOrderAddress().getOaDeliMemo());
		log.info("####################### 메일 발송 End   ####################");

		boolean isGlobal = !StringUtils.isEmpty(payResultData.getOrderAddress().getOaCountryName()) && !(payResultData.getOrderAddress().getOaCountryName().equals("한국") || payResultData.getOrderAddress().getOaCountryName().toLowerCase().equals("korea"));
		payResultData.getOrderSubs().stream().forEach(e -> e.setExchangeSaleMoney(getExchangePrice(e.getOsSaleMoney())));
		Map<String, Object> orderInfo = new HashedMap();
		orderInfo.put("kakaofriendsCdnProduct", kakaofriendsCdnProduct);
		orderInfo.put("kakaofriendsOnlineStoreUrl", kakaofriendsOnlineStoreUrl);
		orderInfo.put("orderOrderSubs", payResultData.getOrderSubs().stream().filter(e -> e.getOsPrCode() != null).collect(toList()));
		orderInfo.put("orderNum", payResultData.getOrderMain().getOmNum());
		orderInfo.put("orderAuthDate", payResultData.getOrderMain().getOmInDate());
		orderInfo.put("orderProductName", payResultData.getOrderProductName());
		orderInfo.put("orderAmount", payResultData.getAmt());
		orderInfo.put("orderPhone", payResultData.getOrderAddress().getOaPhone());
		orderInfo.put("orderDeliveryMoneyUse", payResultData.getOrderMain().getOmDeliMoenyUse());
		orderInfo.put("orderDelivery", payResultData.getOrderMain().getOmDeliveryMoney());
		orderInfo.put("orderZoneCode", payResultData.getOrderAddress().getOaZoneCode());
		orderInfo.put("orderAddress1", payResultData.getOrderAddress().getOaAddr1());
		orderInfo.put("orderAddress2", payResultData.getOrderAddress().getOaAddr2());
		orderInfo.put("orderAddress3", payResultData.getOrderAddress().getOaAddr3());
		orderInfo.put("orderCountryName", payResultData.getOrderAddress().getOaCountryName());
		orderInfo.put("isGlobal", isGlobal);
		orderInfo.put("orderMemo", payResultData.getOrderAddress().getOaDeliMemo());
		orderInfo.put("orderBuyerName", payResultData.getOrderAddress().getOaBuyerName());
		orderInfo.put("orderBuyerEmail", payResultData.getOrderAddress().getOaBuyerEmail());
		orderInfo.put("orderName", payResultData.getOrderAddress().getOaName());
		orderInfo.put("orderEmail", payResultData.getOrderAddress().getOaEmail());

		double exchangeOrderAmount = payResultData.getOrderSubs().stream().mapToDouble(doubleFunction).sum();

		orderInfo.put("exchangeOrderAmount", Math.round(exchangeOrderAmount * 100d) / 100d);
		orderInfo.put("exchangeOrderDelivery", getExchangePrice(payResultData.getOrderMain().getOmDeliveryMoney()));

		if(StringUtils.isEmpty(payResultData.getOrderMain().getOmPaypalSaleId())){
			orderInfo.put("isPaypal", false);
		}else{
			orderInfo.put("isPaypal", true);
		}
		try {
			this.sendMailService(payResultData.getOrderMail(), orderInfo, locale, isGlobal);
		} catch (Exception e) {
			log.info("메일 발송 장애 메일주소 {}, 주문번호 {}, 주문자 = {}", payResultData.getOrderMail(), payResultData.getOrderMain().getOmNum(), payResultData.getOrderName());
			log.info("Stack Trace", e);
		}
	}

	public void sendCompleteMail(Order order, Locale locale) {
		OrderMain orderMain = order.getOrderMain();
		OrderAddress orderAddress = order.getOrderAddress();
		List<com.kakaofriends.front.service.order.vo.OrderSub> orderSubList = order.getOrderSubList().stream().filter(e -> e.getProductCode() != null).collect(toList());
		List<OrderSubProduct> orderSubProductList = new ArrayList<>();
		for (com.kakaofriends.front.service.order.vo.OrderSub orderSub : orderSubList) {
			OrderSubProduct orderSubProduct = new OrderSubProduct();
			orderSubProduct.setOrderSub(orderSub);
			orderSubProduct.setProduct(productService.get(orderSub.getProductCode()));
			orderSubProductList.add(orderSubProduct);
		}

		String orderProductName = orderSubProductList.get(0).getProduct().getProductName(locale);
		if (orderSubList.size() > 1) {
			if (locale.equals(Locale.KOREA)) {
				orderProductName += "외 " + (orderSubList.size()-1) + "건";
			} else {
				orderProductName += "and others (" + (orderSubList.size()-1) + ")";
			}
		}

		log.info("####################### 메일 발송 Start ####################");
		log.info("## 메일주소 : {}, 주문번호 : {}, 주문자 : {}, 전화번호 : {}, 총 금액 : {} ", orderAddress.getBuyerEmail(), orderMain.getOrderNumber(), orderAddress.getBuyerName(), orderAddress.getBuyerPhone(), orderMain.getPrice());
		log.info("## 우편번호 : {}, 주소 : {}, 주소2 : {}, 배송메모 : {} ", orderAddress.getZipCode(), orderAddress.getAddress1(), orderAddress.getAddress2(), orderAddress.getDeliveryMemo());
		log.info("####################### 메일 발송 End   ####################");

		boolean isGlobal = orderMain.getDeliveryInOutType().equals(DeliInOutType.DOMESTIC) ? false : true;
		String orderCountryName = isGlobal ? orderAddress.getCountry().getNameEn() : orderAddress.getCountry().getName();

		Map<String, Object> orderInfo = new HashedMap();
		orderInfo.put("kakaofriendsCdnProduct", kakaofriendsCdnProduct);
		orderInfo.put("kakaofriendsOnlineStoreUrl", kakaofriendsOnlineStoreUrl);
		orderInfo.put("orderOrderSubs", orderSubProductList);
		orderInfo.put("orderNum", orderMain.getOrderNumber());
		orderInfo.put("orderAuthDate", new Date());
		orderInfo.put("orderProductName", orderProductName);
		orderInfo.put("orderAmount", orderMain.getPrice());
		orderInfo.put("orderPhone", orderAddress.getPhone());
		orderInfo.put("orderDeliveryMoneyUse", orderMain.getDeliveryMoneyUse().getCode());
		orderInfo.put("orderDelivery", orderMain.getDeliveryMoney());
		orderInfo.put("orderZoneCode", orderAddress.getZipCode());
		orderInfo.put("orderAddress1", orderAddress.getAddress1());
		orderInfo.put("orderAddress2", orderAddress.getAddress2());
		orderInfo.put("orderAddress3", orderAddress.getAddress3());
		orderInfo.put("orderCountryName", orderCountryName);
		orderInfo.put("isGlobal", isGlobal);
		orderInfo.put("orderMemo", orderAddress.getDeliveryMemo());
		orderInfo.put("orderBuyerName", orderAddress.getBuyerName());
		orderInfo.put("orderBuyerEmail", orderAddress.getBuyerEmail());
		orderInfo.put("orderName", orderAddress.getName());
		orderInfo.put("orderEmail", orderAddress.getEmail());

		BigDecimal orderAmount = orderMain.getPrice().subtract(orderMain.getDeliveryMoney());

		orderInfo.put("exchangeOrderAmount", getExchangePrice(orderAmount.intValue()));
		orderInfo.put("exchangeOrderDelivery", getExchangePrice(orderMain.getDeliveryMoney().intValue()));

		switch (orderMain.getPayType()) {
			case PAYPAL:
				orderInfo.put("isPaypal", true);
				break;
			default:
				orderInfo.put("isPaypal", false);
				break;
		}
		try {
			this.sendMailService(orderAddress.getBuyerEmail(), orderInfo, locale, isGlobal);
		} catch (Exception e) {
			log.info("메일 발송 장애 메일주소 {}, 주문번호 {}, 주문자 = {}", orderAddress.getBuyerEmail(), orderAddress.getOrderNumber(), orderAddress.getBuyerName());
			log.info("Stack Trace", e);
		}
	}

	public void sendMailService(String receiver, Object variable, Locale locale, boolean isGlobal) throws MessagingException, UnsupportedEncodingException {
		final Context ctx = new Context(isGlobal ? locale : Locale.KOREA);
		ctx.setVariable("variable", variable);

		String template = isGlobal ? "order_complete_en" : "order_complete";
		String sender = isGlobal ? senderNameEn : senderName;

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, KAKAO_FRIENDS_ENCODING);
		mimeMessageHelper.setFrom(new InternetAddress(senderAddress, sender, KAKAO_FRIENDS_ENCODING));
		mimeMessageHelper.setTo(new InternetAddress(receiver));
		if (!Arrays.asList(applicationContext.getEnvironment().getActiveProfiles()).contains("production")) {
			mimeMessageHelper.setCc(ccAddress.split(","));
		}
		mimeMessageHelper.setSubject(processMessage(messageSource, "mail.order.complete"));
		mimeMessageHelper.setText(emailTemplateEngine.process(template, ctx), true);
		javaMailSender.send(mimeMessage);
	}

	public void sendMail(String pTemplate, String subject, String receiver, Object variable, Locale locale) throws MessagingException, UnsupportedEncodingException {
		final Context ctx = new Context(locale);
		ctx.setVariable("variable", variable);

		String template = "kr".equals(locale.getLanguage()) ? pTemplate: pTemplate + "En";
		String sender = Locale.KOREA.equals(locale) ? senderName : senderNameEn;

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, KAKAO_FRIENDS_ENCODING);
		mimeMessageHelper.setFrom(new InternetAddress(senderAddress, sender, KAKAO_FRIENDS_ENCODING));
		mimeMessageHelper.setTo(new InternetAddress(receiver));
		if (!Arrays.asList(applicationContext.getEnvironment().getActiveProfiles()).contains("production")) {
			mimeMessageHelper.setCc(ccAddress.split(","));
		}
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(emailTemplateEngine.process(template, ctx), true);
		javaMailSender.send(mimeMessage);
	}

	private double getExchangePrice(Integer price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d ) / 100d ;
	}
}
