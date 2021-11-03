package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSubExpansion implements Serializable {
	private int osSeq;
	private String osOmNum;
	private String prName;
	private String prImage1;
	private int osSaleMoney;
	private int osTotOriginalMoney;
	private int osTotSaleMoney;
	private int osEa;
	private int osOutEa;
	private int osInEa;
	private String osOptionName;
	private OrderStatusType osStatus;
	private String osType;
	private String osMoId;
	private ShippingStatusType shippingStatusType;
}
