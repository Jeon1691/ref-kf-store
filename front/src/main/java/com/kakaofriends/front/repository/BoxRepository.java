package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.BoxItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dave on 2017. 4. 28..
 */

@PrimaryMapper
@Repository
public interface BoxRepository {
    int orderBoxInsert(@Param("box") BoxItem box);
    int orderItemInsert(@Param("item") BoxItem item);

    void orderBoxItemDeleteByOrderNum(String omNum);
    void orderBoxDeleteByOrderNum(String omNum);

    List<BoxItem> getBoxItems(@Param("boxPk") String boxPk);

    void updateBoxItemAmount(@Param("boxPk") String boxPk, @Param("productCode") String productCode, @Param("amount") double amount);
}
