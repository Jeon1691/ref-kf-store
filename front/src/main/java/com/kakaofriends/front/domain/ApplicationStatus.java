package com.kakaofriends.front.domain;

/**
 * Created by pd.jang on 2017. 9. 27..
 */
public class ApplicationStatus {
    public static enum APP_STATUS {

        SUCCESS(1, "success", "All things are going good"),
        WARNING(2, "warning", "SOMETHING IS BAD"),
        FAIL(3, "fail", "Its failed"),
        SUBFAIL(3, "subfail", "하위정보가 존재하여 수행할수 없습니다."),
        ERROR(4, "error", "Its an Error"),
        FATAL(5, "fatal", "Its crashed"),
        NODATA(6, "nodata", "데이터가 없습니다"),
        DUPDATA(7, "Data Duplication", "중복된 데이터가 있습니다."),
        PARAMERR(8, "Insufficient Parameter", "필수 파라메터가 없습니다.");

        private String statusMessage;
        private String statusCode;
        private int statusLevel;
        private APP_STATUS(int statusLevel, String statusCode, String statusMessage){
            this.statusLevel = statusLevel;
            this.statusCode = statusCode;
            this.statusMessage = statusMessage;
        }

        public int getStatusLevel() {
            return statusLevel;
        }

        public String getStatusCode(){
            return statusCode;
        }

        public String getStatusMessage(){
            return statusMessage;
        }

        public boolean isAttentionRequired(){
            if(statusLevel<3)
                return false;
            else
                return true;
        }

    }

    public void handleAppStatusChange(APP_STATUS newStatus){
        if(newStatus.isAttentionRequired()){

            System.out.println("Some problem with application. Application is in " + newStatus + " status.");
        }
    }
}
