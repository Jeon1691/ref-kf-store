package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface MemberRepository {

/*	Member findById(String id);

	Long findMaxSeq(Map<String, String> map);

	int insertMember(Member member);

	void cyberMoneyUpdate(Integer integer, String sessId);

	@Select("SELECT GR.* FROM MEMBER MB LEFT JOIN GROUPLEVEL GR ON MB.MB_LEVEL = GR.GR_SEQ WHERE MB.MB_ID = #{mbId}")
	void findByMbIdForGroup(String mbId);

	@Update("UPDATE MEMBER SET MB_LOGINSUCCESSCOUNT = NVL(MB_LOGINSUCCESSCOUNT, 0)+1 WHERE MB_ID = #{mbId}")
	int updateMemberLoginSuccessCount(String mbId);
    int insertMemberLogin(MemberLogin memberLogin);*/


    MemberAddress selectMemberAddress( @Param( "userId" ) int userId );

    int selectMemberAddressCount( @Param( "userId" ) int userId );

    /*
      신규 생성. Breeze
     */

    /**
     * 회원가입. 2017.10.30 Breeze
     *
     * @param member
     * @return Long 생성된 회원아이디(seq)
     */
    Long insert( Member member );

    /**
     * 회원정보 조회. 2017.10.30 Breeze
     *
     * @param member
     * @return
     */
    Member get( Member member );

    Member findByProviderUserId( @Param( "providerUserId" ) String providerUserId, @Param( "status" ) String status );

    List<Member> findAllByProviderUserId( @Param( "providerUserId" ) String providerUserId, @Param( "status" ) String status );

    /**
     * 회원정보 수정. 2017.11.03 Breeze
     * 이메일, 비밀번호, 국가, 전화번호, 이름, 생년월일, 성별, 약관 동의
     *
     * @param member
     * @return
     */
    int update( Member member );

    /**
     * social 에서 사용하는 userconnection table 수정.
     *
     * @param member
     * @return
     */
    int updateUserConnection( Member member );

    /**
     * 소셜회원 회원탈퇴 시, userconnection 테이블에서 삭제 처리.
     *
     * @param email
     * @return
     */
    int deleteUserConnection( String email );

    void updateDefaultAddress( MemberAddress memberAddress );

    void insertDefaultAddress( MemberAddress memberAddress );

    void deleteDefaultAddress( @Param( "userId" ) int userId );

}