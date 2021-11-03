package com.kakaofriends.front.repository.stat;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.stat.StatInflowData;
import org.springframework.stereotype.Repository;


/**
 * StatRepository
 * <p>
 * Author  layla
 * Date    2018. 5. 16.
 */
@PrimaryMapper
@Repository
public interface StatRepository {
    int insert(StatInflowData statInflowData);
}
