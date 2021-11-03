package com.kakaofriends.front.domain;

import lombok.Data;

public class StoreDto {

	@Data
	public static class StoreMapInfo {
		private Long stSeq;
		private String stMapx;
		private String stMapy;
	}
}
