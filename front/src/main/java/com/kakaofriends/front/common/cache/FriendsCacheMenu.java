package com.kakaofriends.front.common.cache;

import com.kakaofriends.front.domain.CategoryMenu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.FRIENDS_CATEGORY_CACHE_NAME;

@Component
public class FriendsCacheMenu {

	@Autowired
	FriendsCacheBuilder friendsCacheBuilder;

	public Map<String, String> getCategoryMap(HttpServletRequest request) {
		AntPathMatcher antPathMatcher = new AntPathMatcher();
		String servletPath = request.getServletPath();
		if (antPathMatcher.match("/**/categories/**", servletPath) || antPathMatcher.match("/**/characters/**", servletPath)) {
			return antPathMatcher.extractUriTemplateVariables("/{language}/products/groups/{ctGroup}/{ctSeq}/**", request.getServletPath());
		}
		return null;
	}

	public Boolean isCategoryGroup(Map<String, String> categoryMap, String type) {
		if (categoryMap == null) {
			return false;
		} else {
			String categoryGroup = categoryMap.get("ctGroup");
			return StringUtils.isNotEmpty(categoryGroup) && categoryGroup.equals(type);
		}
	}

	public CategoryMenu getCategoryMenuByParam(Long ctGroupNum2, String ctCodeParameterName) {
		Map<Long, List<CategoryMenu>> categoryMenuMap = friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME));
		List<CategoryMenu> categoryMenus = categoryMenuMap.get(ctGroupNum2);
		if (StringUtils.isEmpty(ctCodeParameterName)) {
			return null;
		} else {
			Optional<CategoryMenu> categoryMenu = categoryMenus.stream().filter(e -> e.getCtSeq().equals(Long.valueOf(ctCodeParameterName))).findFirst();
			return categoryMenu.get();
		}
	}
}