package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;
import com.kakaofriends.front.repository.theme.ThemeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TestThemeService
 * <p>
 * Author  layla
 * Date    2018. 6. 4.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Test
    public void select() {
        List<ThemeData> list = themeRepository.getThemeList("kr");
        System.out.println(list.size());
        for (ThemeData dd : list) {
            System.out.println(dd.toString());
        }
    }

    @Test
    public void getThemeProduct() {
        List<ThemeProductData> list = themeRepository.getThemeProductList("6", getExchangeRate());
        System.out.println(list.size());
    }

    @Test
    public void selectGroupByThemeWithProduct() {
        List<ThemeProductData> items = themeRepository.getThemeProductList("6", getExchangeRate());
        System.out.println(items.size());

        //group by Themecode
        Map<String, List<ThemeProductData>> productListGroupByThemeCode = items.stream().collect(Collectors.groupingBy(ThemeProductData::getThemeCode));
        //테마추천상품 크기 제어 추가
        productListGroupByThemeCode = productListGroupByThemeCode.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().stream().limit(6).collect(Collectors.toList())));

        System.out.println(productListGroupByThemeCode.size());
        System.out.println(productListGroupByThemeCode.keySet());
        System.out.println(productListGroupByThemeCode);
    }

    @Test
    public void removeNoItem() {
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("4");

        Set<String> set2 = new HashSet<String>();
        set2.add("3");
        set2.add("2");

        set2.retainAll(set);
        System.out.println(set2);
        System.out.println(set);
        set.clear();
    }

    @Test
    public void removeNoItemTheme() {
        List<ThemeData> themeDataList = themeRepository.getThemeList("kr");
        List<ThemeData> themeList = new ArrayList<>();

        List<ThemeProductData> items = themeRepository.getThemeProductList("6", getExchangeRate());
        Map<String, List<ThemeProductData>> productListGroupByThemeCode = items.stream().collect(Collectors.groupingBy(ThemeProductData::getThemeCode));
        productListGroupByThemeCode = productListGroupByThemeCode.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().stream().limit(6).collect(Collectors.toList())));
        List<String> themeProductkeySet = new ArrayList<String>(productListGroupByThemeCode.keySet());

        System.out.println(themeDataList.size());
        System.out.println(themeProductkeySet.size());

        for (ThemeData themeData : themeDataList) {
            for (String themeProductKey : themeProductkeySet) {
                if (themeData.getThemeCode().equals(themeProductKey)) {
                    themeList.add(themeData);
                }
            }
        }

        System.out.println(themeList.toString());
    }

    private BigDecimal getExchangeRate() {
        BigDecimal bigDecimal = BigDecimal.valueOf(1131.1099853515625);
        DecimalFormat df = new DecimalFormat("#,###");
        df.format(bigDecimal);

        System.out.println(df.format(bigDecimal));
        return bigDecimal;
    }
}
