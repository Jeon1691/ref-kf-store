package com.kakaofriends.front.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kakaofriends.front.domain.Member;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.ItemList;
import lombok.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;


public class FriendsUtilTest {


    Member member;

    String result = "[{\"amount\":{\"total\":\"33000\",\"currency\":\"USD\",\"details\":{\"shipping\":\"32000\",\"subtotal\":\"1000\"}},\"item_list\":{\"items\":[{\"quantity\":\"1\",\"price\":\"1000\",\"name\":\"프렌즈시티엽서-라이언\",\"currency\":\"USD\"}]},\"invoice_number\":\"K1711090026175327\"}]";


    @Before
    public void setUp() {

        member = new Member();

    }

    @Test
    public void isSocial() throws Exception {

                Assert.assertTrue(
                        StringUtils.isEmpty(member.getProviderId()));
    }

    @Test
    public void stringToList() throws Exception {
        Type type = new TypeToken<test>(){}.getType();
        test myMap = new Gson().fromJson(result,type);
      /*  Map<String, Payment> result =
                (Map<String, Payment>) myMap.stream().collect(Collectors.toMap(Payment::getId,
                        Function.identity()));*/
        System.out.println(myMap);
    }



    @Data
    public class test{
        Amount amount;

        Details details;

        ItemList itemList;

        String invoiceNumber;



    }


}