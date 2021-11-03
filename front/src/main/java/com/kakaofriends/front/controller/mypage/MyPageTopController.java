package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.core.common.configuration.persistence.typeHandler.ShippingStatusTypeHandler;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.service.mypage.MyPageTopService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMember;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
@Controller
public class MyPageTopController {

	@Autowired
	private MyPageTopService myPageTopService;

	private ShippingStatusTypeHandler shippingStatusTypeHandler = new ShippingStatusTypeHandler();

	//마이페이지 공통 상단
	@ModelAttribute("myInfoTop")
	public Map<String, Object> getMyInfoTop() {
		String ownerId = getFriendsMemberId();
		Member member = getFriendsMember();

		Map<String, Object> map = new HashedMap();
		map.put("myInfo", member);
		map.put("myPageTopData", myPageTopService.myPageTopData(ownerId, shippingStatusTypeHandler.getShippingCount(), shippingStatusTypeHandler.getCancelingCount()));

		return map;
	}
}