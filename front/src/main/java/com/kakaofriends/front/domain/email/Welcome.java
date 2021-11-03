package com.kakaofriends.front.domain.email;

import lombok.Data;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 9.
 */
@Data
public class Welcome extends Email {
    private String date;
    private String agreementEmail;
    private String agreementSMS;
    private String result;
}
