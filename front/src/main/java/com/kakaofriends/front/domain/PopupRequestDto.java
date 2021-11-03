package com.kakaofriends.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PopupRequestDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CommonConfirmRequest{
        String popupMessage;
        String returnUrl;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class OrderManageRequest{
        String orderNumber;
        Integer orderSubSequence;
        String ownerName;
        String popupMessage;
        String returnUrl;
    }
}
