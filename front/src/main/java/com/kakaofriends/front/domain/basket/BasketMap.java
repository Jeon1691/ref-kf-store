package com.kakaofriends.front.domain.basket;

import com.kakaofriends.core.domain.Basket;
import org.modelmapper.PropertyMap;

public class BasketMap extends PropertyMap<BasketDto.Request, Basket> {

	@Override
	protected void configure() {
		map().setBsPrCode(source.getPrCode());
		map().setBsEa(source.getPrEa());
		map().setBsCtSeq(source.getCtSeq());
	}
}
