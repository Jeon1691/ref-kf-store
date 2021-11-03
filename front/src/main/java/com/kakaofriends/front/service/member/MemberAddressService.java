package com.kakaofriends.front.service.member;

import com.kakaofriends.front.controller.order.vo.OrderPreparation;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.member.MemberAddressData;
import com.kakaofriends.front.repository.member.MemberAddressRepository;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MemberAddressService
 * <p>
 * Author  april
 * Date    2018. 1. 30.
 */
@Service
@Slf4j
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
public class MemberAddressService {
    private MemberAddressRepository memberAddressRepository;

    @Transactional( readOnly = true )
    public MemberAddress get( long memberId ) {
        MemberAddressData data = memberAddressRepository.select( memberId );
        if ( data != null ) {
            return this.converts( data );
        }
        return new MemberAddress();
    }

    @Transactional
    public void add( MemberAddress memberAddress ) {
        log.debug( "#### add member address = {}", memberAddress );
        memberAddressRepository.insert( this.converts( memberAddress ) );
    }

    @Transactional
    public void edit( MemberAddress memberAddress ) {
        log.debug( "#### edit member address = {}", memberAddress );
        memberAddressRepository.update( this.converts( memberAddress ) );
    }

    /**
     * 회원 주소 정보를 등록하거나 수정한다.
     * 해당 회원의 주소정보를 조회하여 데이터가 존재하면 수정,
     * 존재하지 않으면 신규로 등록한다.
     *
     * @param memberAddress 회원 주소
     */
    @Transactional
    public void merge( MemberAddress memberAddress ) {
        MemberAddress existedAddress = this.get( memberAddress.getMemberId() );
        if ( existedAddress != null && existedAddress.getId() != null ) {
            memberAddress.setId( existedAddress.getId() );
            this.edit( memberAddress );
        } else {
            this.add( memberAddress );
        }
    }

    @Transactional
    public void merge( OrderPreparation preparation ) {
        this.merge( this.converts( preparation ) );
    }

    private MemberAddressData converts( MemberAddress address ) {
        MemberAddressData data = new MemberAddressData();
        data.setId( address.getId() );
        data.setUserId( address.getMemberId() );
        data.setName( address.getName() );
        data.setAddr1( address.getAddress1() );
        data.setAddr2( address.getAddress2() );
        data.setAddr3( address.getAddress3() );
        data.setZoneCode( address.getZipCode() );
        data.setPhone( address.getPhone() );
        data.setEmail( address.getEmail() );
        data.setUpdUser( address.getUpdatedMemberId() );
        data.setRegUser( address.getRegisteredMemberId() );
        data.setCountryCode( address.getCountry().getCode() );
        return data;
    }

    private MemberAddress converts( MemberAddressData data ) {
        MemberAddress address = new MemberAddress();
        address.setId( data.getId() );
        address.setMemberId( data.getUserId() );
        address.setName( data.getName() );
        address.setAddress1( data.getAddr1() );
        address.setAddress2( data.getAddr2() );
        address.setAddress3( data.getAddr3() );
        address.setZipCode( data.getZoneCode() );
        address.setPhone( data.getPhone() );
        address.setEmail( data.getEmail() );
        address.setCountry( Country.getCountry( data.getCountryCode() ) );
        address.setUpdatedMemberId( data.getUpdUser() );
        address.setRegisteredMemberId( data.getRegUser() );
        address.setUpdatedDate( data.getUpdDttm() );
        address.setRegisteredDate( data.getRegDttm() );
        return address;
    }

    private MemberAddress converts( OrderPreparation preparation ) {
        MemberAddress memberAddress = new MemberAddress();
        Long memberId = FriendsUtil.getFriendsMember().getId();
        memberAddress.setMemberId( memberId );
        memberAddress.setRegisteredMemberId( memberId );
        memberAddress.setUpdatedMemberId( memberId );
        memberAddress.setName( preparation.getReceiverName() );
        memberAddress.setZipCode( preparation.getReceiverZipCode() );
        memberAddress.setPhone( preparation.getReceiverPhone() );
        memberAddress.setEmail( preparation.getBuyerEmail() );
        memberAddress.setAddress( Country.getCountry( preparation.getReceiverCountry() ),
            preparation.getReceiverState(), preparation.getReceiverAddress(), preparation.getReceiverDetailAddress() );

        return memberAddress;
    }
}