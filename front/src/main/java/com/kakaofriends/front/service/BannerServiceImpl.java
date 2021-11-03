package com.kakaofriends.front.service;

import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import com.kakaofriends.front.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepository;

	public List<Banner> findByBannerAreas(List<BannerType> bannerTypes) {
		return bannerRepository.findByBannerAreas(bannerTypes);
	}

	@Override
	public List<Banner> findByBannerArea(String bannerArea) {
		return bannerRepository.findByBannerArea(bannerArea);
	}
}
