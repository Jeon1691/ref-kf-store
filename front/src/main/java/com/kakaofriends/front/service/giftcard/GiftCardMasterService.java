package com.kakaofriends.front.service.giftcard;

import com.kakaofriends.front.domain.giftcard.GiftCardMasterData;
import com.kakaofriends.front.repository.giftcard.GiftCardMasterRepository;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMaster;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMasterOptionType;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMasterType;
import com.kakaofriends.front.utils.Converter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GiftCardMasterService
 *
 * Author  april
 * Date    2018. 2. 8.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class GiftCardMasterService {
    private GiftCardMasterRepository giftCardMasterRepository;

    public GiftCardMaster get(String masterCode) {
        GiftCardMasterData data = giftCardMasterRepository.select(masterCode);
        return this.converts(data);
    }

    private GiftCardMaster converts(GiftCardMasterData data) {
        GiftCardMaster master = new GiftCardMaster();
        master.setCode(data.getGcmCode());
        master.setName(data.getGcmName());
        master.setDescription(data.getGcmGoal());
        master.setDescriptionEnglish(data.getGcmEGoal());
        master.setEa(data.getGcmEa());
        master.setStartDate(data.getGcmSDate());
        master.setEndDate(data.getGcmEDate());
        master.setPrice(data.getGcmPrice());
        master.setType(GiftCardMasterType.get(data.getGcmType()));
        master.setInsertedDate(data.getGcmInDate());
        master.setModifiedDate(data.getGcmMoDate());
        master.setInsertedId(data.getGcmInId());
        master.setModifiedId(data.getGcmMoId());
        master.setReservedIssueTime(data.getGcmTime());
        master.setMemo(data.getGcmMemo());
        master.setLevel(data.getGcmLevel());
        master.setOptionType(GiftCardMasterOptionType.get(data.getGcmOptionType()));
        master.setOptionValue(data.getGcmOptionValue());
        master.setOptionCategory(data.getGcmOptionCategory());
        master.setDuplication(Converter.convertToBoolean(data.getGcmDuplication()));
        return master;
    }
}
