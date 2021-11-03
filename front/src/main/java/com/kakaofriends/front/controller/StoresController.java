package com.kakaofriends.front.controller;

import com.kakaofriends.core.domain.Store;
import com.kakaofriends.core.domain.StoreArea;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.service.BannerService;
import com.kakaofriends.front.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class StoresController {

	@Autowired
	private StoreService storesService;

	@Autowired
	private BannerService bannerService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ModelMapper modelMapper;

	private Collector<Store, ?, Map<StoreArea, List<Store>>> storeMapCollector = Collectors.groupingBy(Store::getStoreArea);
	private Collector<Map.Entry<StoreArea, List<Store>>, ?, LinkedHashMap<StoreArea, List<Store>>> entryLinkedHashMapCollector = Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new);

	@RequestMapping(value = "/stores/{areaPath}")
	public ModelAndView stores(@PathVariable(value = "language") String language, @PathVariable(value = "areaPath") String areaPath) throws IOException {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/"+language+"/info/storeInfo");
		return mav;
	}

	private Map<StoreArea, List<Store>> getSortByAreaNum(List<Store> stores) {
		return stores.stream().collect(storeMapCollector).entrySet().stream().sorted(Map.Entry.comparingByKey((e1, e2) -> e1.getStaNum().compareTo(e2.getStaNum()))).collect(entryLinkedHashMapCollector);
	}
}