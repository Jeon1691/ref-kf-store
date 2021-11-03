package com.kakaofriends.front.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.kakaofriends.front.common.external.InstagramComponent;
import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.domain.instagram.Instagram;
import com.kakaofriends.front.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

@Component
public class FriendsCacheBuilder {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private InstagramComponent instagramComponent;

	@Autowired
	private FriendsCacheKeyBuilder friendsCacheKeyBuilder;

	Function<List<CategoryMenu>, Map<Long, List<CategoryMenu>>> categoryMenuCacheFunction = (categoryMenus) -> categoryService.getCategoryGroupingByCtRoot(categoryMenus);

	public final Cache<String, Map<Long, List<CategoryMenu>>> categoryMenuCache = CacheBuilder.newBuilder().expireAfterWrite(FRIENDS_CATEGORY_MENU_CACHE_EXPIRE_DURATION, TimeUnit.MINUTES).build();

	private final Map<String, Function<List<CategoryMenu>, Map<Long, List<CategoryMenu>>>> CategoryMenuCacheBuilderMap = ImmutableMap.of(FRIENDS_CATEGORY_CACHE_NAME, categoryMenuCacheFunction);

	public void buildCategoryMenuCache(Instant instant) {
		final List<CategoryMenu> categoryMenus = categoryService.findMenuCategory();
		CategoryMenuCacheBuilderMap.forEach((key, value) -> {
			categoryMenuCache.put(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(instant, key, TimeUnit.MINUTES, FRIENDS_CATEGORY_MENU_CACHE_PERIOD), value.apply(categoryMenus));
		});
	}

	public final Cache<String, Instagram> instagramCache = CacheBuilder.newBuilder().expireAfterWrite(FRIENDS_INSTAGRAM_CACHE_EXPIRE_DURATION, TimeUnit.HOURS).build();

	public void buildInstagramCache(Instant instant) {
		final Instagram friendsOfficialInstagram = instagramComponent.friendsInstagram();
		final Instagram friendsLabInstagram = instagramComponent.friendsLabInstagram();
		instagramCache.put(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(instant, FRIENDS_OFFICIAL_INSTAGRAM_CACHE_NAME, TimeUnit.HOURS, FRIENDS_INSTAGRAM_CACHE_PERIOD), friendsOfficialInstagram);
		instagramCache.put(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(instant, FRIENDS_LAB_INSTAGRAM_CACHE_NAME, TimeUnit.HOURS, FRIENDS_INSTAGRAM_CACHE_PERIOD), friendsLabInstagram);
	}

	public String getCacheKey(Instant instant, String cacheKey) {
		return friendsCacheKeyBuilder.getTimeUnitWithTimestamp(instant, cacheKey, TimeUnit.MINUTES, FRIENDS_CATEGORY_MENU_CACHE_PERIOD);
	}

	public String getCacheKey(Instant instant, String cacheKey, TimeUnit timeUnit, long duration) {
		return friendsCacheKeyBuilder.getTimeUnitWithTimestamp(instant, cacheKey, timeUnit, duration);
	}
}