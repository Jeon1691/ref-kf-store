package com.kakaofriends.front.controller;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.configuration.persistence.type.SortType;
import com.kakaofriends.front.domain.SearchEngine;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.service.product.DisplayGoodsService;
import com.kakaofriends.front.service.product.ProductService;
import com.kakaofriends.front.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.stringConcatPath;

@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
@Slf4j
public class SearchController {

	@Autowired
	private ProductService productService;
	@Autowired
	private DisplayGoodsService displayGoodsService;

	@RequestMapping(value = {"/search", "/search/pages/{pageIndex}"})
	public ModelAndView getProductBySearchKeyword( ProductDto.SearchRequest searchRequest, HttpServletRequest request ) {

        log.info( "Kakao => session['kakaotalkAgent'] : {}", request.getHeader( "kakaotalk-agent" ) );
        log.info( "Kakao => header['kakaotalk-agent'] : {}", request.getSession().getAttribute( "kakaotalkAgent" ) );


		searchRequest.setPrTypeArray(new String[]{"1", "3", "5"});
		searchRequest.setPrStatus(1);
		searchRequest.setCtUse("Y");
		searchRequest.setPrUse("Y");
		//searchRequest.setPrLanguageViewColumn("PR_KRVIEW");
		searchRequest.setPrLanguageViewColumn("KRVIEW");
		searchRequest.setPrLanguageView("Y");
		searchRequest.setOwnerId(getFriendsMemberId());

		/*
		List<String> strList = Arrays.stream(searchRequest.getKeyword().split(" ")).filter(e -> !StringUtils.trimAllWhitespace(e).isEmpty()).collect(toList());
		searchRequest.setKeywords(strList.size() > 0 ? strList : null);
		*/
		searchRequest.setKeyword(searchRequest.getKeyword().trim().replace(" ", ""));

		Integer totalCount = displayGoodsService.findProductCountByName(searchRequest);
		PaginationInfo pagination = getPaginationInfo(totalCount, searchRequest.getPageIndex(), KakaoFriendsConstants.pageUnit, KakaoFriendsConstants.pageSize);

		List<ProductExpansion> productExpansions = displayGoodsService.findProductsByName(searchRequest, pagination);

		ModelAndView mav = new ModelAndView();
		mav.addObject("totalCount", totalCount);
		mav.addObject("productExpansions", productExpansions);
		mav.addObject("sortTypes", SortType.values());
		mav.addObject("searchRequest", searchRequest);
		mav.addObject("pagination", pagination);
		mav.addObject("pageLink", stringConcatPath("", searchRequest.getLanguage(), "search"));
		DateUtil dateUtil = new DateUtil();
		mav.addObject("today", dateUtil.getDateyyyyMMddHHmm());
		mav.setViewName(searchRequest.getLanguage() + "/search/list");
		return mav;
	}

	//todo 뭐하는애지?????
	@RequestMapping(value="/fakeSearchEngine")
	public void fakeSearchEngine(){
		List<SearchEngine> products = productService.getCategoryName();
		int result = 0;

		for(SearchEngine product : products) {
			String content = "";
			List<String> characters = new ArrayList<String>();
			List<String> keywords = new ArrayList<String>();


			// make searchword
			String categoryName = product.getPrContent();
			//String categoryString = "카카오프렌즈>캐릭터>제이지,카테고리>문구>카드/엽서";

			String[] categorys;
			if(categoryName != null) {
				categorys =  categoryName.split(",");
			} else {
				
				continue;
			}

			for(String category : categorys) {
				if(category.indexOf("캐릭터") > 0) {
					characters.add(category.substring(category.indexOf("캐릭터") + 4));
				} else {
					String[] split_1 = category.split(">");
					for(String temp : split_1) {
						if(temp.indexOf("/") > 0) {
							String[] temp2 = temp.split("/");
							for(String temp3 : temp2) {
								keywords.add(temp3);
							}
						} else {
							keywords.add(temp);
						}
					}
				}
			}

			for(String character : characters) {
				for(String keyword : keywords) {
					content += "," + character + keyword;
				}
			}
			SearchEngine pProduct = new SearchEngine();
			pProduct.setPrCode(product.getPrCode());
			pProduct.setPrContent(product.getPrSearchword()+content);
			result += productService.updateSearchWord(pProduct);
		}
		log.debug("SEARCH WORD UPDATE RESULT : " + result);
	}

	public static void main(String[] args) {
		String content = "";
		List<String> characters = new ArrayList<String>();
		List<String> keywords = new ArrayList<String>();
		Product pProduct = new Product();
		//pProduct.setPrCode(product.getPrCode());

		// make searchword
		// String categoryName = product.getPrContent();
		String categoryString = "카카오프렌즈>캐릭터>프로도,카카오프렌즈>캐릭터>네오,카테고리>문구>카드/엽서";

		String[] categorys =  categoryString.split(",");

		for(String category : categorys) {
			if(category.indexOf("캐릭터") > 0) {
				characters.add(category.substring(category.indexOf("캐릭터")+4));
			} else {
				String[] split_1 = category.split(">");
				for(String temp : split_1) {
					if(temp.indexOf("/") > 0) {
						String[] temp2 = temp.split("/");
						for(String temp3 : temp2) {
							keywords.add(temp3);
						}
					} else {
						keywords.add(temp);
					}
				}
			}
		}

		for(String character : characters) {
			for(String keyword : keywords) {
				content += "," + character + keyword ;
			}
		}
		System.out.println(content);
	}
}