package com.kakaofriends.front.service.product.price;

import com.kakaofriends.front.domain.product.ProductLevelPriceData;
import com.kakaofriends.front.repository.ProductLevelPriceRepository;
import com.kakaofriends.front.service.product.vo.ProductLevelPrice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductLevelPriceServiceImpl
 *
 * Author  april
 * Date    2018. 1. 15.
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ProductLevelPriceServiceImpl implements ProductLevelPriceService {
    private ProductLevelPriceRepository productLevelPriceRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductLevelPrice get(String productCode) {
        ProductLevelPriceData data = productLevelPriceRepository.select(productCode);
        return this.converts(data);
    }

    private ProductLevelPrice converts(ProductLevelPriceData data) {
        ProductLevelPrice price = new ProductLevelPrice();
        price.setSequence(data.getPrlpSeq());
        price.setProductCode(data.getPrlpPrcode());
        price.setSupplyPrice(data.getPrlpSupplyprice());
        price.setSalesPrice(data.getPrlpSaleprice1());
        price.setDiscountedPrice(data.getPrlpDiscountprice1());
        price.setModifiedId(data.getPrlpMoid());
        price.setInsertedId(data.getPrlpInid());
        price.setModifiedDate(data.getPrlpModate());
        price.setInsertedDate(data.getPrlpIndate());
        return price;
    }
}
