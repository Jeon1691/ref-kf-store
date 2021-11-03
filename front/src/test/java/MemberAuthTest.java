import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.MemberAuth;
import com.kakaofriends.front.repository.EmsRepository;
import com.kakaofriends.front.service.MemberAuthService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 1.
 */

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class MemberAuthTest {
    @Autowired
    private MemberAuthService memberAuthService;


    @Autowired
    public EmsRepository emsRepository;


    /**
     * 본인 인증 SMS 발송 Test.
     * @throws Exception
     */
    @Test
    public void insertAuthSms() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthService("AUTH SMS TEST!!!");
        memberAuth.setCountryCode("kr");
        memberAuth.setAuthMethod("MESSAGE");
        memberAuth.setReceiver("821045739365");
        memberAuthService.insert(memberAuth);
    }

    @Test
    public void selectTest() throws Exception {
        log.info(String.valueOf(emsRepository.getCountryList("")));
    }

    /**
     * SMS 본인 인증 시도 Test.
     * @throws Exception
     */
    @Test
    public void authSms() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthService("AUTH SMS TEST");
        memberAuth.setAuthMethod("MESSAGE");
        memberAuth.setCountryCode("kr");
        memberAuth.setReceiver("01048299310");
        memberAuth.setAuthNumber("526771");
        log.info("result : " + memberAuthService.auth(memberAuth));
    }

    /**
     * 본인 인증 Email 발송 Test
     * @throws Exception
     */
    @Test
    public void insertAuthEmail() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthService("AUTH EMAIL TEST");
        memberAuth.setAuthMethod("EMAIL");
        memberAuth.setReceiver("breeze.hwi@kakaocorp.com");
        memberAuthService.insert(memberAuth);
    }

    /**
     * Email 본인 인증 시도 Test.
     * @throws Exception
     */
    @Test
    public void authEmail() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthService("AUTH EMAIL TEST");
        memberAuth.setAuthMethod("EMAIL");
        memberAuth.setReceiver("breeze.hwi@kakaocorp.com");
        memberAuth.setAuthNumber("84467507");
        log.info("result : " + memberAuthService.auth(memberAuth));
    }

    /**
     * 비밀번호 찾기 위한 SMS 인증 시도 Test
     * @throws Exception
     */
    @Test
    public void authPwSms() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthMethod("MESSAGE");
        memberAuth.setCountryCode("kr");
        memberAuth.setReceiver("01045739365");
        memberAuth.setAuthNumber("787532");
        log.info("email : " + memberAuthService.auth(memberAuth));
    }

    /**
     * 비밀번호 찾기 위한 Email 인증 시도 Test
     * @throws Exception
     */
    @Test
    public void authPwEmail() throws Exception {
        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuthMethod("EMAIL");
        memberAuth.setCountryCode("kr");
        memberAuth.setReceiver("breeze.hwi@kakaocorp.com");
        memberAuth.setAuthNumber("38756301");
        log.info("email : " + memberAuthService.auth(memberAuth));
    }

}
