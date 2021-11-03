package com.kakaofriends.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionInfo {
	private String siId;
	private String siIp;
	private String siAgent;
	private Date siIndate;
}