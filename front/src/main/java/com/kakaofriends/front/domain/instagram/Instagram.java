package com.kakaofriends.front.domain.instagram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Instagram {
	private Pagination pagination;
	private Meta meta;
	private Data[] data;
}