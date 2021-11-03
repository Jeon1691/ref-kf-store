package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.product.ProductExpansion;

import java.util.List;

public interface BrandService {

	List<ProductExpansion> findProductBrdRecommdation(String brandCode);
}
