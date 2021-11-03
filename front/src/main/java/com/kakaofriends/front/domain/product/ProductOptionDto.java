package com.kakaofriends.front.domain.product;

import com.kakaofriends.front.domain.Friends;
import lombok.Data;

public class ProductOptionDto {

	@Data
	public static class ProductOptionRequest extends Friends {
		private String cpCode;
		private String propPrCode;
		private String propPrType;
		private Integer prStatus;
		private String prUse;
		private String prkrview;
		private String orderBy;
	}
}
