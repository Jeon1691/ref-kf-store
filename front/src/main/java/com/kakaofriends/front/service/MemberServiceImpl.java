package com.kakaofriends.front.service;

import com.kakaofriends.front.common.external.DaumMailSenderComponent;
import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;
import com.kakaofriends.front.domain.Migration;
import com.kakaofriends.front.domain.ProvisionAgreement;
import com.kakaofriends.front.domain.common.CommonCode;
import com.kakaofriends.front.domain.email.Welcome;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.repository.CommonCodeRepository;
import com.kakaofriends.front.repository.MemberRepository;
import com.kakaofriends.front.repository.MyPointRepository;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import com.kakaofriends.front.utils.StringUtils;
import com.sun.mail.smtp.SMTPAddressFailedException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private MyPointRepository myPointRepository;
    private ProvisionAgreementService provisionAgreementService;
    private PasswordEncoder passwordEncoder;
    private DaumMailSenderComponent daumMailSenderComponent;
    private MigrationService migrationService;
    private LocaleUtils localeUtils;
    private MessageSource messageSource;

    private CommonCodeRepository commonCodeRepository;


    @Override
    public MemberAddress findMemberAddress(int userId) {
        return memberRepository.selectMemberAddress(userId);
    }

	/*
        ???????????? ??????. ???????????? 2017.10.31 Breeze
	 */
