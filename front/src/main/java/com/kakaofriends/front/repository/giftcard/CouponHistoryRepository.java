package com.kakaofriends.front.repository.giftcard;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.giftcard.CouponHistoryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * CouponHistoryRepository
 *
 * Author  april
 * Date    2018. 2. 8.
 */
@PrimaryMapper
@Repository
public interface CouponHistoryRepository {
    void insert(@Param("history") CouponHistoryData data);
}
