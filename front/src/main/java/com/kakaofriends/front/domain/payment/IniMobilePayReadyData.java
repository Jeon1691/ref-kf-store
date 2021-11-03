package com.kakaofriends.front.domain.payment;

/**
 * Created by genius on 2016. 11. 2..
 */
public class IniMobilePayReadyData extends IniPayResultData {

	private static final long serialVersionUID = 7917774584251937090L;
	private boolean ready;
	private String resultCode;
	private String resultMessage;
	private String giftCardNumber;
	private Long giftCardAmount;
	private Long paymentAmount;
	private String oId;
	private Long pointPrice;

	public IniMobilePayReadyData(boolean ready, String resultCode, String resultMessage, String oId) {
		this.ready = ready;
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.oId = oId;
	}

}
