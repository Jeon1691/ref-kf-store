package com.kakaofriends.front.domain.email;

import lombok.Data;

import java.util.Locale;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 9.
 */
@Data
public class Email {
    private String template;        // 이메일 양식.

    private String receiver;        // 받는 이메일. user@gamil.com

    private String sender;          // 보내는 이메일. kakaofriends@kakao.com

    private String subject;         // 메일 제목. [환영] 카카오 프렌즈 회원이 되신 것을 축하드립니다.

    private String cc;              // 참조

    private Locale locale;          // Locale

    private String address;         // 주소 (@ 앞부분)

    private String domain;          // 도메인 (@ 뒷부분)
}
