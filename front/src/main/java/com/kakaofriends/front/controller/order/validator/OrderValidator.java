package com.kakaofriends.front.controller.order.validator;

import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.domain.Config;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.common.event.DomesticEvent;
import com.kakaofriends.front.common.event.GlobalEmsEvent;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.mypage.MyCouponCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.order.OrderValidationDto;
import com.kakaofriends.front.repository.ConfigRepository;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.EventService;
import com.kakaofriends.front.service.giftcard.GiftCardService;
import com.kakaofriends.front.service.order.BasketService;
import com.kakaofriends.front.utils.BoxUtil;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static com.kakaofriends.core.domain.GiftCard.GC_TYPE_STATE_USE_COMPLETE;
import static com.kakaofriends.core.domain.GiftCard.GC_TYPE_STATE_USE_STOP;
import static com.kakaofriends.front.domain.EventDto.EVENT_USE_FLAG;
import static com.kakaofriends.front.utils.FriendsUtil.*;

/**
 * Created by dominic.lee on 2016. 10. 22..
 */
@Slf4j
@Component("orderValidator")
public class OrderValidator implements Validator {

    @Value("${redis.host}")
    private String redisHostIP;

    @Value("${redis.password}")
    private String redisHostPassword;

	@Autowired
	private BasketService basketService;

	@Autowired
	private GiftCardService giftCardService;

	@Autowired
	private ConfigRepository configRepository;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private DomesticEvent domesticEvent;

	@Autowired
    private EmsService emsService;

    @Autowired
    private GlobalEmsEvent globalEmsEvent;

    @Autowired
    private EventService eventService;

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderValidationDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        OrderValidationDto order = (OrderValidationDto) target;

        // basketSeqIds??? ?????? ????????? ????????????
        // ???????????? ?????? 2018.02.28
        List<BasketExpansion> basketExpansions = basketService.findByBsSeqIds(order.getBsSeqIds(), Country.getCountryCodeByName(order.getOaCountryName()));

        // ?????? ????????? ?????? ??????
        if (order.getBsSeqIds().stream().count() < 1) {
            errors.rejectValue("bsSeqIds", "productCode.invalid", processMessage(messageSource, "productCode.invalid"));
        }

        // ?????? ?????? ??????
        Predicate<BasketExpansion> basketExpansionPredicate = basket -> !(basket.getBasket().getBsOwnerId().equals(FriendsUtil.getFriendsMemberId()));
        if (basketExpansions.stream().filter(basketExpansionPredicate).count() > 0) {
            errors.rejectValue("owner", "owner.invalid", processMessage(messageSource, "owner.invalid"));
        }

        // ?????? ?????? ??????
        if (basketExpansions.stream().filter(BasketExpansion::getIsSoldOut).count() > 0) {
            errors.rejectValue("soldOut", "soldOut.invalid", processMessage(messageSource, "soldOut.invalid"));
        }

        // ???????????? ?????? ?????? ??????
        Predicate<BasketExpansion> unavailablePredicate = basket -> (basket.getBasketInProduct().getPrKrview().equals("N"));
        if (basketExpansions.stream().filter(unavailablePredicate).count() > 0) {
            errors.rejectValue("unavailableProduct", "unavailableProduct.invalid", processMessage(messageSource, "unavailableProduct.invalid"));
        }

        // ?????? ?????? & ?????? ??????
        List<String> giftCardCodes = order.getGiftCardCodes();
            boolean isUseGiftCard = true;
        GiftCardExpansion findGiftCard = null;
        long giftCardAmountSum = 0L;
        boolean giftCardFreeDeli = false;

