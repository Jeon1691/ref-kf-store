package com.kakaofriends.front.domain.product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ProductLevelPriceData
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Data
public class ProductLevelPriceData {
	private Long prlpSeq;
	private String prlpPrcode;
	private BigDecimal prlpSupplyprice;
	private BigDecimal prlpSaleprice1;
	private BigDecimal prlpDiscountprice1;
	private String prlpMoid;
	private String prlpInid;
	private LocalDateTime prlpModate;
	private LocalDateTime prlpIndate;

	/**
	사용하지 않음
	private Integer prlpConsumerprice;
	private Integer prlpSaleprice2;
	private Integer prlpSaleprice3;
	private Integer prlpSaleprice4;
	private Integer prlpSaleprice5;
	private Integer prlpSaleprice6;
	private Integer prlpSaleprice7;
	private Integer prlpSaleprice8;
	private Integer prlpSaleprice9;
	private Integer prlpSaleprice10;
	private Integer prlpDiscountprice2;
	private Integer prlpDiscountprice3;
	private Integer prlpDiscountprice4;
	private Integer prlpDiscountprice5;
	private Integer prlpDiscountprice6;
	private Integer prlpDiscountprice7;
	private Integer prlpDiscountprice8;
	private Integer prlpDiscountprice9;
	private Integer prlpDiscountprice10;
	private Integer prlpEventprice;
	private Integer prlpTimesaleprice;
	private Integer prlpBuyeaprice1;
	private Integer prlpBuyeaprice2;
	private Integer prlpBuyeaprice3;
	private String prlpForeignsaleprice1;
	private String prlpForeignsaleprice2;
	private String prlpForeignsaleprice3;
	private String prlpForeigndiscountprice1;
	private String prlpForeigndiscountprice2;
	private String prlpForeigndiscountprice3;
	private String prlpEtc1;
	private String prlpEtc2;
	private String prlpEtc3;
	private String prlpEtc4;
	private String prlpEtc5;
	private String prlpEtc6;
	private String prlpLevel;
	private String prlpType;
	private String prlpUse;
	**/
}