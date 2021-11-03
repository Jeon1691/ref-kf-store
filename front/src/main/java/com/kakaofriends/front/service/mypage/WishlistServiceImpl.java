package com.kakaofriends.front.service.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.Wishlist;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.WishlistDto;
import com.kakaofriends.front.repository.WishlistRepository;
import com.kakaofriends.front.service.product.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	@Autowired
	ExchangeRateComponent exchangeRateComponent;

	@Autowired
	StockService stockService;

	@Override
	public int findCountByOwnerId(String ownerId) {
		return wishlistRepository.findCountByOwnerId(ownerId);
	}

	@Override
	public List<WishlistDto.WishlistExpansion> findByOwnerId(String ownerId, PaginationInfo pagination) {
		return wishlistRepository.findByOwnerId(ownerId, pagination, exchangeRateComponent.getExchangeRate());
	}

	public int insertProduct(WishlistDto.Request request) {
		String ownerId = getFriendsMemberId();
		request.setOwnerId(ownerId);
		if (null == wishlistRepository.findByOwnerIdPrCode(request)) {
			Wishlist wishlist = new Wishlist();
			wishlist.setWsOwnerId(ownerId);
			wishlist.setWsPrCode(request.getPrCode());
			wishlist.setWsCtseq(request.getCtSeq());
			wishlist.setWsInid(ownerId);
			wishlist.setWsMoid(ownerId);
			wishlist.setWsEa(1L);
			wishlist.setDisplayGoodsId(request.getDisplayGoodsId());
			return wishlistRepository.insertProduct(wishlist);
		}
		return 0;
	}

	@Override
	public int deleteProduct(WishlistDto.Request request) {
		request.setOwnerId(getFriendsMemberId());
		return wishlistRepository.deleteProduct(request);
	}
}
