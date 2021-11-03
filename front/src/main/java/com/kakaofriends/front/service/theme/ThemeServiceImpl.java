package com.kakaofriends.front.service.theme;

import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;
import com.kakaofriends.front.repository.theme.ThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ThemeServiceImpl
 * <p>
 * Author  layla
 * Date    2018. 6. 4.
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ThemeServiceImpl implements ThemeService {
    private ThemeRepository themeRepository;

    @Override
    public List<ThemeData> getThemeList(String language) {
        return themeRepository.getThemeList(language);
    }

    @Override
    public Map<String, List<ThemeProductData>> getThemeProductList(String ownerId, BigDecimal exchangeRate) {
        List<ThemeProductData> items = themeRepository.getThemeProductList(ownerId, exchangeRate);

        //group by Themecode
        Map<String, List<ThemeProductData>> productListGroupByThemeCode = items.stream().collect(Collectors.groupingBy(ThemeProductData::getThemeCode));
        //테마추천상품 크기 제어 추가
        productListGroupByThemeCode = productListGroupByThemeCode.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().stream().limit(6).collect(Collectors.toList())));
        return productListGroupByThemeCode;
    }
}
