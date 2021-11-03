package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.Provision;
import com.kakaofriends.front.domain.ProvisionAgreement;
import com.kakaofriends.front.repository.ProvisionAgreementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ProvisionAgreementServiceImpl implements ProvisionAgreementService{
    private ProvisionAgreementRepository provisionAgreementRepository;

    // 동의가 필요한 약관 조회. 2017.10.30 Breeze
    public List<Provision> getNeedAgreementProvision(ProvisionAgreement provisionAgreement) throws DataAccessException {
        return provisionAgreementRepository.getNeedAgreementProvision(provisionAgreement);
    }

    // 약관 동의 2017.10.30 Breeze
    public int agreeProvision(List<ProvisionAgreement> provisionAgreementList) throws DataAccessException {
        for(ProvisionAgreement provisionAgreement : provisionAgreementList) {
            provisionAgreementRepository.agreeProvision(provisionAgreement);
        }
        return provisionAgreementList.size();
    }

    public List<Provision> getMemberProvisionInfo(ProvisionAgreement provisionAgreement) throws DataAccessException {
        return provisionAgreementRepository.getMemberProvisionInfo(provisionAgreement);

    }

    public int disagree(Long id) throws DataAccessException {
        return provisionAgreementRepository.disagree(id);
    }
}