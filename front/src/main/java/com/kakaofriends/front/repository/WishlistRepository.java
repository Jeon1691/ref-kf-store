package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.Wishlist;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.WishlistDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface WishlistRepository {

	int findCountByOwnerId(String ownerId);

	List<WishlistDto.WishlistExpansion> findByOwnerId(@Param("ownerId") String ownerId, @Param("pagination") PaginationInfo pagination, @Param("exchangeRate") double exchangeRate);

	Wishlist findByOwnerIdPrCode(WishlistDto.Request request);

	int insertProduct(Wishlist wishlist);

	int deleteProduct(WishlistDto.Request request);
}
