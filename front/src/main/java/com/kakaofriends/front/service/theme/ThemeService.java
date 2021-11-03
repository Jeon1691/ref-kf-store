package com.kakaofriends.front.service.theme;

import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * ThemeService
 * <p>
 * Author  layla
 * Date    2018. 6. 4.
 */
public interface ThemeService {
    /*
    * 테마 정보 리스트
    * */
    List<ThemeData> getThemeList(String language);
    /*
     * 테마 연관상품 리스트
     * */
    Map<String, List<ThemeProductData>> getThemeProductList(String ownerId, BigDecimal exchangeRate);
}
