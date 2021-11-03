package com.kakaofriends.front.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GoodsOptionTitle
 * <p>
 * Author  layla
 * Date    2018. 8. 24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOptionTitle {
    private String name;
    private String nameEn;
    private Long goodsOptionId;
}
