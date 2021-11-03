package com.kakaofriends.core.domain;

import lombok.Data;

@Data
public class Friend {
	private String name;
	private String gender;
	private String age;
	private String nick;
	private int page = 1;
}
