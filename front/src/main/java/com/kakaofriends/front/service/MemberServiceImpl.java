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
        사용하지 않음. 주석처리 2017.10.31 Breeze
	 */
//	@Value("${kakao.member.default.password}")
//	private String memberPassword;

    /**
     * 회원가입. 2017.10.30 Breeze
     *
     * @param userCreateRequestVO
     * @return Long 생성된 회원아이디(seq)
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
                // 이메일
                .setEmail(StringUtils.isEmpty(userCreateRequestVO.getEmail()) ? null : userCreateRequestVO.getEmail())
                // 패스워드. 소셜가입은 비밀번호를 받지 않으므로 디폴트 암호를 세팅하여 암호화.
                .setPassword(passwordEncoder.encode(org.apache.commons.lang3.StringUtils.isEmpty(userCreateRequestVO.getPassword()) ? "KakaoDefaultPassword" : userCreateRequestVO.getPassword()))
                // 생년
                .setBirthyear(userCreateRequestVO.getBirthyear())
                // 생월
                .setBirthday(userCreateRequestVO.getBirthday())
                // 국가
                .setCountry(userCreateRequestVO.getCountry().toLowerCase())
                // 전화번호
                .setPhoneNumber(userCreateRequestVO.getPhoneNumber())
                // 성별
                .setGender(userCreateRequestVO.getGender())
                // 이름
                .setName(userCreateRequestVO.getName())
                // 소셜 아이디
                .setProviderId(userCreateRequestVO.getProviderId())
                // 소셜 유저 아이디
                .setProviderUserId(userCreateRequestVO.getProviderUserId())
                // 바코드
                .setBarcode("BARCODE")
                // 바코드 URL
                .setBarcodeUrl("BARCODE_URL")
                .setStatus("MEMBER");

        // Kakao Profile 에서는 Gender 값이 male, femail 형태로 넘어온다.
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
        // 회원 정보 insert

        for (ProvisionAgreement provisionAgreement : userCreateRequestVO.getProvisionAgreements()) {
            provisionAgreement.setMemberId(member.getId());
        }

        // 약관 동의
        provisionAgreementService.agreeProvision(userCreateRequestVO.getProvisionAgreements());

        // 환영메일 발송 : 메일 주소가 있을 경우에만 환영 메일을 보낸다.
        if (member.getProviderId().equals("kakao")) {
            if (!org.springframework.util.StringUtils.isEmpty(member.getEmail())
                    && !(member.getEmail().startsWith("kakao") && member.getEmail().endsWith("@kakao.com"))) {
                sendWelcomeEmail(member.getEmail(), userCreateRequestVO);
            }
        }

        if (!isPreReg) {
            // Point 적재
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
     * 회원정보 조회. 2017.10.30 Breeze
     *
     * @param member
     * @return
     */
    @Override
    public Member get(Member member) throws DataAccessException {
        return memberRepository.get(member);
    }

    /**
     * 회원정보 수정. 2017.11.03 Breeze
     * 이메일, 비밀번호, 국가, 전화번호, 이름, 생년월일, 성별, 약관 동의
     *
     * @param userCreateRequestVO
     * @return
     */
    @Override
    public int update(UserCreateRequestVO userCreateRequestVO) throws DataAccessException {
        Member member = new Member()
                .setId(userCreateRequestVO.getId())
                // 이름
                .setName(userCreateRequestVO.getName())
                .setBirthday(userCreateRequestVO.getBirthday())
                .setGender(userCreateRequestVO.getGender())
                // 이메일
                .setEmail(userCreateRequestVO.getEmail())
                // 이전 이메일
                .setOldEmail(userCreateRequestVO.getOldEmail())
                // 국가
                .setCountry(userCreateRequestVO.getCountry())
                // 전화번호
                .setPhoneNumber(userCreateRequestVO.getPhoneNumber())
                // 소셜 아이디
                .setProviderId(userCreateRequestVO.getProviderId())
                // 소셜 유저 아이디
                .setProviderUserId(userCreateRequestVO.getProviderUserId())
                // 상태
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
     * 회원 탈퇴.
     *
     * @param member
     * @return
     */
    public int delete(Member member) {
        member.setStatus("WITHDRAW");

        // 약관 철회
        provisionAgreementService.disagree(member.getId());

        // 소셜 회원 인증 정보 삭제.
        if (FriendsUtil.isSocial()) {
            memberRepository.deleteUserConnection(member.getId().toString());
        }

        return memberRepository.update(member);
    }

    /**
     * 환영 메일 발송.
     *
     * @param email
     * @param userCreateRequestVO
     * @throws Exception
     */
    private void sendWelcomeEmail(String email, UserCreateRequestVO userCreateRequestVO) {
        Locale locale = new Locale(localeUtils.whereAreYou());
        Welcome welcome = new Welcome();

        for (ProvisionAgreement provisionAgreement : userCreateRequestVO.getProvisionAgreements()) {
            if ("Email".equals(provisionAgreement.getProvisionCode())) { // 이메일 약관
                if (provisionAgreement.isAgreement()) {
                    welcome.setAgreementEmail(messageSource.getMessage("mail.welcome.provision.agree", null, locale));
                } else {
                    welcome.setAgreementEmail(messageSource.getMessage("mail.welcome.provision.disagree", null, locale));
                }
            } else if ("Sms".equals(provisionAgreement.getProvisionCode())) { // SMS 약관
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