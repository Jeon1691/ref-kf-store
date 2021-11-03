package com.kakaofriends.front.service;

import com.kakaofriends.front.common.cache.FriendsCacheBuilder;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.FRIENDS_CATEGORY_CACHE_NAME;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.FRIENDS_CATEGORY_THEME_CODE;

/**
 * CategoryTest
 * <p>
 * Author  layla
 * Date    2018. 5. 14.
 */
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FriendsCacheBuilder friendsCacheBuilder;

    @Test
    public void select() {
        System.out.println(categoryRepository.findMenuCategory());
    }

    @Test
    public void selectGnbTheme() {
        Map<Long, List<CategoryMenu>> test = friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME))
                .entrySet().stream().flatMap(e -> e.getValue().stream()).filter(e -> (e.getCtNode() > 1L && e.getCtPcode() == FRIENDS_CATEGORY_THEME_CODE)).collect(Collectors.groupingBy(e -> e.getCtPcode()));
        System.out.println(test.get(FRIENDS_CATEGORY_THEME_CODE));
    }

    @Test
    public void getGnbFriendsTheme() {
        Map<Long, List<CategoryMenu>> gnbThemeList = friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME))
                .entrySet().stream().flatMap(e -> e.getValue().stream()).filter(e -> (e.getCtNode() > 1L && e.getCtPcode() == FRIENDS_CATEGORY_THEME_CODE)).collect(Collectors.groupingBy(e -> e.getCtPcode()));
        System.out.println(gnbThemeList.get(FRIENDS_CATEGORY_THEME_CODE));
    }
}
