package com.kakaofriends.front.repository.payment.accounting;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.payment.accounting.AccountingData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountingRepository : TB_KFO_ACCOUNTING 테이블
 *
 * Author  april
 * Date    2018. 3. 9.
 */
@PrimaryMapper
@Repository
public interface AccountingRepository {
    List<AccountingData> selectList(@Param("data") AccountingData data);

    void insert(@Param("data") AccountingData data);
}
