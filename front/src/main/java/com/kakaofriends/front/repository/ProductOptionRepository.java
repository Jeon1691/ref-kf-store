package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.ProductOptionDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface ProductOptionRepository {

	List<Product> productOptionFrontList(ProductOptionDto.ProductOptionRequest productOptionRequest);
}