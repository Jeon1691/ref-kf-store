package com.kakaofriends.front.domain.instagram;

import lombok.*;

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	String url;
	Integer width;
	Integer height;
}
