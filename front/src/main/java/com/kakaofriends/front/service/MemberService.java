package com.kakaofriends.front.service;

import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;


public interface MemberService {

    //Member findById(String mbId);


//	Member memberCreate(String mbId, String mbName);

    // 신규 회원 가입
    //Member memberCreate(Member member);

	/*int updateMemberLoginSuccessCount(String mbId);

	int insertMemberLogin(String mbId, HttpServletRequest httpServletRequest);
*/
	/*
		신규 개발. Breeze
	 */
    /**
     * 회원가입. 2017.10.30 Breeze
     * @param userCreateRequestVO
     * @return Long 생성된 회원아이디(seq)
     */
    Member insert(UserCreateRequestVO userCreateRequestVO) throws Exception;

    /**
     * 회원 기본 배송지 정보를 가지고 온다
     * @param userId
     * @return
     */
    MemberAddress findMemberAddress(int userId);

    /**
     * 회원정보 조회. 2017.10.30 Breeze
     * @param member
     * @return
     */
    Member get(Member member);

    /**
     * 회원정보 수정. 2017.11.03 Breeze
     * 이메일, 비밀번호, 국가, 전화번호, 이름, 생년월일, 성별, 약관 동의
     * @param userCreateRequestVO
     * @return
     */
    int update(UserCreateRequestVO userCreateRequestVO);

    int delete(Member member);
}