package com.kakaofriends.front.domain.instagram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@lombok.Data
public class Images {

	@JsonProperty("low_resolution")
	private Image lowResolution;

	@JsonProperty("thumbnail")
	private Image thumbnail;

	@JsonProperty("standard_resolution")
	private Image standardResolution;
}
