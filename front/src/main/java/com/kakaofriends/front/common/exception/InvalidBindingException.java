package com.kakaofriends.front.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * InvalidBindingException
 *
 * Author  april
 * Date    2018. 1. 18.
 */
public class InvalidBindingException extends FriendsStoreException {
    private static final long serialVersionUID = -8047539894722219546L;

    @Getter
    private final List<String> errors;

    public InvalidBindingException(BindingResult bindingResult) {
        super(ExceptionType.INVALID_BINDING.getMessage(), HttpStatus.BAD_REQUEST);
        errors = new ArrayList<>();
        List<FieldError> errorList = bindingResult.getFieldErrors();
        for (FieldError error :  errorList) {
            errors.add(error.getDefaultMessage() + "-" + error.getObjectName() + "." + error.getField());
        }
    }
}
