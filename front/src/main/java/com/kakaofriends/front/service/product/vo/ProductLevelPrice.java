package com.kakaofriends.front.service.product.vo;

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
public class ProductLevelPrice {
	private Long sequence;
	private String productCode;
	private BigDecimal supplyPrice;
	private BigDecimal salesPrice;
	private BigDecimal discountedPrice;
	private String modifiedId;
	private String insertedId;
	private LocalDateTime modifiedDate;
	private LocalDateTime insertedDate;
}