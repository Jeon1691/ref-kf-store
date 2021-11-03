package com.kakaofriends.front.repository.member.point;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.member.point.PointData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * PointRepository
 *
 * Author  april
 * Date    2018. 2. 5.
 */
@PrimaryMapper
@Repository
public interface PointRepository {
    void insert(@Param("point") PointData point);
}
