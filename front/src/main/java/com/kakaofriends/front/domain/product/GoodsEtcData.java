package com.kakaofriends.front.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GoodsEtcData
 * <p>
 * Author  layla
 * Date    2018. 8. 22.
 * 전시상품 상세화면에서
 * 상품 리스트 조회 시에 따로 조회 해 올
 * 해외배송여부 / 재고
 * ps.
 * 상품리스트에서 각 옵션이 있을시엔 SUM을 해야하고
 * 단품일 경우엔 SUM이 필요 없어 따로 조회해 옴
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsEtcData {
    private int foreigndeliCheck;
    private int stZeroCheck;

    /* 단품일 경우 제품의 정보를 불러와서 Goods에 Set
    * 2018.09.03 layla
    * */
    private String discountsDate;
    private String discounteDate;
    private Integer salePrice;
    private Integer discountPrice;

    public Boolean getIsSoldOut() {
        return 1 > getStZeroCheck();
    }
}
