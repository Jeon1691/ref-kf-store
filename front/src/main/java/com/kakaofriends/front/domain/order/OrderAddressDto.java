package com.kakaofriends.front.domain.order;

import com.kakaofriends.front.domain.Friends;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderAddressDto implements Serializable {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class request extends Friends implements Serializable {
		private String userId;
		private String oaOmNum;
		private String oaName;
		private String oaPhone;
		private String oaEmail;
		private String oaZoneCode;
		private String oaZipCode;
		private String oaAddr1;
		private String oaAddr2;
		private String oaAddr3;
		private String oaCountryCode;
		private String oaCountryName;
		private String oaDeliMemo = "";
		private String oaType;
		private Date oaInDate;
		private String oaOrderErTel;
		private String oaOrderErEmail = "";

        //주문자 정보
        private String oaBuyerName;
        private String oaBuyerPhone;
        private String oaBuyerEmail;
        private String oaBuyerCountryCode;
        private String oaBuyerCountryName;
	}
}
