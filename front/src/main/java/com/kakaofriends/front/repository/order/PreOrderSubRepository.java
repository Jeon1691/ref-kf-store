package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.PreOrderSubData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PreOrderSubRepository
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Repository
@PrimaryMapper
public interface PreOrderSubRepository {

    List<PreOrderSubData> selectList(@Param("orderNumber") String orderNumber);

    void insert(@Param("orderSub") PreOrderSubData orderSub);

    void update(@Param("orderSub") PreOrderSubData orderSub);
}
