package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface BannerRepository {

	List<Banner> findByBannerAreas(@Param("bannerTypes") List<BannerType> bannerTypes);

	List<Banner> findByBannerArea(@Param("bannerArea") String bannerArea);
}