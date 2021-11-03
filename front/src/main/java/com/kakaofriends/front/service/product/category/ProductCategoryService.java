package com.kakaofriends.front.service.product.category;

import com.kakaofriends.front.domain.product.ProductCategoryData;
import com.kakaofriends.front.repository.product.category.ProductCategoryRepository;
import com.kakaofriends.front.service.product.vo.ProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductCategoryService
 *
 * Author  april
 * Date    2018. 1. 30.
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    @Transactional(readOnly = true)
    public ProductCategory get(String productCode) {
        ProductCategoryData data = productCategoryRepository.select(productCode);
        return this.converts(data);
    }

    private ProductCategory converts(ProductCategoryData data) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setSequence(data.getPrcSeq());
        productCategory.setProductCode(data.getPrcPrCode());
        productCategory.setCategorySequence(data.getPrcCtSeq());
        productCategory.setModifiedId(data.getPrcMoId());
        productCategory.setInsertedId(data.getPrcInId());
        productCategory.setModifiedDate(data.getPrcMoDate());
        productCategory.setInsertedDate(data.getPrcInDate());
        return productCategory;
    }
}
