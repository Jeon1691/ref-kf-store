package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.Provision;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PrimaryMapper
public interface ProvisionRepository {
    // 약관 조회. 2017.10.30 Breeze
    Provision get(Provision provision) throws DataAccessException;


    // 최종 버전 약관 전부 가져오기. 2017.10.30 Breeze
    List<Provision> getLatestProvision(Provision provision) throws DataAccessException;
}
