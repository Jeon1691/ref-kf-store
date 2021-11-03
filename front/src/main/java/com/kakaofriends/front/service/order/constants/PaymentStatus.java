package com.kakaofriends.front.service.order.constants;

/**
 * PaymentStatus
 *
 * Author  april
 * Date    2018. 3. 20.
 */
public enum PaymentStatus {
    PREPARATION(1),
    PROCESSING(2),
    COMPLETE(3);

    int index;

    PaymentStatus(int index) {
        this.index = index;
    }

    private int getIndex() {
        return index;
    }

    private PaymentStatus get(int index) {
        for (PaymentStatus status : PaymentStatus.values()) {
            if (index == status.getIndex()) {
                return status;
            }
        }
        return null;
    }

    public PaymentStatus getPrevious() {
        PaymentStatus status = this.get(this.index - 1);
        if (status != null) {
            return status;
        }
        return PaymentStatus.PREPARATION;
    }

    public PaymentStatus getNext() {
        PaymentStatus status = this.get(this.index + 1);
        if (status != null) {
            return status;
        }
        return PaymentStatus.COMPLETE;
    }


}