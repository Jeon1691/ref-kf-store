package com.kakaofriends.front.service.order;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.repository.OrderAddDeliRepository;
import com.kakaofriends.front.repository.order.OrderSubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAddDeliServiceImpl implements OrderAddDeliService {

    @Autowired
    OrderSubRepository orderSubRepository;

    @Autowired
    OrderAddDeliRepository orderAddDeliRepository;

    @Override
    public OrderAddDeli findOrderAddDeliListByOrderNumberAndOrderStatus(String orderNumber, OrderStatusType orderStatus) {
        return orderAddDeliRepository.findOrderAddDeliListByOrderNumberAndOrderStatus(orderNumber, orderStatus);
    }

    @Override
    public List<OrderAddDeli> findOrderAddDeliListByPaymentEndOrderNumberAndOrderStatus(String orderNumber, OrderStatusType orderStatus) {
        return orderAddDeliRepository.findOrderAddDeliListByPaymentEndOrderNumberAndOrderStatus(orderNumber, orderStatus);
    }

    @Override
    public OrderAddDeli findOrderAddDeliByOrderNumberAndOrderSubSeq(String orderNumber, int OrderSubSeq, int OrderSubSerial) {
        return orderAddDeliRepository.findOrderAddDeliByOrderNumberAndOrderSubSeq(orderNumber, OrderSubSeq, OrderSubSerial);
    }

    @Override
    public int updateOrderAddDeliByPayment(OrderAddDeli orderAddDeli) {
        return orderAddDeliRepository.updateOrderAddDeliByPayment(setOrderAddDeli(orderAddDeli));
    }

    @Override
    public int updateOrderAddDeliByError(OrderAddDeli orderAddDeli) {
        return orderAddDeliRepository.updateOrderAddDeliByError(setOrderAddDeli(orderAddDeli));
    }

    private OrderAddDeli setOrderAddDeli(OrderAddDeli orderAddDeli){

//        if(payType == PayType.KAKAOPAY) {
//            orderAddDeli.setOdAccountMoney(0);
//            orderAddDeli.setOdCardMoney(0);
//            orderAddDeli.setOdKakaoMoney(paymentMoney);
//        }
//        else if(payType == PayType.ONLY_CARD) {
//            orderAddDeli.setOdAccountMoney(0);
//            orderAddDeli.setOdCardMoney(paymentMoney);
//            orderAddDeli.setOdKakaoMoney(0);
//        }
//        else if(payType == PayType.ONLY_DBANK) {
//            orderAddDeli.setOdAccountMoney(paymentMoney);
//            orderAddDeli.setOdCardMoney(0);
//            orderAddDeli.setOdKakaoMoney(0);
//        }

//        orderAddDeli.setOdStatus(orderSubRepository.findOrderStatusByOrderNumberAndOrderSubSeq(orderAddDeli.getOdOmNum(), orderAddDeli.getOdOsSeq()));
//        orderAddDeli.setOdMoId(getFriendsMemberId());
//        orderAddDeli.setOdMoDate(null);
//        orderAddDeli.setOdOdNum();
//        orderAddDeli.setOdPgTid();
//        orderAddDeli.setOdCreditCardNum();
//        orderAddDeli.setOdPayType(payType);
//        orderAddDeli.setOdPayInDate(null);
        return orderAddDeli;
    }

    @Override
    public int updateLeftProduct(OrderAddDeli orderAddDeli){
        return orderAddDeliRepository.updateLeftProduct(orderAddDeli);
    }
}
