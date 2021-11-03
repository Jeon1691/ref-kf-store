package com.kakaofriends.front.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CnsPayRequestDealApproveData {

	@JsonProperty("RESULT_CODE")
	private String resultCode;

	@JsonProperty("RESULT_MSG")
	private String resultMsg;

	@JsonProperty("MERCHANT_TXN_NUM")
	private String merchantTxnNum;

	@JsonProperty("TXN_ID")
	private String txnId;

	@JsonProperty("PR_DT")
	private String prDt;
}