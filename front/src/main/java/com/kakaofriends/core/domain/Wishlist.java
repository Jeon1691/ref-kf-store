package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wishlist {
	private Long wsSeq;
	private String wsOwnerId;
	private String wsPrCode;
	private String wsProption;
	private Long wsEa;
	private String wsEtc1;
	private String wsEtc2;
	private String wsEtc3;
	private String wsEtc4;
	private String wsEtc5;
	private Long wsCtseq;
	private String wsLevel;
	private String wsType;
	private String wsUse;
	private String wsMoid;
	private String wsInid;
	private Date wsModate;
	private Date wsIndate;
	private Long displayGoodsId; //2018.08.23 전시상품코드 추가
}