package com.kakaofriends.front.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 2.
 */
@Data
@ToString(doNotUseGetters = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiSuccess {
    private HttpStatus status;
    private String statusCode;
    private String message;

    public ApiSuccess() {
        super();
        this.status = HttpStatus.OK;
        this.statusCode = "0000";
        this.message = "success";
    }

    public ApiSuccess(final HttpStatus status, final String message, final String statusCode) {
        super();
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }
}