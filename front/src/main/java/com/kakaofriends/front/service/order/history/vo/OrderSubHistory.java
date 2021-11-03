package com.kakaofriends.front.service.order.history.vo;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import lombok.Data;

import java.time.LocalDateTime;
/**
 * OrderSubHistoryData 주문 상세 이력에 대한 VO
 *
 * Author  april
 * Date    2018. 01. 28.
 */
@Data
public class OrderSubHistory {
	private Long sequence;
	private String orderNumber;
	private Integer serial;
	private String memo;
	private OrderStatusType status;
	private String modifiedId;
	private String insertedId;
	private LocalDateTime modifiedDate;
	private LocalDateTime insertedDate;
}