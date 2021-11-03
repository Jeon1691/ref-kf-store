package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.sales.SalesData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SalesRepository
 *
 * Author  april
 * Date    2018. 1. 4.
 */
@PrimaryMapper
@Repository
public interface SalesRepository {
    List<SalesData> selectList(@Param("sales") SalesData sales);
    void insert(@Param("sales") SalesData sales);
}