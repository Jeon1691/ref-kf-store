package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderShippingInfo implements Serializable {
    private OrderInfo orderInfo;
    private OrderAddressDto.request orderAddressRequest;
    private List<OrderSubDto.OrderSubShipping> orderSubList;

    public boolean getGlobal() {
        return this.getOrderInfo().getOmDeliinoutType().equals(DeliInOutType.DOMESTIC.getCode());
    }
}
