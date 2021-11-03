package com.kakaofriends.front.domain;

import com.kakaofriends.core.domain.Promotion;
import com.kakaofriends.front.domain.product.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class PromotionExpansion {
	private Promotion promotion;
	private List<ProductDto.SuggestedProduct> suggestedProducts;
}
