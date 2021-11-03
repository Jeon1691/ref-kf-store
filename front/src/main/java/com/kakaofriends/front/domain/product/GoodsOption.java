package com.kakaofriends.front.domain.product;

import com.kakaofriends.front.domain.SoldOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * GoodsOption
 * <p>
 * Author  layla
 * Date    2018. 8. 22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOption {
    private Long id;
    private String name;
    private String nameEn;
    private Long goodsId;
    private Long parentGoodsOptionId;
    private int sort;

    //차액 string으로 내려주기 (null일때 안내려보내기 위함) 2018.08.30 layla
    private String salePrice;
    private String exchangePrice;


    //품절 보여주기 위함 2018.09.03 layla
    private Boolean isSoldOut;
    //해외배송 2018.09.14 layla
    private String prForeigndeliyn;
}
