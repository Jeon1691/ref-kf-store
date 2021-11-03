package com.kakaofriends.front.controller.order.api;

import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.common.exception.InvalidOrderException;
import com.kakaofriends.front.common.exception.OrderTimeOutException;
import com.kakaofriends.front.common.exception.PaymentException;
import com.kakaofriends.front.common.exception.SessionTimeOutException;
import com.kakaofriends.front.controller.order.vo.InicisMobilePayment;
import com.kakaofriends.front.controller.order.vo.InicisPayment;
import com.kakaofriends.front.controller.order.vo.OrderPayment;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * OrderRedirectController : 결제사의 응답을 받는 controller
 *
 * Author  april
 * Date    2018. 1. 23.
 */
@RestController
@Slf4j
@RequestMapping("/order")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderRedirectController {

    private OrderController orderController;
    private MessageSource messageSource;

    @GetMapping(value = "/kakaopay")
    public RedirectView redirectKakao(@RequestParam("pg_token") String pgToken, Locale locale,
                                      HttpSession session, RedirectAttributes redirectAttributes) {
        log.info("#### Accepted response by Kakaopay : pgToken = {}", pgToken);
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setKakaoToken(pgToken);
        return executePayment(locale, session, redirectAttributes, orderPayment, PaymentGateway.KAKAOPAY);
    }

    @GetMapping(value = "/kakaopay/failure", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RedirectView redirectKakaoSessionTimeOut(Locale locale) {
        log.warn("#### Kakaopay failure");
        return this.redirectToOrderSheet(locale);
    }

    @GetMapping(value = "/{payment}/cancel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RedirectView cancelRedirect(@PathVariable String payment, Locale locale, RedirectAttributes redirectAttributes) {
        PaymentGateway paymentGateway = PaymentGateway.valueOf(payment.toUpperCase());
        log.info("#### Payment interrupted by user : pg = {}", paymentGateway);
        return redirectToOrderSheet(locale, redirectAttributes, FriendsUtil.processMessage(messageSource, "soldOut.pay.Cancel"));
    }

    @PostMapping(value = "/inicis", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RedirectView redirectInicis(InicisPayment inicis, Locale locale, HttpSession session, RedirectAttributes redirectAttributes) {
        log.info("#### Accepted response by Inicis : PARAM = {}", inicis);
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setTid(inicis.getIni_certid());
        orderPayment.setUid(inicis.getUid());
        orderPayment.setMemberName(inicis.getBuyername());
        orderPayment.setMemberPhone(inicis.getBuyertel());
        orderPayment.setMemberEmail(inicis.getBuyeremail());
        orderPayment.setCardCode(inicis.getCardcode());
        orderPayment.setPayMethod(inicis.getPaymethod());
        orderPayment.setEncrypted(inicis.getEncrypted());
        orderPayment.setSessionKey(inicis.getSessionkey());
        return executePayment(locale, session, redirectAttributes, orderPayment, PaymentGateway.INICIS);
    }

    @RequestMapping(value = "/inicis/mobile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = { RequestMethod.GET, RequestMethod.POST })
    public RedirectView redirectInicis(InicisMobilePayment inicis, Locale locale, HttpSession session, RedirectAttributes redirectAttributes) {
        log.info("#### Accepted response by Inicis Mobile : PARAM = {}", inicis);
        if (StringUtils.isEmpty(inicis.getP_TID())) {
            log.info("#### Payment interrupted by user : pg = INICIS_MOBILE");
            return redirectToOrderSheet(locale, redirectAttributes, FriendsUtil.processMessage(messageSource, "soldOut.pay.Cancel"));
        }
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setTid(inicis.getP_TID());
        orderPayment.setInicisMobileUrl(inicis.getP_REQ_URL());
        return executePayment(locale, session, redirectAttributes, orderPayment, PaymentGateway.INICIS_MOBILE);
    }

    private RedirectView executePayment(Locale locale, HttpSession session, RedirectAttributes redirectAttributes,
                                        OrderPayment orderPayment, PaymentGateway paymentGateway) {
        try {
            orderController.execute(paymentGateway, orderPayment, locale, session);
        } catch (PaymentException pe) {
            return redirectToOrderSheet(locale, redirectAttributes, pe.getMessage());
        } catch (OrderTimeOutException oe) {
            throw new SessionTimeOutException();
        } catch (InvalidOrderException ie) {
            log.warn("#### InvalidOrderException Caught PG = {}, {}", paymentGateway, orderPayment);
            return redirectToOrderSheet(locale, redirectAttributes, FriendsUtil.processMessage(messageSource, "pay.network.error"));
        } catch (Exception e) {
            log.error("#### Exception Caught = {}", e.getMessage());
            log.error("#### Exception Caught = {}", e);
            return redirectToOrderSheet(locale, redirectAttributes, FriendsUtil.processMessage(messageSource, "common.error.alert.500"));
        }
        return redirectToOrderComplete(locale);
    }

    private RedirectView redirectToOrderSheet(Locale locale, RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute("errMsg", message);
        return this.redirectToOrderSheet(locale);
    }

    private RedirectView redirectToOrderSheet(Locale locale) {
        return new RedirectView(FriendsUtil.getLanguagePath(locale) + "/order/sheet");
    }

    private RedirectView redirectToOrderComplete(Locale locale) {
        return new RedirectView(FriendsUtil.getLanguagePath(locale) + "/order/complete");
    }
}
