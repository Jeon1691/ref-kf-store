package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.Provision;
import com.kakaofriends.front.domain.ProvisionAgreement;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PrimaryMapper
public interface ProvisionAgreementRepository {
    /**
     * 동의가 필요한 약관만 조회
     * @param provisionAgreement
     * @return
     * @throws DataAccessException
     */
    List<Provision> getNeedAgreementProvision(ProvisionAgreement provisionAgreement) throws DataAccessException;

    /**
     * 회원의 약관 동의 현황
     * @param provisionAgreement
     * @return
     * @throws DataAccessException
     */
    List<Provision> getMemberProvisionInfo(ProvisionAgreement provisionAgreement) throws DataAccessException;

    /**
     * 약관 동의
     * @param provisionAgreement
     * @return
     * @throws DataAccessException
     */
    int agreeProvision(ProvisionAgreement provisionAgreement) throws DataAccessException;

    /**
     * 회원 탈퇴 시, 선택 약관 철회
     * @param id
     * @return
     * @throws DataAccessException
     */
    int disagree(Long id) throws DataAccessException;
}
