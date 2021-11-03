package com.kakaofriends.front.service.product;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.SearchEngine;
import com.kakaofriends.front.domain.product.ProductData;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.domain.product.RecommendationBanner;
import com.kakaofriends.front.repository.ProductRepository;
import com.kakaofriends.front.service.product.category.ProductCategoryService;
import com.kakaofriends.front.service.product.price.ProductLevelPriceService;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.vo.Product;
import com.kakaofriends.front.service.product.vo.ProductLevelPrice;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;


@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	private ExchangeRateComponent exchangeRateComponent;

	private ProductLevelPriceService productLevelPriceService;

	private ProductCategoryService productCategoryService;

	private final String discountDateFormat = "yyyy-MM-dd";

	private StockService stockService;

	@Override
	public int findProductCountByCategoryWithCharacter(ProductDto.ProductRequest productRequest) {
		return productRepository.findProductCountByCategoryWithCharacter(productRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByCategoryWithCharacter(ProductDto.ProductRequest productRequest, PaginationInfo pagination) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductsByCategoryWithCharacter(productRequest, pagination);
	}

	@Override
	public int findProductCountByCategoryGroup(ProductDto.ProductRequest productRequest) {
		return productRepository.findProductCountByCategoryGroup(productRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByCategoryGroup(ProductDto.ProductRequest productRequest, PaginationInfo pagination) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductsByCategoryGroup(productRequest, pagination);
	}

	@Override
	public ProductExpansion findProductDetailByProductRequest(ProductDto.ProductRequest productRequest) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductDetailByProductRequest(productRequest);
	}

	@Override
	public List<ProductDto.SuggestedProduct> findSuggestedProductsByProductCode(ProductDto.ProductRequest productRequest) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findSuggestedProductsByProductCode(productRequest);
	}

	@Override
	public int findProductCountByName(ProductDto.SearchRequest searchRequest) {
		return productRepository.findProductCountByName(searchRequest);
	}

	@Override
	public List<ProductExpansion> findProductsByName(ProductDto.SearchRequest searchRequest, PaginationInfo pagination) {
		searchRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductsByName(searchRequest, pagination);
	}

	@Override
	public List<ProductExpansion> findProductByNewBest(ProductDto.ProductRequest productRequest) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductByNewBest(productRequest);
	}

	@Override
	public int updateProductForContentImageSrc() {
		List<com.kakaofriends.core.domain.Product> products = productRepository.findProductForContent();
		products.parallelStream().forEach(
				e -> {
					e.setPrContent(e.getPrContent().replace("http://t1.daumcdn.net/friends/test/editor/kakaofriends", "https://t1.daumcdn.net/friends/prod/editor/kakaofriends"));
					//System.out.println(e.getPrContent());
					productRepository.updateProductForContentImageSrc(e);
				}
		);
		return 0;
	}

	@Override
	public ProductExpansion findProductByProductCode(String prCode) {
		//장바구니, 주문 쪽에서 국가별 재고조회로 필요하다면 국가 받아와야함 [현재는 category조회, 커스텀상품 유무 확인용으로만 사용중] 2018.3.19
		return productRepository.findProductByProductCode(prCode, exchangeRateComponent.getExchangeRate());
	}

	@Override
	public List<ProductExpansion> findProductByCharacter(ProductDto.ProductRequest productRequest) {
		productRequest.setExchangeRate(exchangeRateComponent.getExchangeRate());
		return productRepository.findProductByCharacter(productRequest);
	}

	@Override
    public List<RecommendationBanner> findRecommendationBanner(String language) {
        return productRepository.findRecommendationBanner(language);
    }

	@Override
	public List<ProductExpansion> findProductForOhMyFriends() {
		return productRepository.findProductForOhMyFriends();
	}

	@Override
    public List<Integer> findProductCategoryCode(List<String> bsPrCodes) {
	    return productRepository.findProductCategoryCode(bsPrCodes);
    }

	// 곧 지워야 할 Fake Search Engine
	public List<SearchEngine> getCategoryName () {
		return productRepository.getCategoryName();
	}

	public int updateSearchWord(SearchEngine searchEngine) {
		return productRepository.updateSearchWord(searchEngine);
	}

	@Override
	@Transactional(readOnly = true)
	public Product get(String productCode) {
		ProductData data = productRepository.selectByProductCode(productCode);
		Product product = this.converts(data);
//		ProductCategory productCategory = productCategoryService.get(productCode); too many result 확인
//		product.setCategorySequence(productCategory.getCategorySequence());
		return product;
	}

	@Override
	@Transactional(readOnly = true)
	public Product getWithPrice(String productCode) {
		Product product = this.get(productCode);
		ProductLevelPrice levelPrice = productLevelPriceService.get(productCode);

		product.setOriginalPrice(levelPrice.getSalesPrice());
		product.setCurrentPrice(levelPrice.getSalesPrice());

		if (product.isDiscount() && levelPrice.getDiscountedPrice().compareTo(BigDecimal.ZERO) > 0) {
			product.setCurrentPrice(levelPrice.getDiscountedPrice());
		}
		return product;
	}

	private Product converts(ProductData data) {
		Product product = new Product();
		product.setSequence(data.getPrSeq());
		product.setProductCode(data.getPrCode());
		product.setKoreanName(data.getPrName());
		product.setEnglishName(data.getPrName1());
		product.setScpType(data.getPrScpType());
		product.setScpCode(data.getPrScpCode());
		product.setItemKoreanName(data.getPrItemName1());
		product.setItemEnglishName(data.getPrItemName2());
		product.setBarcode(data.getPrBarcode());
		product.setManufacturer(data.getPrManufacture());
		product.setCountryName(data.getPrCountry());
		product.setMinBuyableEa(data.getPrMinBuyEa());
		product.setForeignDeliveryYn(data.getPrForeignDeliYn());
		product.setWeight(data.getPrWeight());
		product.setStandard(data.getPrStandard());
		product.setStandard1(data.getPrStandard1());
		product.setVolume1(data.getPrVolume1());
		product.setVolume2(data.getPrVolume2());
		product.setVolume3(data.getPrVolume3());
		product.setColor(data.getPrColor());
		product.setImage1(data.getPrImage1());
		product.setImage2(data.getPrImage2());
		product.setImage3(data.getPrImage3());
		product.setImage4(data.getPrImage4());
		product.setImage5(data.getPrImage5());
		product.setImage6(data.getPrImage6());
		product.setImage7(data.getPrImage7());
		product.setImage8(data.getPrImage8());
		product.setImage9(data.getPrImage9());
		product.setImage10(data.getPrImage10());
		product.setImage11(data.getPrImage11());
		product.setImage12(data.getPrImage12());
		product.setInfo(data.getPrInfo());
		product.setInfo1(data.getPrInfo1());
		product.setView1(data.getPrView1());
		product.setView2(data.getPrView2());
		product.setView3(data.getPrView3());
		product.setView4(data.getPrView4());
		product.setView5(data.getPrView5());
		product.setView6(data.getPrView6());
		product.setContent(data.getPrContent());
		product.setContent(data.getPrContent1());
		product.setSearchWord(data.getPrSearchWord());
		product.setStatus(data.getPrStatus());
		product.setNewYn(data.getPrNew());
		product.setHotYn(data.getPrHot());
		product.setOrder(data.getPrOrder());
		product.setKrView(Usable.get(data.getPrKrView()));
		product.setType(data.getPrType());
		product.setUseYn(data.getPrUse());
		product.setModifiedId(data.getPrMoid());
		product.setInsertedId(data.getPrInid());
		product.setModifiedDate(data.getPrModate());
		product.setInsertedDate(data.getPrIndate());
		product.setHeight(data.getPrHeight());
		product.setWidth(data.getPrWidth());
		product.setDepth(data.getPrDepth());
		LocalDateTime startDate = this.convertsToStartLocalDateTime(data.getPrDiscountSDate());
		LocalDateTime endDate = this.convertsToEndLocalDateTime(data.getPrDiscountEDate());
		product.setDiscountStartDate(startDate);
		product.setDiscountEndDate(endDate);
		return product;
	}

	private LocalDateTime convertsToStartLocalDateTime(String dateString) {
		if (StringUtils.isNotBlank(dateString)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(discountDateFormat);
			DateTimeFormatterBuilder startBuilder = new DateTimeFormatterBuilder().append(formatter);
			startBuilder.parseDefaulting(ChronoField.HOUR_OF_DAY, 0);
			startBuilder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0);
			startBuilder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);
			DateTimeFormatter startTimeFormat = startBuilder.toFormatter();
			return LocalDateTime.parse(dateString, startTimeFormat);
		}
		return null;
	}

	private LocalDateTime convertsToEndLocalDateTime(String dateString) {
		if (StringUtils.isNotBlank(dateString)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(discountDateFormat);
			DateTimeFormatterBuilder endBuilder = new DateTimeFormatterBuilder().append(formatter);
			endBuilder.parseDefaulting(ChronoField.HOUR_OF_DAY, 23);
			endBuilder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 59);
			endBuilder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 59);
			DateTimeFormatter endTimeFormat = endBuilder.toFormatter();
			return LocalDateTime.parse(dateString, endTimeFormat);
		}
		return null;
	}
}