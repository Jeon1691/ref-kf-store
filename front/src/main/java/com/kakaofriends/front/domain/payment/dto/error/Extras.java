package com.kakaofriends.front.domain.payment.dto.error;

import lombok.Data;

import java.io.Serializable;

@Data
public class Extras implements Serializable {
    int methodResultCode;
    String methodResultMessage;
}
