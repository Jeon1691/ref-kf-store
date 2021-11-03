package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.PreOrderMainData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * PreOrderMainRepository
 *
 * Author  april
 * Date    2018. 3. 16.
 */
@Repository
@PrimaryMapper
public interface PreOrderMainRepository {
    PreOrderMainData select(@Param("orderNumber") String orderNumber);

    void insert(@Param("orderMain") PreOrderMainData data);

    void update(@Param("orderMain") PreOrderMainData data);
}
