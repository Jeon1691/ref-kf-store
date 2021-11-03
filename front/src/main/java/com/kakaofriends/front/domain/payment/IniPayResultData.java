package com.kakaofriends.front.domain.payment;

import lombok.Data;

@Data
public class IniPayResultData {
	private String tid;
	private String ResultCode;
	private String ResultMsg;
	private String MOID;
	private String ApplDate;
	private String ApplTime;
	private String ApplNum;
	private String PayMethod;
	private String TotPrice;
	private String EventCode;

	private String CARD_Num;
	private String CARD_Interest;
	private String CARD_Quota;
	private String CARD_Code;
	private String CARD_BankCode;
	private String CARD_AuthType;
	private String OrgCurrency;
	private String ExchangeRate;
	private String CARD_CheckFlag;

	private String ACCT_BankCode;
	private String CSHR_ResultCode;
	private String CSHR_Type;

	private String buyername;
}
