package com.kakaofriends.front.repository.theme;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * ThemeRepository
 * <p>
 * Author  layla
 * Date    2018. 6. 4.
 */
@PrimaryMapper
@Repository
public interface ThemeRepository {
    List<ThemeData> getThemeList(String language);

    List<ThemeProductData> getThemeProductList(@Param("ownerId") String ownerId, @Param("exchangeRate") BigDecimal exchangeRate);
}
