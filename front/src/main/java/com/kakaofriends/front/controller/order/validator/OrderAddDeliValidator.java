package com.kakaofriends.front.controller.order.validator;

import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.domain.order.OrderValidationDto;
import com.kakaofriends.front.service.order.OrderAddDeliService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.kakaofriends.front.utils.FriendsUtil.processMessage;

@Slf4j
@Component("orderAddDeliValidator")
public class OrderAddDeliValidator implements Validator {

    @Autowired private OrderAddDeliService orderAddDeliService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderValidationDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderValidationDto order = (OrderValidationDto) target;

        OrderAddDeli orderAddDeli = orderAddDeliService.findOrderAddDeliByOrderNumberAndOrderSubSeq(order.getOdOmNum(), order.getOdOsSeq(), order.getOdOsSerial());

        if(order.getPaymentAmount().intValue() != orderAddDeli.getOdReqMoney().intValue()) {
            errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAmount.invalid"));
        }

        if (orderAddDeli.getOdOdPgTid() != null && orderAddDeli.getOdPayType() != null) {
            errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAlready.invalid"));
            log.error("OdOsSeq : {}, OdOsSerial : {}, OrderNumber : {}, OrderAddDeliNum : {}, OrderMoId : {}, ErrorMsg : {}", orderAddDeli.getOdOsSeq(), orderAddDeli.getOdOsSerial(), orderAddDeli.getOdOmNum(), orderAddDeli.getOdOdNum(), orderAddDeli.getOdMoId(), processMessage(messageSource, "paymentAlready.invalid"));
        }

    }
}