        if (giftCardCodes != null) {
            for (int i = 0; i < giftCardCodes.size(); i++) {
                String giftCardCode = giftCardCodes.get(i);
                findGiftCard = giftCardService.findOneByGiftCardCode(giftCardCode);
                isUseGiftCard = order.getGiftCardAmount() > 0;
                if (isUseGiftCard && StringUtils.isNotEmpty(giftCardCode) && StringUtils.length(giftCardCode) == 19) {

                    if (findGiftCard == null || findGiftCard.getGiftcard().getGcUse().equals(GC_TYPE_STATE_USE_STOP) || findGiftCard.getGiftcard().getGcUse().equals(GC_TYPE_STATE_USE_COMPLETE)) {
                        errors.rejectValue("giftCardCode", "giftCardCode.invalid", processMessage(messageSource, "giftCard.error.message.01"));
                    }

                    if (findGiftCard != null && findGiftCard.getIsUsePeriodAfter()) {
                        errors.rejectValue("giftCardCode", "giftCardCode.invalid", processMessage(messageSource, "giftCard.error.message.04"));
                    }

                    if (findGiftCard != null && findGiftCard.getIsUsePeriodBefore()) {
                        errors.rejectValue("giftCardCode", "giftCardCode.invalid", processMessage(messageSource, "giftCard.error.message.05"));
                    }

                    if (findGiftCard != null && i == giftCardCodes.size() - 1 && giftCardAmountSum + findGiftCard.getGiftcard().getGcPrice() != order.getGiftCardAmount()) {
                        errors.rejectValue("giftCardCode", "giftCardCode.invalid", processMessage(messageSource, "giftCard.error.message.07"));
                    }

                }
                giftCardAmountSum += findGiftCard.getGiftcard().getGcPrice();
                // ?????? ?????? ?????? ?????? ??????x
                if(findGiftCard.getGcmOptionType() != null && findGiftCard.getGcmOptionType().equalsIgnoreCase(MyCouponCode.OPTION_FREESHIPPING.getCode())) {
                    giftCardFreeDeli = true;
                }
            }
        }

        //?????????
        long pointPrice = order.getPointPrice() == null ? 0L : order.getPointPrice();

        //?????? ??????
        long giftCardAmount = isUseGiftCard && findGiftCard != null ? giftCardAmountSum : 0L;


        // ??? ??????(???????????? ? getPrlpDiscountprice1 : getPrlpSupplyprice) + ????????? - ??????
        long productAmount = basketExpansions.stream().mapToLong(
                basket -> basket.getIsDiscountPeriod()
                        ? basket.getProductLevelPrice().getPrlpDiscountprice1() * basket.getBasket().getBsEa()
                        : basket.getProductLevelPrice().getPrlpSupplyprice() * basket.getBasket().getBsEa()).sum();

        //1?????? ?????? ???????????? ?????????
        Integer findDeliveryLimitAmount = FriendsUtil.getFreeDeliveryFlag() ? 10000 : configRepository.findByCfId("DELIVERYLIMITMONEY").getCfValue();
        //?????? ?????? ??????
        //Integer findDeliveryLimitAmount = configRepository.findByCfId("DELIVERYLIMITMONEY").getCfValue();

        long deliveryAmount = 0L;
        BoxUtil boxUtil = new BoxUtil();
        ArrayList<BoxItem> boxs = new ArrayList<>();
        String deliType = DeliInOutType.DOMESTIC.getName();
        if (StringUtils.isEmpty(order.getOaCountryName()) || order.getOaCountryName().equals("??????") || order.getOaCountryName().toLowerCase().equals("korea")) {
            deliveryAmount = giftCardFreeDeli || (productAmount >= findDeliveryLimitAmount) ? 0L : configRepository.findByCfId("DELIVERYMONEY").getCfValue();
        } else {
            boxs = boxUtil.getBoxs(getItemList(basketExpansions), null);
            deliveryAmount = giftCardFreeDeli ? 0L : getNationalDeliveryCharge(order.getOaCountryName(), boxs, productAmount);
            deliType = DeliInOutType.OVERSEAS.getName();

            if(order.getDeliveryAmount() != null && order.getDeliveryAmount() != deliveryAmount) {
                errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAmount.invalid"));
            }
        }


        long totalAmount = productAmount + deliveryAmount - giftCardAmount - pointPrice;
        long paymentAmount = order.getPaymentAmount();
        long orderAmount = 0;

        // ???????????? ??? ?????? ??????
        if (paymentAmount != totalAmount) {
            errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAmount.invalid"));
        }

        // ?????? ?????? ??????
        ArrayList<Long> longs = Lists.newArrayList(order.getAmt(), order.getP_AMT(), order.getPrice());
        if (longs.stream().filter(e -> null != e && e > 0).count() == 1) {
            orderAmount = longs.stream().filter(e -> null != e && e > 0).findFirst().orElse(0L);
        } else {
            errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAmount.invalid"));
        }

        if (orderAmount != totalAmount) {
            errors.rejectValue("paymentAmount", "paymentAmount.invalid", processMessage(messageSource, "paymentAmount.invalid"));
        }

        // ?????? ?????? ??????
        if (totalAmount <= 999) {
            errors.rejectValue("paymentAmount", "paymentAmount.min.invalid", processMessage(messageSource, "paymentAmount.min.invalid"));
        }

