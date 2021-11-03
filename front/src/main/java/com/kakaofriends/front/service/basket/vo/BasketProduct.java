package com.kakaofriends.front.service.basket.vo;

import com.kakaofriends.front.service.product.vo.Product;
import lombok.Data;

import java.math.BigDecimal;

/**
 * BasketProduct : 장바구니와 상품의 매핑 클래스
 *
 * Author  april
 * Date    2018. 1. 15.
 */
@Data
public class BasketProduct {
    private Basket basket;
    private Product product;

    public BigDecimal getPrice() {
        if (basket != null && product != null) {
            int ea = this.basket.getEa();
            BigDecimal productPrice = this.product.getCurrentPrice();
            return productPrice.multiply(new BigDecimal(ea));
        }
       return null;
    }

    public double getWeight() {
        if (basket != null && product != null) {
            int ea = this.basket.getEa();
            double productWeight = this.product.getWeight();
            return productWeight * ea;
        }
        return 0;
    }
}
