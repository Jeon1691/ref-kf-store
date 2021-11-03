package com.kakaofriends.front.domain.kims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by genius on 2016. 10. 7..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortMessageServiceDto {
	private String callerNumber;
	private String receiverNumber;
	private String countryCode = "82";
	private String message;
	private String type = "normal";
}
