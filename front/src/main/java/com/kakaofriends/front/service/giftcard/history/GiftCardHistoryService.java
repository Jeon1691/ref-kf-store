package com.kakaofriends.front.service.giftcard.history;

import com.kakaofriends.front.domain.giftcard.CouponHistoryData;
import com.kakaofriends.front.repository.giftcard.CouponHistoryRepository;
import com.kakaofriends.front.service.giftcard.history.vo.GiftCardHistory;
import com.kakaofriends.front.service.giftcard.vo.GiftCard;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMaster;
import com.kakaofriends.front.utils.Converter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * GiftCardHistoryService
 *
 * Author  april
 * Date    2018. 2. 8.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class GiftCardHistoryService {
    private CouponHistoryRepository couponHistoryRepository;

    @Transactional
    public void add(GiftCardHistory history) {
        couponHistoryRepository.insert(this.converts(history));
    }

    @Transactional
    public void add(GiftCard giftCardWithMaster) {
        this.add(this.converts(giftCardWithMaster));
    }

    private CouponHistoryData converts(GiftCardHistory history) {
        CouponHistoryData data = new CouponHistoryData();
        data.setCphSeq(history.getSequence());
        data.setCphUserId(history.getMemberId());
        data.setCphGcmCode(history.getGiftCardMasterCode());
        data.setCphCode(history.getGiftCardCode());
        data.setCphPrice(history.getPrice());
        data.setCphSDate(history.getStartDate());
        data.setCphEDate(history.getEndDate());
        data.setCphUse(history.getStatus().getCode());
        data.setCphUseDate(history.getUsedDate());
        data.setCphOmNum(history.getOrderNumber());
        data.setCphType(history.getType().getCode());
        data.setCphLevel(history.getLevel());
        data.setCphOptionType(history.getOptionType().getCode());
        data.setCphOptionValue(history.getOptionValue());
        data.setCphName(history.getName());
        data.setCphEName(history.getNameEnglish());
        data.setCphOptionCategory(history.getOptionCategory());
        data.setCphTitle(history.getTitle());
        data.setCphDuplication(Converter.convertToString(history.isDuplication()));
        return data;
    }

    private GiftCardHistory converts(GiftCard giftCard) {
        GiftCardHistory history = new GiftCardHistory();
        history.setMemberId(giftCard.getMemberId());
        history.setGiftCardMasterCode(giftCard.getGiftCardMasterCode());
        history.setGiftCardCode(giftCard.getCode());
        history.setPrice(giftCard.getPrice());
        history.setStartDate(giftCard.getStartDate());
        history.setEndDate(giftCard.getEndDate());
        history.setStatus(giftCard.getStatus());
        history.setUsedDate(giftCard.getUsedDate());
        history.setOrderNumber(giftCard.getOrderNumber());
        GiftCardMaster master = giftCard.getGiftCardMaster();
        history.setType(master.getType());
        history.setLevel(master.getLevel());
        history.setOptionType(master.getOptionType());
        history.setOptionValue(master.getOptionValue());
        history.setName(master.getDescription());
        history.setNameEnglish(master.getDescriptionEnglish());
//        history.setOptionCategory(Long.valueOf(master.getOptionCategory()));
        history.setTitle(master.getName());
        history.setDuplication(master.getDuplication());
        return history;
    }
}
