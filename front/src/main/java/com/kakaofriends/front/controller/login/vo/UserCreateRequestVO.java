package com.kakaofriends.front.controller.login.vo;

import com.kakaofriends.front.domain.ProvisionAgreement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.social.connect.UserProfile;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestVO {

    private Long id;

    private String userName;

    private String email;
    private String oldEmail;

    private String password;

    private String name;

    private String status;

    private String phoneNumber;

    private boolean phoneAuth;

    private boolean emailAuth;

    private String birthyear;

    private String birthday;

    private String gender;

    private String country;

    private String providerId;

    private String providerUserId;

    private List<ProvisionAgreement> provisionAgreements;


    public static UserCreateRequestVO fromSocialUserProfile(UserProfile userProfile) {

        UserCreateRequestVO vo = new UserCreateRequestVO();
        vo.setEmail(StringUtils.isEmpty(userProfile.getEmail()) ? "" : userProfile.getEmail());
        vo.setUserName(StringUtils.isEmpty(userProfile.getName()) ? "" : userProfile.getName());
        return vo;
    }
}

