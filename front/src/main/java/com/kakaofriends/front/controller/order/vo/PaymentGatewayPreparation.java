package com.kakaofriends.front.controller.order.vo;

import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.service.payment.vo.PaymentPreparationResult;
import lombok.Data;
import org.springframework.mobile.device.Device;

/**
 * PaymentGatewayPreparation : 결제 준비 response value object
 *
 * Author  april
 * Date    2018. 1. 23.
 */
@Data
public class PaymentGatewayPreparation {
    private PaymentGateway paymentGateway;
    private String orderNumber;
    private String kakaopayUrl;
    private String paypalPaymentId;
    private String inicisTid;
    private String inicisEncfield;
    private String inicisMobileDom;

    public static PaymentGatewayPreparation converts(Device device, PaymentGateway paymentGateway, String orderNumber, PaymentPreparationResult response) {
        PaymentGatewayPreparation pgPreparation = new PaymentGatewayPreparation();
        pgPreparation.setOrderNumber(orderNumber);
        pgPreparation.setPaymentGateway(paymentGateway);
        switch (paymentGateway) {
            case PAYPAL:
                pgPreparation.setPaypalPaymentId(response.getTid());
                break;
            case INICIS:
                pgPreparation.setInicisTid(response.getTid());
                pgPreparation.setInicisEncfield(response.getEncryptedField());
                break;
            case KAKAOPAY:
                if (device.isNormal()) {
                    pgPreparation.setKakaopayUrl(response.getWebUrl());
                } else {
                    pgPreparation.setKakaopayUrl(response.getMobileURl());
                }
                break;
            case INICIS_MOBILE:
                pgPreparation.setInicisMobileDom(response.getMobileDom());
                break;
        }
        return pgPreparation;
    }
}