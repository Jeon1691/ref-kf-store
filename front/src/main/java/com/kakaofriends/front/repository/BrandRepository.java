package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.ProductExpansion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface BrandRepository {

    List<ProductExpansion> findProductBrdRecommdation(@Param("brandCode") String brandCode, @Param("exchangeRate") double exchangeRate);
}
