package com.kakaofriends.front.domain;

/**
 * Created by Dave on 2017. 5. 15..
 */
public enum EmsDeliStatusType {
    STATUS_RC("RC","출고 완료","Preparing to ship overseas"),
    STATUS_PR("PR","우체국 접수","Preparing to ship overseas"),
    STATUS_SR("SR","발송 준비","Preparing to ship overseas"),
    STATUS_AS("AS","항공기 출발","En route"),
    STATUS_CA("CA","상대국 도착","En route"),
    STATUS_DR("DR","배송 완료","Delivery complete"),
    STATUS_DE("DE","배송 준비","Delivery ready"),
    STATUS_OC("OC","주문 취소","Order cancel"),
    STATUS_YD("YD","미배달","Non-delivery");

    final String code;
    final String statusKr;
    final String statusEn;


    EmsDeliStatusType(String code, String statusKr, String statusEn){
        this.code = code;
        this.statusKr = statusKr;
        this.statusEn = statusEn;
    }

    public String getCode() {
        return code;
    }

    public String getStatusKr() {
        return statusKr;
    }

    public String getStatusEn() {
        return statusEn;
    }

    public static String getStatusEnByStatusCode(String status){
        for(EmsDeliStatusType emsDeliStatusType : EmsDeliStatusType.values()){
            if(emsDeliStatusType.code.equals(status)){
                return emsDeliStatusType.getStatusEn();
            }
        }
        return "";
    }
}
