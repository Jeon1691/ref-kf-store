package com.kakaofriends.front.service.giftcard;

import com.kakaofriends.front.common.exception.InvalidateException;
import com.kakaofriends.front.controller.order.validator.OrderValidator;
import com.kakaofriends.front.domain.GiftCardExpansion;
import com.kakaofriends.front.domain.giftcard.GiftCardData;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.repository.giftcard.GiftCardRepository;
import com.kakaofriends.front.service.giftcard.history.GiftCardHistoryService;
import com.kakaofriends.front.service.giftcard.vo.GiftCard;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMaster;
import com.kakaofriends.front.service.giftcard.vo.GiftCardStatus;
import com.kakaofriends.front.utils.LocalDateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dominic.lee on 2016. 10. 23..
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class GiftCardServiceImpl implements GiftCardService {

    private GiftCardRepository giftCardRepository;
    private GiftCardMasterService giftCardMasterService;
    private GiftCardHistoryService giftCardHistoryService;

    private OrderValidator orderValidator;

    @Override
    public GiftCardExpansion findOneByGiftCardCode(String gcCode) {
        return giftCardRepository.findOneByGiftCardCode(gcCode);
    }

    // 마이페이지 포인트 쿠폰 유효체크 2017.10.23
    @Override
    public GiftCardExpansion findOneByGiftPointCardCode(String gcCode) {
        return giftCardRepository.findOneByGiftPointCardCode(gcCode);
    }

    // 마이페이지 온라인 지류 쿠폰 유효체크 2017.10.30
    @Override
    public TbKfoMbsCouponHistory findOneByOnlineCouponCode(String gcCode) {
        return giftCardRepository.findOneByOnlineCouponCode(gcCode);
    }

    @Override
    public Map<String, Object> confirmGiftCardNumber(String language, String couponNum, int totalAmt, int totalAmtNoDeli) {
        GiftCardExpansion giftCardExpansion = findOneByGiftCardCode(couponNum);

        Map<String, Object> resultMap = new HashMap<>();
        String msg = orderValidator.getValidateMessageByGiftCard(language, giftCardExpansion, totalAmt, totalAmtNoDeli);
        resultMap.put("resultMsg", msg);
        resultMap.put("giftCardExpansion", giftCardExpansion);
        resultMap.put("deliValueByGiftcard", orderValidator.getValidateDeliByGiftCard(msg, giftCardExpansion, totalAmt, totalAmtNoDeli));


        return resultMap;
    }

    @Override
    @Transactional(readOnly = true)
    public GiftCard get(String giftCardCode) {
        GiftCardData data = giftCardRepository.select(giftCardCode);
        return this.converts(data);
    }

    @Override
    @Transactional(readOnly = true)
    public GiftCard getWithMaster(String giftCardCode) {
        GiftCard giftCard = this.get(giftCardCode);
        giftCard.setGiftCardMaster(giftCardMasterService.get(giftCard.getGiftCardMasterCode()));
        return giftCard;
    }

    @Override
    @Transactional
    public void edit(GiftCard giftCard) {
        giftCardRepository.update(this.converts(giftCard));
    }

    @Override
    @Transactional
    public void redeemGiftCard(Long memberId, String orderNumber, List<String> codeList) {
        if (codeList != null && !codeList.isEmpty()) {
            for (String code : codeList) {
                this.redeemGiftCard(memberId, orderNumber, code);
            }
        }
    }

    private void redeemGiftCard(Long memberId, String orderNumber, String code) {
        log.info("#### PARAM : memberId = {}, orderNumber = {}, giftCardCode = {}", memberId, orderNumber, code);
        GiftCard giftCard = this.getWithMaster(code);
        giftCard.setStatus(GiftCardStatus.ALREADY_USED);
        giftCard.setUsedDate(LocalDateTime.now());
        giftCard.setOrderNumber(orderNumber);
        giftCard.setMemberId(memberId);
        giftCard.setModifiedId(String.valueOf(memberId));
        this.edit(giftCard);
        giftCardHistoryService.add(giftCard);
    }

    @Override
    @Transactional(readOnly = true)
    public void validate(List<String> giftCardCodeList) {
        int defaultGiftCard = 0;
        int doubleGiftCard = 0;
        if (giftCardCodeList != null && !giftCardCodeList.isEmpty()) {
            for (String code : giftCardCodeList) {
                GiftCard giftCard = this.getWithMaster(code);
                GiftCardMaster master = giftCard.getGiftCardMaster();

                this.validate(giftCard);

                if (master.isDuplication()) {
                    doubleGiftCard++;
                } else {
                    defaultGiftCard++;
                }
            }

            if (defaultGiftCard > 1 || doubleGiftCard > 1) {
                throw new InvalidateException("giftCard.error.message.01");
            }
        }
    }

    private void validate(GiftCard giftCard) {
        if (!giftCard.getStatus().equals(GiftCardStatus.AVAILABLE)) {
            throw new InvalidateException("giftCard.error.message.01");
        }
        if (!LocalDateTimeUtil.isTime(giftCard.getStartDate(), giftCard.getEndDate())) {
            throw new InvalidateException("giftCard.error.message.04");
        }
    }

    private GiftCard converts(GiftCardData data) {
        GiftCard giftCard = new GiftCard();
        giftCard.setCode(data.getGcCode());
        giftCard.setGiftCardMasterCode(data.getGcGcmCode());
        giftCard.setPrice(data.getGcPrice());
        giftCard.setStatus(GiftCardStatus.get(data.getGcUse()));

        giftCard.setStartDate(data.getGcSDate());
        giftCard.setEndDate(data.getGcEDate());
        giftCard.setOrderNumber(data.getGcOmNum());
        giftCard.setUsedDate(data.getGcUseDate());
        try {
            giftCard.setMemberId(Long.parseLong(data.getGcUserId()));
        } catch (NumberFormatException e) {
            log.debug("#### GiftCard memberId parsing error = {}", e.getMessage());
        }
        giftCard.setMemberPhone(data.getGcPhone());
        giftCard.setMemberName(data.getGcName());
        giftCard.setMemberEmail(data.getGcEmail());

        giftCard.setCalculateStatus(data.getGcCal());
        giftCard.setResetCount(data.getGcResetCnt());
        giftCard.setExtensionCount(data.getGcExtCnt());
        giftCard.setExtensionDate(data.getGcExtDate());
        giftCard.setStopDate(data.getGcStopDate());
        giftCard.setStopReason(data.getGcReason());

        giftCard.setInsertedDate(data.getGcInDate());
        giftCard.setModifiedDate(data.getGcMoDate());
        giftCard.setInsertedId(data.getGcInId());
        giftCard.setModifiedId(data.getGcMoId());

        return giftCard;
    }

    private GiftCardData converts(GiftCard giftCard) {
        GiftCardData data = new GiftCardData();
        data.setGcCode(giftCard.getCode());
        data.setGcGcmCode(giftCard.getGiftCardMasterCode());
        data.setGcPrice(giftCard.getPrice());
        data.setGcUse(giftCard.getStatus().getCode());
        data.setGcSDate(giftCard.getStartDate());
        data.setGcEDate(giftCard.getEndDate());
        data.setGcOmNum(giftCard.getOrderNumber());
        data.setGcUseDate(giftCard.getUsedDate());
        data.setGcUserId(String.valueOf(giftCard.getMemberId()));
        data.setGcName(giftCard.getMemberName());
        data.setGcPhone(giftCard.getMemberPhone());
        data.setGcEmail(giftCard.getMemberEmail());
        data.setGcCal(giftCard.getCalculateStatus());
        data.setGcResetCnt(giftCard.getResetCount());
        data.setGcExtCnt(giftCard.getExtensionCount());
        data.setGcExtDate(giftCard.getExtensionDate());
        data.setGcStopDate(giftCard.getStopDate());
        data.setGcReason(giftCard.getStopReason());
        data.setGcInDate(giftCard.getInsertedDate());
        data.setGcMoDate(giftCard.getModifiedDate());
        data.setGcInId(giftCard.getInsertedId());
        data.setGcMoId(giftCard.getModifiedId());
        return data;
    }
}
