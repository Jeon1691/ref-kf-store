package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.PreOrderAddressData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * PreOrderAddressRepository
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Repository
@PrimaryMapper
public interface PreOrderAddressRepository {
    PreOrderAddressData select(@Param("orderNumber") String orderNumber);

    void insert(@Param("address") PreOrderAddressData address);
}