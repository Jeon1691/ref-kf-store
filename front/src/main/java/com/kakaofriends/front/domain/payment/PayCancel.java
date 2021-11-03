package com.kakaofriends.front.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayCancel {
	private String tid;
	private String cancelAmt;
	private PartialCancelCode partialCancelCode;	// 전체 취소 : 0 , 부분 취소 : 1
	private String message;
}
