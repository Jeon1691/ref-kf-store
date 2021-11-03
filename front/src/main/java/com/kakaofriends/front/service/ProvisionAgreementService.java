package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.Provision;
import com.kakaofriends.front.domain.ProvisionAgreement;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProvisionAgreementService {
    // 동의가 필요한 약관 조회. 2017.10.30 Breeze
    List<Provision> getNeedAgreementProvision(ProvisionAgreement provisionAgreement) throws DataAccessException;

    // 약관 동의 2017.10.30 Breeze
    int agreeProvision(List<ProvisionAgreement> provisionAgreementList) throws DataAccessException;

    // 회원 약관 동의 현황 조회
    List<Provision> getMemberProvisionInfo(ProvisionAgreement provisionAgreement) throws DataAccessException;

    int disagree(Long id) throws DataAccessException;
}
