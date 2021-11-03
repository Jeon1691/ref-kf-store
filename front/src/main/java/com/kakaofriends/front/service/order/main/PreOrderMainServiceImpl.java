package com.kakaofriends.front.service.order.main;

import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.order.PreOrderMainData;
import com.kakaofriends.front.repository.order.PreOrderMainRepository;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.vo.PreOrderMain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * PreOrderMainServiceImpl
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PreOrderMainServiceImpl implements PreOrderMainService {
    private PreOrderMainRepository preOrderMainRepository;

    @Override
    @Transactional(readOnly = true)
    public PreOrderMain get(String orderNumber) {
        return this.converts(preOrderMainRepository.select(orderNumber));
    }

    @Override
    @Transactional
    public void add(PreOrderMain preOrderMain) {
        preOrderMainRepository.insert(this.converts(preOrderMain));
    }

    @Override
    @Transactional
    public void edit(PreOrderMain preOrderMain) {
        preOrderMainRepository.update(this.converts(preOrderMain));
    }

    private PreOrderMainData converts(PreOrderMain preOrderMain) {
        PreOrderMainData data = new PreOrderMainData();
        data.setOrderId(preOrderMain.getOrderNumber());
        data.setUse(preOrderMain.getUse());
        data.setPgTid(preOrderMain.getPgTid());
        data.setMemberId(preOrderMain.getMemberId());
        data.setMemberName(preOrderMain.getMemberName());
        data.setPaymentType(preOrderMain.getPaymentType().name());
        data.setPaymentStatus(preOrderMain.getPaymentStatus().name());
        data.setPaymentAmount(preOrderMain.getPaymentAmount());
        data.setCouponAmount(preOrderMain.getCouponAmount());
        data.setPointAmount(preOrderMain.getPointAmount());
        data.setDeliveryAmount(preOrderMain.getDeliveryAmount());
        data.setCurrency(preOrderMain.getCurrency().name());
        data.setExchangeRate(preOrderMain.getExchangeRate());
        data.setDomestic(preOrderMain.getDomestic());
        data.setCouponCodes(preOrderMain.getCouponCodeList());
        data.setDeliveryMemo(preOrderMain.getDeliveryMemo());
        data.setDeliveryType(preOrderMain.getDeliveryType().getCode());
        data.setAccessType(preOrderMain.getAccessType().getCode());
        data.setLanguage(preOrderMain.getLanguage());
        data.setCreateId(preOrderMain.getCreateId());
        data.setUpdateId(preOrderMain.getUpdateId());
        return data;
    }

    private PreOrderMain converts(PreOrderMainData data) {
        PreOrderMain preOrderMain = new PreOrderMain();
        preOrderMain.setOrderNumber(data.getOrderId());
        preOrderMain.setUse(data.getUse());
        preOrderMain.setPgTid(data.getPgTid());
        preOrderMain.setMemberId(data.getMemberId());
        preOrderMain.setMemberName(data.getMemberName());
        preOrderMain.setPaymentType(PayType.valueOf(data.getPaymentType()));
        preOrderMain.setPaymentStatus(PaymentStatus.valueOf(data.getPaymentStatus()));
        preOrderMain.setPaymentAmount(data.getPaymentAmount());
        preOrderMain.setCouponAmount(data.getCouponAmount());
        preOrderMain.setPointAmount(data.getPointAmount());
        preOrderMain.setDeliveryAmount(data.getDeliveryAmount());
        preOrderMain.setCurrency(Currency.getCurrency(data.getCurrency()));
        preOrderMain.setExchangeRate(data.getExchangeRate());
        preOrderMain.setDomestic(data.getDomestic());
        if (StringUtils.isNotEmpty(data.getCouponCodes())){
            preOrderMain.setCouponCodeList(Arrays.asList(data.getCouponCodes().split(",")));
        }
        preOrderMain.setDeliveryMemo(data.getDeliveryMemo());
        preOrderMain.setDeliveryType(DeliveryType.get(data.getDeliveryType()));
        preOrderMain.setAccessType(OrderAccessType.get(data.getAccessType()));
        preOrderMain.setLanguage(data.getLanguage());
        preOrderMain.setCreateId(data.getCreateId());
        preOrderMain.setUpdateId(data.getUpdateId());
        preOrderMain.setCreateDate(data.getCreateDate());
        preOrderMain.setUpdateDate(data.getUpdateDate());
        return preOrderMain;
    }
}