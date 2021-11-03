package com.kakaofriends.front.repository.payment;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.payment.PaymentHistoryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * PaymentHistoryRepository
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@PrimaryMapper
@Repository
public interface PaymentHistoryRepository {
    /**
     * 결제 이력 데이터를 입력한다.
     *
     * @param data 결제 이력 데이터
     */
    void insert(@Param("data") PaymentHistoryData data);
}