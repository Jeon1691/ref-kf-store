package com.kakaofriends.front.domain.payment.dto.error;

import lombok.Data;

import java.io.Serializable;

@Data
public class KakaoPayError implements Serializable {

    String msg;
    int code;
    Extras extras;

}
