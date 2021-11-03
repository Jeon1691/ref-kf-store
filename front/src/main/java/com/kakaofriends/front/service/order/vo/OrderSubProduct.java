package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.front.service.product.vo.Product;
import lombok.Data;

/**
 * OrderSubProduct :
 * 주문 상세 건과 상품을 매핑하는 vo
 *
 * Author  april
 * Date    2018. 1. 31.
 */
@Data
public class OrderSubProduct {
    private OrderSub orderSub;
    private Product product;
}
