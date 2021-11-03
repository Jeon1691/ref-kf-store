package com.kakaofriends.front.domain.product;

import com.kakaofriends.core.domain.Category;
import com.kakaofriends.core.domain.ProductDisplay;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.domain.SoldOut;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_GIFT_BAG;

/**
 * DisplayGoodsGroup
 * <p>
 * Author  layla
 * Date    2018. 8. 20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayGoodsGroup {
    private List<Goods> mainGoodsList; //메인상품 리스트
    private List<Goods> subGoodsList; //추가상품 리스트

    private List<GoodsOptionTitle> mainGoodsOptionTitleList; //메인상품 옵션 타이틀 리스트
    private List<GoodsOption> mainGoodsOptionList; //메인상품 옵션 리스트
    private List<GoodsOptionTitle> subGoodsOptionTitleList; //추가상품 옵션 타이틀 리스트
    private List<GoodsOption> subGoodsOptionList; //추가상품 옵션 리스트


    private Boolean isHasOption; //하나라도 옵션이 있으면 true
}