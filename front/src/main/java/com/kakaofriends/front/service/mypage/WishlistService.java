package com.kakaofriends.front.service.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.WishlistDto;

import java.util.List;

public interface WishlistService {

	int findCountByOwnerId(String memberId);

	List<WishlistDto.WishlistExpansion> findByOwnerId(String ownerId, PaginationInfo pagination);

	int insertProduct(WishlistDto.Request request);

	int deleteProduct(WishlistDto.Request request);
}
