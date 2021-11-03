package com.kakaofriends.front.domain.kims;

import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Data
public class WakeUpDeveloper extends ShortMessageServiceDto {
    @Autowired
    KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;

    /*private String callerNumber = "81818181";
    private String receiverNumber;
    private String countryCode = "82";
    private String message = "결제 장애 발생 - 확인할 것 : ";
    private String type = "normal";*/

    public WakeUpDeveloper() {
    }

    public WakeUpDeveloper(String receiverNumber) {
        super("81818181", receiverNumber, "82", "결제 장애 발생 - 확인할 것 : " + new Date(), "normal");
    }

    public void sendWakeUpMessageToDeveloper() throws Exception {
        String[] developerPhoneNumber = {"01081811891", "01045739365","01049142162","01093987931"};
        for (String phone : developerPhoneNumber) {
            WakeUpDeveloper developer = new WakeUpDeveloper(phone);
            kakaoIntegratedMessagingComponent.sendShortMessageService(developer);
        }
    }


}
