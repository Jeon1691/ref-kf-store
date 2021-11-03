package com.kakaofriends.front.domain.payment;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CnsPayResultData {
	@JsonProperty(value = "ResultCode")
	private String resultCode;

	@JsonProperty(value = "ResultMsg")
	private String resultMsg;

	@JsonProperty(value = "AuthDate")
	private String authDate;

	@JsonProperty(value = "AuthCode")
	private String authCode;

	@JsonProperty(value = "buyerName")
	private String buyerName;

	@JsonProperty(value = "GoodsName")
	private String goodsName;

	@JsonProperty(value = "PayMethod")
	private String payMethod;

	@JsonProperty(value = "TID")
	private String tid;

	@JsonProperty(value = "MID")
	private String mid;

	@JsonProperty(value = "Moid")
	private String moid;

	@JsonProperty(value = "Amt")
	private int amt;

	@JsonProperty(value = "CardCode")
	private String cardCode;

	@JsonProperty(value = "CardName")
	private String cardName;

	@JsonProperty(value = "CardQuota")
	private String cardQuota;

	@JsonProperty(value = "CardInterest")
	private String cardInterest;

	@JsonProperty(value = "CardCl")
	private String cardCl;

	@JsonProperty(value = "CardBin")
	private String cardBin;

	@JsonProperty(value = "CardPoint")
	private String cardPoint;

	@JsonIgnore
	private String nonRepToken;
}
