package com.kakaofriends.front.service;

import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;

import java.util.List;

public interface BannerService {

	List<Banner> findByBannerAreas(List<BannerType> bannerTypes);

	List<Banner> findByBannerArea(String bannerArea);
}
