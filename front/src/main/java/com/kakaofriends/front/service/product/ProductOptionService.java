package com.kakaofriends.front.service.product;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.domain.product.ProductOptionDto;

import java.util.List;

public interface ProductOptionService {

	List<Product> productOptionFrontList(ProductOptionDto.ProductOptionRequest productOptionRequest);

}
