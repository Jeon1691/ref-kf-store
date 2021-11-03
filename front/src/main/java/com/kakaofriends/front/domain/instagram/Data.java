package com.kakaofriends.front.domain.instagram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@lombok.Data
public class Data {
	private String[] tags;
	private String link;
	private Images images;
}