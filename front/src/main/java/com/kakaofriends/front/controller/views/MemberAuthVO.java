package com.kakaofriends.front.controller.views;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kakaofriends.front.common.response.ApiSuccess;
import lombok.Data;
import lombok.ToString;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 2.
 */

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberAuthVO extends ApiSuccess{
    private boolean result;
    private int countAuth;
    private Long id;
    private String email;
}
