package com.kakaofriends.front.service.member;

import com.kakaofriends.front.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * MemberAddress : 회원 주소 정보 Value object
 *
 * Author  april
 * Date    2018. 1. 30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberAddress {
    private Long id;
    private Long memberId;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String zipCode;
    private String phone;
    private String email;
    private Country country;

    private Long updatedMemberId;
    private Long registeredMemberId;
    private LocalDateTime updatedDate;
    private LocalDateTime registeredDate;

    public void setAddress(Country country, String state, String address, String detailAddress) {
        switch (country) {
            case Korea:
                this.setAddress1(address);
                this.setAddress2(detailAddress);
                break;
            default:
                this.setAddress1(state);
                this.setAddress2(address);
                this.setAddress3(detailAddress);
                break;
        }
        this.setCountry(country);
    }
}