//	@Value("${kakao.member.default.password}")
//	private String memberPassword;

    /**
     * ????????????. 2017.10.30 Breeze
     *
     * @param userCreateRequestVO
     * @return Long ????????? ???????????????(seq)
     */
    @Override
    public Member insert(UserCreateRequestVO userCreateRequestVO) throws Exception {

        Member member = memberRepository.findByProviderUserId(userCreateRequestVO.getProviderUserId(), "PREREG");

        boolean isPreReg = true;

        if (null == member) {
            member = new Member();
            isPreReg = false;
        }

        member
                // ?????????
                .setEmail(StringUtils.isEmpty(userCreateRequestVO.getEmail()) ? null : userCreateRequestVO.getEmail())
                // ????????????. ??????????????? ??????????????? ?????? ???????????? ????????? ????????? ???????????? ?????????.
                .setPassword(passwordEncoder.encode(org.apache.commons.lang3.StringUtils.isEmpty(userCreateRequestVO.getPassword()) ? "KakaoDefaultPassword" : userCreateRequestVO.getPassword()))
                // ??????
                .setBirthyear(userCreateRequestVO.getBirthyear())
                // ??????
                .setBirthday(userCreateRequestVO.getBirthday())
                // ??????
                .setCountry(userCreateRequestVO.getCountry().toLowerCase())
                // ????????????
                .setPhoneNumber(userCreateRequestVO.getPhoneNumber())
                // ??????
                .setGender(userCreateRequestVO.getGender())
                // ??????
                .setName(userCreateRequestVO.getName())
                // ?????? ?????????
                .setProviderId(userCreateRequestVO.getProviderId())
                // ?????? ?????? ?????????
                .setProviderUserId(userCreateRequestVO.getProviderUserId())
                // ?????????
                .setBarcode("BARCODE")
                // ????????? URL
                .setBarcodeUrl("BARCODE_URL")
                .setStatus("MEMBER");

        // Kakao Profile ????????? Gender ?????? male, femail ????????? ????????????.
        if (StringUtils.isNotEmpty(member.getGender())) {
            if (member.getGender().equalsIgnoreCase("male")) {
                member.setGender("M");
            }

            if (member.getGender().equalsIgnoreCase("female")) {
                member.setGender("F");
            }
        }

        if (isPreReg) {
            memberRepository.update(member);
        } else {
            memberRepository.insert(member);
        }
        // ?????? ?????? insert

        for (ProvisionAgreement provisionAgreement : userCreateRequestVO.getProvisionAgreements()) {
            provisionAgreement.setMemberId(member.getId());
        }

        // ?????? ??????
        provisionAgreementService.agreeProvision(userCreateRequestVO.getProvisionAgreements());

        // ???????????? ?????? : ?????? ????????? ?????? ???????????? ?????? ????????? ?????????.
        if (member.getProviderId().equals("kakao")) {
            if (!org.springframework.util.StringUtils.isEmpty(member.getEmail())
                    && !(member.getEmail().startsWith("kakao") && member.getEmail().endsWith("@kakao.com"))) {
                sendWelcomeEmail(member.getEmail(), userCreateRequestVO);
            }
        }

        if (!isPreReg) {
            // Point ??????
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime end = now.plusMonths(6).minusDays(1);
            Date startDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(end.atZone(ZoneId.systemDefault()).toInstant());

            TbKfoMbsPoint registPoint = new TbKfoMbsPoint();
            registPoint.setMP_USERID(String.valueOf(member.getId()));
            registPoint.setMP_TYPE(MyPointCode.GIFT.getCode());
            registPoint.setMP_TITLE("Welcome Point");
            registPoint.setMP_ETITLE("Welcome Point");
            registPoint.setMP_AMOUNT(1000);
            registPoint.setMP_REST(1000);
            registPoint.setMP_SDATE(startDate);
            registPoint.setMP_EDATE(endDate);
            myPointRepository.registPointByUser(registPoint);
        }

        // Test Code
        // userCreateRequestVO.setProviderId("kakao");
        // userCreateRequestVO.setProviderUserId("84573447");
        // Test Code

        // Data Migration
        if ("kakao".equals(userCreateRequestVO.getProviderId())) {
            Migration migration = new Migration();
            migration.setTargetId(userCreateRequestVO.getProviderUserId());
            migration.setId(member.getId());
            migrationService.migration(migration);
        }

        return memberRepository.get(member);
    }


    /**
     * ???????????? ??????. 2017.10.30 Breeze
     *
     * @param member
     * @return
     */
    @Override
    public Member get(Member member) throws DataAccessException {
        return memberRepository.get(member);
    }

    /**
     * ???????????? ??????. 2017.11.03 Breeze
     * ?????????, ????????????, ??????, ????????????, ??????, ????????????, ??????, ?????? ??????
     *
     * @param userCreateRequestVO
     * @return
     */
    @Override
    public int update(UserCreateRequestVO userCreateRequestVO) throws DataAccessException {
        Member member = new Member()
                .setId(userCreateRequestVO.getId())
                // ??????
                .setName(userCreateRequestVO.getName())
                .setBirthday(userCreateRequestVO.getBirthday())
                .setGender(userCreateRequestVO.getGender())
                // ?????????
                .setEmail(userCreateRequestVO.getEmail())
                // ?????? ?????????
                .setOldEmail(userCreateRequestVO.getOldEmail())
                // ??????
                .setCountry(userCreateRequestVO.getCountry())
                // ????????????
                .setPhoneNumber(userCreateRequestVO.getPhoneNumber())
                // ?????? ?????????
                .setProviderId(userCreateRequestVO.getProviderId())
                // ?????? ?????? ?????????
                .setProviderUserId(userCreateRequestVO.getProviderUserId())
                // ??????
                .setStatus(userCreateRequestVO.getStatus());

        if (!StringUtils.isEmpty(userCreateRequestVO.getPassword())) {
            member.setPassword(passwordEncoder.encode(userCreateRequestVO.getPassword()));
        }

        if (FriendsUtil.isSocial()) {
            if (StringUtils.isNotEmpty(userCreateRequestVO.getOldEmail()) && !userCreateRequestVO.getOldEmail().equals(userCreateRequestVO.getEmail())) {
                memberRepository.updateUserConnection(member);
            }
        }

        return memberRepository.update(member);
    }

    /**
     * ?????? ??????.
     *
     * @param member
     * @return
     */
    public int delete(Member member) {
        member.setStatus("WITHDRAW");

        // ?????? ??????
        provisionAgreementService.disagree(member.getId());

        // ?????? ?????? ?????? ?????? ??????.
        if (FriendsUtil.isSocial()) {
            memberRepository.deleteUserConnection(member.getId().toString());
        }

        return memberRepository.update(member);
    }

    /**
     * ?????? ?????? ??????.
     *
     * @param email
     * @param userCreateRequestVO
     * @throws Exception
     */
    private void sendWelcomeEmail(String email, UserCreateRequestVO userCreateRequestVO) {
        Locale locale = new Locale(localeUtils.whereAreYou());
        Welcome welcome = new Welcome();

        for (ProvisionAgreement provisionAgreement : userCreateRequestVO.getProvisionAgreements()) {
            if ("Email".equals(provisionAgreement.getProvisionCode())) { // ????????? ??????
                if (provisionAgreement.isAgreement()) {
                    welcome.setAgreementEmail(messageSource.getMessage("mail.welcome.provision.agree", null, locale));
                } else {
                    welcome.setAgreementEmail(messageSource.getMessage("mail.welcome.provision.disagree", null, locale));
                }
            } else if ("Sms".equals(provisionAgreement.getProvisionCode())) { // SMS ??????
                if (provisionAgreement.isAgreement()) {
                    welcome.setAgreementSMS(messageSource.getMessage("mail.welcome.provision.agree", null, locale));
                } else {
                    welcome.setAgreementSMS(messageSource.getMessage("mail.welcome.provision.disagree", null, locale));
                }
            }
        }
        LocalDate now = LocalDate.now();
        welcome.setDate(now.format(DateTimeFormatter.ofPattern("yyyy. MM. dd")));
        welcome.setResult(messageSource.getMessage("mail.welcome.complete", null, locale));

        try {
            daumMailSenderComponent.sendMail("welcome", messageSource.getMessage("mail.welcome.subject", null, locale), email, welcome, locale);
        } catch (Exception e) {
            log.error("Mail Error : {}", email);
            log.error(e.getMessage());
        }
    }


    public Boolean checkWithdrawPeriod(UserCreateRequestVO userCreateRequestVO) {
        List<Member> withDrawList = memberRepository.findAllByProviderUserId(userCreateRequestVO.getProviderUserId(), "WITHDRAW");
        List<CommonCode> codeList = commonCodeRepository.findAllByCodeType("IGNOREDRAW");


        if (0 < withDrawList.size()) {
            if (withDrawList.get(0).getUpdateDate().plusDays(30).isAfter(LocalDateTime.now())) {
                return codeList.stream().noneMatch(s -> s.getCodeNm().equalsIgnoreCase(userCreateRequestVO.getEmail()));
            }
        }

        return false;
    }
}