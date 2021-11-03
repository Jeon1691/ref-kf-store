package com.kakaofriends.front.service;

import com.kakaofriends.front.common.exception.ExceededAuthCountException;
import com.kakaofriends.front.common.exception.NoDataException;
import com.kakaofriends.front.common.exception.NotCertificationException;
import com.kakaofriends.front.common.external.DaumMailSenderComponent;
import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAuth;
import com.kakaofriends.front.domain.email.Auth;
import com.kakaofriends.front.domain.kims.ShortMessageServiceDto;
import com.kakaofriends.front.repository.EmsRepository;
import com.kakaofriends.front.repository.MemberAuthRepository;
import com.kakaofriends.front.repository.MemberRepository;
import com.kakaofriends.front.utils.LocaleUtils;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.kakaofriends.front.utils.FriendsUtil.processMessage;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class MemberAuthServiceImpl implements MemberAuthService {
    private MemberAuthRepository memberAuthRepository;
    private MemberRepository memberRepository;
    private EmsRepository emsRepository;
    private MessageSource messageSource;
    private KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;
    private DaumMailSenderComponent daumMailSenderComponent;
    private LocaleUtils localeUtils;

    public int insert(MemberAuth memberAuth) throws Exception {
        int result = 0;
        int countAuth = 0;
        switch(memberAuth.getAuthMethod()) {
            case "MESSAGE" :
                // 발송 전 5회 발송 체크.
                countAuth = memberAuthRepository.getCountSmsAuth(memberAuth);
                if(countAuth >= 5) {
                    throw new ExceededAuthCountException("인증 시도 횟수가 5회를 초과하였습니다." + memberAuth.toString());
                }

                memberAuth.setAuthNumber(StringUtils.generateNumber(6));
                sendAuthMessage(memberAuth);
                break;
            case "EMAIL":
                memberAuth.setAuthNumber(StringUtils.generateNumber(8));
                memberAuth.setExpireDate(LocalDateTime.now().plusMinutes(30));
                sendAuthEmail(memberAuth);
                break;
        }
        memberAuthRepository.preAuth(memberAuth);
        result = memberAuthRepository.insert(memberAuth);
        return result > countAuth + 1 ? result : countAuth + 1;
    }

    /**
     * 인증 시도
     * @param memberAuth
     * @return result
     * @throws DataAccessException
     */
    public boolean auth(MemberAuth memberAuth) throws Exception {
        // 인증 시도
        String authNumber= memberAuthRepository.auth(memberAuth);

        if(org.apache.commons.lang3.StringUtils.isEmpty(authNumber)) {
            throw new NoDataException();
        }

        if(memberAuth.getAuthDepth() > 1)  {
            Member pMember = new Member();
            pMember.setName(memberAuth.getName());
            pMember.setEmail(memberAuth.getEmail());
            switch (memberAuth.getAuthMethod()) {
                case "MESSAGE":
                    pMember.setPhoneNumber(memberAuth.getReceiver());
                    break;
                case "EMAIL":
                    pMember.setEmail(memberAuth.getReceiver());
                    break;
            }

            Member member = memberRepository.get(pMember);
            if (member != null) {
                memberAuth.setId(member.getId());
                memberAuth.setEmail(member.getEmail());
            } else {
                throw new NoDataException();
            }
        }

        if(authNumber.equals(memberAuth.getAuthNumber())) {
            // 인증 결과 업데이트
            memberAuth.setResult("SUCCESS");
            memberAuthRepository.afterAuth(memberAuth);
            return true;
        } else {
            throw new NotCertificationException();
        }
    }

    /**
     * 재전송 가능여부 조회. 2017.11.09 Breeze
     * @param memberAuth
     * @return
     * @throws DataAccessException
     */
    public boolean isResendable(MemberAuth memberAuth) throws DataAccessException {
        return (memberAuthRepository.isResendable(memberAuth) == 0);
    }

    /**
     * MESSAGE 인증 문자 발송. 2017.11.01 Breeze
     * @param memberAuth
     * @throws Exception
     */
    private void sendAuthMessage(MemberAuth memberAuth) throws Exception {
        // 국가 코드 조회.
        String countryNumber = memberAuth.getCountryNumber();
        if(StringUtils.isEmpty(countryNumber)) {
            Member pMember = new Member();
            pMember.setName(memberAuth.getName());
            pMember.setEmail(memberAuth.getEmail());
            pMember.setPhoneNumber(memberAuth.getReceiver());

            Member member = memberRepository.get(pMember);
            if (member != null) {
                countryNumber = emsRepository.getCountryNumber(member.getId());
            } else {
                throw new NoDataException();
            }
        }

        if(StringUtils.isEmpty(countryNumber)) {
            throw new NoDataException();
        }
        // 인증 문자 발송
        ShortMessageServiceDto dto = new ShortMessageServiceDto();
        dto.setCallerNumber("15773754");
        dto.setCountryCode(countryNumber);
        dto.setMessage(processMessage(messageSource, "sms.findid.auth", new Object[]{memberAuth.getAuthNumber()}));
        dto.setReceiverNumber(memberAuth.getReceiver());
        kakaoIntegratedMessagingComponent.sendShortMessageService(dto);
    }

    /**
     * EMAIL 인증 메일 발송. 2017.11.01 Breeze
     * @param memberAuth
     */
    private void sendAuthEmail(MemberAuth memberAuth) throws Exception  {
        Locale locale = new Locale(localeUtils.whereAreYou());
        Auth auth = new Auth();

        if(memberAuth.getAuthDepth() > 1) {
            Member pMember = new Member();
            pMember.setName(memberAuth.getName());
            pMember.setEmail(memberAuth.getReceiver());

            Member member = memberRepository.get(pMember);
            if (member == null) {
                throw new NoDataException();
            }
        }

        auth.setAuthNumber(memberAuth.getAuthNumber());
        LocalDateTime now = LocalDateTime.now();
        auth.setCreateDate(now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")));
        daumMailSenderComponent.sendMail("authMail",messageSource.getMessage("mail.auth.subject", null, locale), memberAuth.getReceiver(), auth, locale);
    }
}
