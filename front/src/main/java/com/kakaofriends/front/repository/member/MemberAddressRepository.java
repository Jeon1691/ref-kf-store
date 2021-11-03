package com.kakaofriends.front.repository.member;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.member.MemberAddressData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * MemberAddressRepository
 *
 * Author  april
 * Date    2018. 1. 30.
 */
@PrimaryMapper
@Repository
public interface MemberAddressRepository {
    MemberAddressData select(@Param("memberId") long memberId);

    void insert(@Param("address") MemberAddressData data);

    void update(@Param("address") MemberAddressData data);
}
