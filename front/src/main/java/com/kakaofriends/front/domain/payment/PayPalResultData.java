package com.kakaofriends.front.domain.payment;

import com.kakaofriends.front.domain.order.OrderResultDto;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dave on 2017. 5. 30..
 */

@Data
public class PayPalResultData {

    private String oid;
    private String payaplSaleId;
    private String paypalPaymentId;
    private String paypalPayerId;
    private String paypalPayerEmail;
    private String paypalCreateTime;
    private double exchangeRate;
    private int amt;

    public PayPalResultData(OrderResultDto.ResultRequest resultRequest) throws ParseException {
        this.oid = resultRequest.getOid();
        this.payaplSaleId = resultRequest.getPayaplSaleId();
        this.paypalPaymentId = resultRequest.getPaypalPaymentId();
        this.paypalPayerId = resultRequest.getPaypalPayerId();
        this.paypalPayerEmail = resultRequest.getPaypalPayerEmail();
        this.amt = Math.toIntExact(resultRequest.getAmt());

        SimpleDateFormat paypalReturnFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = paypalReturnFormat.parse(resultRequest.getPaypalCreateTime());

        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
        long realDateTime = Long.parseLong(yyyyMMddHHmmss.format(date)) + 9000000; // 9시간 더해 줌
        this.paypalCreateTime = String.valueOf(realDateTime);
    }
}
