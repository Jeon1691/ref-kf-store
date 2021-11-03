package com.kakaofriends.front.domain;

import com.kakaofriends.core.domain.GiftCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "gcmCode", "gcmName", "gcmSdate", "gcmEdate", "gcmPrice" })
public class GiftCardExpansion implements Serializable {
	private static final long serialVersionUID = -1473431908289180924L;

	private String gcmCode;
	private String gcmName;
	private Date gcmSdate;
	private Date gcmEdate;
	private int gcmPrice;
	private Boolean isUsePeriod;
	private Boolean isUsePeriodBefore;
	private Boolean isUsePeriodAfter;
	//쿠폰 등급 ( V : VIP, W(Welcome) : 일반사용자)
	private String gcmLevel;

    /**
     * 일반(A) : 가격제한 적용
     * 배송(D) : 배송비가 얼마이건 상관없이 무료 (DB에 가격 컬럼엔 금액이 없음 / 가격제한은 있을 수 있음)
     * 카테고리(C) : 타입을 C로 선택하고 가격제한에 금액을 넣으면 선택한 카테고리에서 할인가격 적용 (카테고리 별 무료배송은 존재하지 않음)
     */
	private String gcmOptionType;

	private GiftCard giftcard;

	public Boolean getIsUsePeriod() {
		LocalDate startDate = new LocalDate(gcmSdate).minusDays(1);
		LocalDate endDate = new LocalDate(gcmEdate).plusDays(1);
		LocalDate today = new LocalDate();
		return today.isAfter(startDate) && today.isBefore(endDate) && gcmSdate != null && gcmEdate != null;
	}

	public Boolean getIsUsePeriodBefore() {
		LocalDate startDate = new LocalDate(gcmSdate);
		LocalDate today = new LocalDate();
		return today.isBefore(startDate) && gcmSdate != null;
	}

	public Boolean getIsUsePeriodAfter() {
		LocalDate endDate = new LocalDate(gcmEdate);
		LocalDate today = new LocalDate();
		return today.isAfter(endDate) && gcmEdate != null;
	}


}