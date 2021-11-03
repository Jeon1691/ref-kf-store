package com.kakaofriends.front.domain.instagram;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Pagination {

	@JsonProperty("next_url")
	private String nextUrl;

	@JsonProperty("next_max_id")
	private String next_max_id;
}