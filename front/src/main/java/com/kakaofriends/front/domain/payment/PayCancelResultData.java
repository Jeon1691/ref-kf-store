package com.kakaofriends.front.domain.payment;

import lombok.Data;

@Data
public class PayCancelResultData {
	String resultCode;
	String resultMsg;
	String cancelAmt;
	String cancelDate;
	String cancelTime;
	String cancelNum;
	String payMethod;
	String mid;
	String tid;
	String errorCD;
	String errorMsg;
	String AuthDate;
	String stateCD;
	String ccPartCl;
	boolean isCancelSuccess;
}