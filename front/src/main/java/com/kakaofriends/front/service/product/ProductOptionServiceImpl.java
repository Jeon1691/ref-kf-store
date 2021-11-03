package com.kakaofriends.front.service.product;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.domain.product.ProductOptionDto;
import com.kakaofriends.front.repository.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {

	@Autowired
	private ProductOptionRepository productoptionRepository;

	@Override
	public List<Product> productOptionFrontList(ProductOptionDto.ProductOptionRequest productOptionRequest) {
		return productoptionRepository.productOptionFrontList(productOptionRequest);
	}
}
