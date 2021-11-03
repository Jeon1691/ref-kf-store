package com.kakaofriends.front.domain.kims;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dave on 2017. 7. 5..
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaMessageServiceDto {
    private String callerNumber;
    private String receiverNumber;
    private String subject;
    private String message;
}
