package com.kakaofriends.front.domain;

import com.kakaofriends.front.common.configuration.persistence.type.BoardType;
import com.kakaofriends.front.common.configuration.persistence.type.SortType;
import lombok.Data;

@Data
public class FriendsListing extends Friends {
	private Integer pageIndex = 1;
	private SortType sort = SortType.NEW;
	private BoardType boardType = BoardType.BNOTICE;
	private Integer boardCategory = null;
	private String filter = null;
}
