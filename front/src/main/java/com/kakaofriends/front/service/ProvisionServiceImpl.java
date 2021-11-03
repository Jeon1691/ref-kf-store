package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.Provision;
import com.kakaofriends.front.repository.ProvisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ProvisionServiceImpl implements ProvisionService{
    private ProvisionRepository provisionRepository;

    // 약관 조회. 2017.10.30 Breeze
    public Provision get(Provision provision) throws DataAccessException {
        return provisionRepository.get(provision);
    }

    // 최종 버전 약관 전부 가져오기. 2017.10.30 Breeze
    public List<Provision> getLatestProvision(Provision provision) throws DataAccessException {
        return provisionRepository.getLatestProvision(provision);
    }
}
