package com.kakaofriends.front.service.order.sub;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.domain.order.PreOrderSubData;
import com.kakaofriends.front.repository.order.PreOrderSubRepository;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.vo.PreOrderSub;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PreOrderSubServiceImpl
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PreOrderSubServiceImpl implements PreOrderSubService {
    private PreOrderSubRepository preOrderSubRepository;

    @Override
    public List<PreOrderSub> getList(String orderNumber) {
        log.debug("#### PARAM : orderNumber = {}", orderNumber);
        List<PreOrderSub> orderSubList = new ArrayList<>();
        List<PreOrderSubData> dataList = preOrderSubRepository.selectList(orderNumber);
        for (PreOrderSubData data : dataList) {
            orderSubList.add(this.converts(data));
        }
        return orderSubList;
    }

    @Override
    @Transactional
    public void addList(List<PreOrderSub> preOrderSubList) {
        for (PreOrderSub orderSub : preOrderSubList) {
            this.add(orderSub);
        }
    }

    private void add(PreOrderSub orderSub) {
        log.debug("#### PARAM : {}", orderSub);
        preOrderSubRepository.insert(this.converts(orderSub));
    }

    @Override
    @Transactional
    public void edit(PreOrderSub orderSub) {
        log.debug("#### PARAM : {}", orderSub);
        preOrderSubRepository.update(this.converts(orderSub));
    }

    private PreOrderSubData converts(PreOrderSub preOrderSub) {
        PreOrderSubData data = new PreOrderSubData();
        data.setOrderId(preOrderSub.getOrderNumber());
        data.setSerial(preOrderSub.getSerial());
        data.setUse(preOrderSub.getUse());
        data.setParentSerial(preOrderSub.getParentSerial());
        data.setPgTid(preOrderSub.getPgTid());
        data.setProductId(preOrderSub.getProductCode());
        data.setOrderType(preOrderSub.getOrderType().name());
        data.setMemberId(preOrderSub.getMemberId());
        data.setMemberName(preOrderSub.getMemberName());
        data.setPaymentType(preOrderSub.getPaymentType().name());
        data.setPaymentStatus(preOrderSub.getPaymentStatus().name());
        data.setPaymentAmount(preOrderSub.getPaymentAmount());
        data.setCouponAmount(preOrderSub.getCouponAmount());
        data.setPointAmount(preOrderSub.getPointAmount());
        data.setProductAmount(preOrderSub.getProductAmount());
        data.setSalesAmount(preOrderSub.getSalesAmount());
        data.setQuantity(preOrderSub.getQuantity());
        data.setTotalProductAmount(preOrderSub.getTotalProductAmount());
        data.setTotalSalesAmount(preOrderSub.getTotalSalesAmount());
        data.setDomestic(preOrderSub.getDomestic());
        data.setDeliveryNumber(preOrderSub.getDeliveryNumber());
        data.setMemo(preOrderSub.getMemo());
        data.setCategoryId(preOrderSub.getCategorySequence());
        data.setCancelReason(preOrderSub.getCancelReason());
        data.setCustomMessage(preOrderSub.getCustomMessage());
        data.setExchangeRate(preOrderSub.getExchangeRate());
        data.setCjFlag(preOrderSub.getCjFlag());
        data.setCreateId(preOrderSub.getCreateId());
        data.setUpdatedId(preOrderSub.getUpdatedId());
        return data;
    }

    private PreOrderSub converts(PreOrderSubData data) {
        PreOrderSub orderSub = new PreOrderSub();
        orderSub.setOrderNumber(data.getOrderId());
        orderSub.setSerial(data.getSerial());
        orderSub.setUse(data.getUse());
        orderSub.setParentSerial(data.getParentSerial());
        orderSub.setPgTid(data.getPgTid());
        orderSub.setProductCode(data.getProductId());
        orderSub.setOrderType(OrderSubType.valueOf(data.getOrderType()));
        orderSub.setMemberId(data.getMemberId());
        orderSub.setMemberName(data.getMemberName());
        orderSub.setPaymentType(PayType.valueOf(data.getPaymentType()));
        orderSub.setPaymentStatus(PaymentStatus.valueOf(data.getPaymentStatus()));
        orderSub.setPaymentAmount(data.getPaymentAmount());
        orderSub.setCouponAmount(data.getCouponAmount());
        orderSub.setPointAmount(data.getPointAmount());
        orderSub.setProductAmount(data.getProductAmount());
        orderSub.setSalesAmount(data.getSalesAmount());
        orderSub.setQuantity(data.getQuantity());
        orderSub.setTotalProductAmount(data.getTotalProductAmount());
        orderSub.setTotalSalesAmount(data.getTotalSalesAmount());
        orderSub.setDomestic(data.getDomestic());
        orderSub.setDeliveryNumber(data.getDeliveryNumber());
        orderSub.setMemo(data.getMemo());
        orderSub.setCategorySequence(data.getCategoryId());
        orderSub.setCancelReason(data.getCancelReason());
        orderSub.setCustomMessage(data.getCustomMessage());
        orderSub.setExchangeRate(data.getExchangeRate());
        orderSub.setCjFlag(data.getCjFlag());
        orderSub.setCreateId(data.getCreateId());
        orderSub.setUpdatedId(data.getUpdatedId());
        orderSub.setCreateDate(data.getCreateDate());
        orderSub.setUpdateDate(data.getUpdateDate());
        return orderSub;
    }
}
