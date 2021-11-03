package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Dave on 2017. 4. 27..
 */

@Repository
@PrimaryMapper
public interface EmsRepository {
    Long getEmsPrice(@Param("countryCode") String countryCode, @Param("weight") double weight);

    List<Map<String, Object>> getCountryList(@Param("language") String language);

    List<Map<String,Object>> getEmsState();

    String getCountryNumber(Long id) throws DataAccessException;

    String getCountryName(@Param("language") String language, @Param("phoneCode") String phoneCode);
}
