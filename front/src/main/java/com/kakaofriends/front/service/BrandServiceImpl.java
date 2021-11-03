package com.kakaofriends.front.service;

import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	@Override
	public List<ProductExpansion> findProductBrdRecommdation(String brandCode) {
		double exchangeRate = exchangeRateComponent.getExchangeRate();
		return brandRepository.findProductBrdRecommdation(brandCode, exchangeRate);
	}
}