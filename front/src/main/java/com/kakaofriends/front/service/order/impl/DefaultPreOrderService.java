package com.kakaofriends.front.service.order.impl;

import com.kakaofriends.front.common.exception.InvalidOrderException;
import com.kakaofriends.front.service.order.address.PreOrderAddressService;
import com.kakaofriends.front.service.order.api.PreOrderService;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.main.PreOrderMainService;
import com.kakaofriends.front.service.order.sub.PreOrderSubService;
import com.kakaofriends.front.service.order.vo.PreOrder;
import com.kakaofriends.front.service.order.vo.PreOrderAddress;
import com.kakaofriends.front.service.order.vo.PreOrderMain;
import com.kakaofriends.front.service.order.vo.PreOrderSub;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DefaultPreOrderService : : 결제 전 정보의 비지니스를 처리하는 서비스
 * <p>
 * Author  april
 * Date    2018. 3. 16.
 */
@Slf4j
@Service
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
public class DefaultPreOrderService implements PreOrderService {
    private PreOrderMainService preOrderMainService;
    private PreOrderSubService preOrderSubService;
    private PreOrderAddressService preOrderAddressService;

    @Override
    @Transactional( readOnly = true )
    public PreOrder get( String orderNumber ) {
        PreOrderMain orderMain = preOrderMainService.get( orderNumber );
        List<PreOrderSub> orderSubList = preOrderSubService.getList( orderNumber );
        PreOrderAddress orderAddress = preOrderAddressService.get( orderNumber );
        return new PreOrder( orderMain, orderSubList, orderAddress );
    }

    @Override
    @Transactional
    public void add( PreOrder preOrder ) {
        log.info( "#### PARAM : {}", preOrder );
        preOrderMainService.add( preOrder.getOrderMain() );
        preOrderSubService.addList( preOrder.getOrderSubList() );
        preOrderAddressService.add( preOrder.getOrderAddress() );
    }

    @Override
    @Transactional
    public void editPaymentStatus( String orderNumber, PaymentStatus paymentStatus ) {
        PreOrderMain orderMain = preOrderMainService.get( orderNumber );
        PaymentStatus previousStep = paymentStatus.getPrevious();

        if ( !previousStep.equals( orderMain.getPaymentStatus() ) ) {
            throw new InvalidOrderException( "pay.network.error" );
        }
        orderMain.setPaymentStatus( paymentStatus );
        preOrderMainService.edit( orderMain );
        List<PreOrderSub> orderSubList = preOrderSubService.getList( orderNumber );
        for ( PreOrderSub orderSub : orderSubList ) {
            orderSub.setPaymentStatus( paymentStatus );
            preOrderSubService.edit( orderSub );
        }

    }
}