        addRedisOrderInfo(deliType, deliveryAmount, order, boxs);

        log.info("\n\n=================OrderValidator==================\n");
        log.info("## memberId {}", FriendsUtil.getFriendsMemberId());
        log.info("## basketSeqIds {}", order.getBsSeqIds());
        log.info("## productAmount {}", productAmount);
        log.info("## isUseGiftCard {}", isUseGiftCard);
        log.info("## deliveryAmount {}", deliveryAmount);
        log.info("## giftCardAmount {}", giftCardAmount);
        log.info("## giftCardCode {}", order.getGiftCardCodes());
        log.info("## pointPrice {}", pointPrice);
        log.info("## totalAmout {}", totalAmount);
        log.info("## orderAmount {}", orderAmount);
        log.info("## Price {}", order.getPrice());
        log.info("## Amt {}", order.getAmt());
        log.info("## P_AMT {}", order.getP_AMT());
        log.info("\n\n=================================================\n");
    }

	public String getValidateMessageByGiftCard(String language, GiftCardExpansion giftCardExpansion, int totalAmt, int totalAmtNoDeli) {
		String message = null;
		int limitAmt = totalAmt;
		if(giftCardExpansion != null && giftCardExpansion.getGcmLevel().equalsIgnoreCase("W"))
            limitAmt = totalAmtNoDeli;

		if (giftCardExpansion != null) {
			if ("2".equals(giftCardExpansion.getGiftcard().getGcUse())) {
				message = processMessageByLocale(language, messageSource, "giftCard.error.message.02", null);
			}
			if ("3".equals(giftCardExpansion.getGiftcard().getGcUse())) {
				message = processMessageByLocale(language, messageSource, "giftCard.error.message.03", null);
			}
			if (giftCardExpansion.getIsUsePeriodAfter()) {
				message = processMessageByLocale(language, messageSource, "giftCard.error.message.04", null);
			}
			if (giftCardExpansion.getIsUsePeriodBefore()) {
				message = processMessageByLocale(language, messageSource, "giftCard.error.message.05", null);
			}
			if (giftCardExpansion.getGiftcard().getGcPrice() > limitAmt) {
				message = processMessageByLocale(language, messageSource, "giftCard.error.message.06", null);
			}
		} else {
			message = processMessageByLocale(language, messageSource, "giftCard.error.message.01", null);
		}

		return message;
	}

	public int getValidateDeliByGiftCard(String msg, GiftCardExpansion giftCardExpansion, int totalAmt, int totalAmtNoDeli) {
		if (msg == null && FriendsUtil.getFreeDeliveryFlag()) {
			Config deliverylimitmoney = configRepository.findByCfId("DELIVERYLIMITMONEY");
			Config deliverymoney = configRepository.findByCfId("DELIVERYMONEY");
			//1?????? ?????? ???????????? ?????????
			//????????????(?????? - ??????)??? deliverylimitmoney ?????? ?????? ?????? ????????? ?????????.
			if((totalAmtNoDeli - giftCardExpansion.getGcmPrice()) < 10000) {
				return deliverymoney.getCfValue();
			} else {
				return 0;
			}
		}
		return -1;
	}

	// ??????????????? ???????????? 2017.10.23
	public String getValidateMessageByMyGiftCard(GiftCardExpansion giftCardExpansion) {
		String message = null;

		if (giftCardExpansion != null) {
			if ("1".equals(giftCardExpansion.getGiftcard().getGcUse())) {
				message = "mypoint.coupon.message.01"; //????????????
			}
			if ("2".equals(giftCardExpansion.getGiftcard().getGcUse())) {
				message = "giftCard.error.message.02"; //????????????
			}
			if ("3".equals(giftCardExpansion.getGiftcard().getGcUse())) {
				message = "giftCard.error.message.03"; //?????? ??????
			}
			if (giftCardExpansion.getIsUsePeriodAfter()) {
				message = "giftCard.error.message.04"; //????????????
			}
			if (giftCardExpansion.getIsUsePeriodBefore()) {
				message = "giftCard.error.message.05"; //????????????X
			}
		} else {
			message = "mypoint.coupon.message.02";
		}

		return message;
	}

	// ??????????????? ????????????????????? 2017.10.30
	public String getValidateMessageByMyOnlineCoupon(TbKfoMbsCouponHistory kfoMbsCouponHistory) {
		String message = null;

		if (kfoMbsCouponHistory != null) {
			if ("1".equals(kfoMbsCouponHistory.getCPH_USE())) {
				message = "mycoupon.coupon.message.01"; //????????????
			}
			if ("2".equals(kfoMbsCouponHistory.getCPH_USE())) {
				message = "giftCard.error.message.02"; //????????????
			}
			if ("3".equals(kfoMbsCouponHistory.getCPH_USE()) || "4".equals(kfoMbsCouponHistory.getCPH_USE())) {
				message = "giftCard.error.message.03"; //?????? ??????
			}
			if (kfoMbsCouponHistory.getIsUsePeriodAfter()) {
				message = "giftCard.error.message.04"; //????????????
			}
			if (kfoMbsCouponHistory.getIsUsePeriodBefore()) {
				message = "giftCard.error.message.05"; //????????????X
			}
		} else {
			message = "mycoupon.coupon.message.02";
		}

		return message;
	}

    private LinkedList<BoxItem> getItemList(List<BasketExpansion> basketExpansionList){
        LinkedList<BoxItem> itemList = new LinkedList<>();

        basketExpansionList.forEach(e -> {
            long amount = e.getIsDiscountPeriod() ? e.getProductLevelPrice().getPrlpDiscountprice1() : e.getProductLevelPrice().getPrlpSaleprice1();
            for(int i=0; i<e.getBasket().getBsEa(); i++){
                Product product = e.getBasketInProduct();
                itemList.add(new BoxItem(product,amount, null));
            }
        });

        // ????????? ??????: ?????? ???????????? ?????? ??????
        globalEmsEvent.addBoxItem(itemList);

        return itemList;
    }

    private Long getNationalDeliveryCharge(String countryCode, ArrayList<BoxItem> boxs, long basketAccount){
        Long nationalDeliveryCharge = new Long(0L);
        if(countryCode == null)
            return nationalDeliveryCharge;

        if(!countryCode.equals("KR") && !(countryCode.equals("??????") || countryCode.toLowerCase().equals("korea"))) {
            String country = Country.getCountryCodeByName(countryCode);

            for (int i=0; i<boxs.size(); i++) {
                BoxItem box = boxs.get(i);
                Long emsPrice = emsService.getEmsPrice(country, box.getWeight());
                // ??????????????? ????????? ??????
                box.setAmount(emsPrice);
                if(emsPrice != null){
                    nationalDeliveryCharge += emsPrice;
                }
            }

            EventDto eventDto = eventService.findEvent(EventOrderType.GLOBAL.getCode(), EventType.DELIVERY.getCode(), basketAccount, EVENT_USE_FLAG, new Date());
            if(eventDto != null) {
                log.info("## ????????? ?????? ????????? ");
                return 0L;
            }

        }
        return nationalDeliveryCharge;
    }

    /**
     * ?????? ?????? ??????????????? ?????? Redis ??????
     */
    private void addRedisOrderInfo(String deliType, long deliveryAmount, OrderValidationDto order, ArrayList<BoxItem> boxs) {
        try {
            if(deliveryAmount == 0L) {
                Jedis jedis = new Jedis(redisHostIP);
                if(StringUtils.isNotEmpty(redisHostPassword)) {
                    jedis.auth(redisHostPassword);
                }
                LocalDateTime dateTime = LocalDateTime.now();
                String keyStr = "FreeDelivery" + dateTime.toString();

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("deliType", deliType);
                jsonObject.put("member", getFriendsMember());
                jsonObject.put("orderCountry", order.getOaCountryName());
                jsonObject.put("order", order);
                jsonObject.put("boxs", boxs);
                jsonObject.put("basketSeqIds", order.getBsSeqIds());
                jsonObject.put("giftCardCode", order.getGiftCardCodes());
                jsonObject.put("Price", order.getPrice());
                jsonObject.put("Amt", order.getAmt());
                jsonObject.put("P_AMT", order.getP_AMT());
                jsonObject.put("year", dateTime.getYear());
                jsonObject.put("month", dateTime.getMonthValue());
                jsonObject.put("day", dateTime.getDayOfMonth());
                jsonObject.put("hour", dateTime.getHour());
                jedis.set(keyStr, jsonObject.toJSONString());

                log.info("## {} ????????? ?????? ??????  order = {}, boxs = {}", deliType, order, boxs);
            }
        } catch (Exception e) {
            log.error("## {} ????????? ?????? ?????? ?????? : order = {}, boxs = {}, error = {}", deliType, order, boxs, e);
        }
    }
}
