package com.kakaofriends.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubInfo {
	private String gnbFriends;
	private String backgroundColor;
	private String subIntroImage;
	private String subTitle;
	private String subEmpth;
}