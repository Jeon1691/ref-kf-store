package com.kakaofriends.core.domain;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Deprecated
public class OrderSubHistory {
	private Long oshSeq;
	private String oshOmNum;
	private Integer oshOsSerial;
	private String oshMemo;
	private OrderStatusType oshOsStatus;
	private String oshLevel;
	private String oshType;
	private String oshUse;
	private String oshMoId;
	private String oshInId;
	private Date oshMoDate;
	private Date oshInDate;
}