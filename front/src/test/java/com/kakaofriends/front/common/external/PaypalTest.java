package com.kakaofriends.front.common.external;

import com.kakaofriends.front.common.configuration.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * PaypalTest
 *
 * Author  april
 * Date    2018. 1. 11.
 */
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@ActiveProfiles("local")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PaypalTest {

    @Test
    public void request() {
        // invoiceNumber=[K1801111101326724],
        //paymentData=[[{
        //	"amount":
        //		{
        //		"total":"18500",
        //		"currency":"USD",
        //		"details":{"subtotal":"1000","shipping":"17500"}},
        //		"discount":{"amount":0},
        //		"item_list":
        //			{"items":[{
        //				"name":"리틀프렌즈L홀더-라이언",
        //				"quantity":"1",
        //				"price":"1000",
        //				"currency":"USD"
        //				}]
        //			},
        //	"invoice_number":"K1801111101326724"}
        //]],
        //exchangeRate=[1131.1099853515625]}
        String url = "http://10.201.3.83:80/api/payment/paypal/create";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();

        restTemplate.postForObject(url, multiValueMap, String.class);
    }
}
