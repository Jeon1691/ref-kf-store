package com.kakaofriends.front.repository.sales;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.sales.KfoSalesData;
import org.springframework.stereotype.Repository;

/**
 * Created by eunduck on 2018. 3. 13..
 */
@PrimaryMapper
@Repository
public interface KfoSalesRepository {
    KfoSalesData selectOne(KfoSalesData kfoSalesData);

    int insert(KfoSalesData kfoSalesData);
}
