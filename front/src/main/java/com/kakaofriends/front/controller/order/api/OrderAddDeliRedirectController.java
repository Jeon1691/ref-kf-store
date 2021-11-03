package com.kakaofriends.front.controller.order.api;

import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.controller.order.vo.InicisMobilePayment;
import com.kakaofriends.front.controller.order.vo.InicisPayment;
import com.kakaofriends.front.controller.order.vo.OrderPayment;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

/**
 * Created by eunduck on 2018. 2. 1..
 */
@RestController
@Slf4j
@RequestMapping("/orderadddeli")
public class OrderAddDeliRedirectController {

    @Autowired
    private OrderAddDeliRestController orderController;

    @Autowired
    private LocaleUtils localeUtils;

    private final String ADDDELI_SESSION_KEY = "adddeli";

    @GetMapping("/kakaopay")
    public ModelAndView redirectKakao(@RequestParam("pg_token") String pgToken, HttpSession session, RedirectAttributes redirectAttributes) {
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setKakaoToken(pgToken);
        try{
            orderController.execute(PaymentGateway.KAKAOPAY, orderPayment, session);
        } catch (Exception e) {
            log.error(">>> [ADDDELI] [kakaopay] error: "+ e.getMessage());
            log.debug(e.getMessage());
        }
        ModelAndView mav = new ModelAndView();
        RedirectView redirectView = new RedirectView(getUrl(session));
        redirectView.setExposeModelAttributes(false);
        mav.setView(redirectView);
        return mav;
    }

    @PostMapping(value = "/inicis", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView redirectInicis(InicisPayment inicis, HttpSession session, RedirectAttributes redirectAttributes) {
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
        try{
            orderController.execute(PaymentGateway.INICIS, orderPayment, session);
        } catch (Exception e) {
            log.error(">>> [ADDDELI] [inicis] error: "+ e.getMessage());
            redirectAttributes.addFlashAttribute("errMsg", e.getMessage());
            log.debug(e.getMessage());
        }
        ModelAndView mav = new ModelAndView();
        RedirectView redirectView = new RedirectView(getUrl(session));
        redirectView.setExposeModelAttributes(false);
        mav.setView(redirectView);
        return mav;
    }

    @RequestMapping(value = "/inicis/mobile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView redirectInicis(InicisMobilePayment inicis, HttpSession session, RedirectAttributes redirectAttributes) {
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setTid(inicis.getP_TID());
        orderPayment.setInicisMobileUrl(inicis.getP_REQ_URL());
        try{
            orderController.execute(PaymentGateway.INICIS_MOBILE, orderPayment, session);
        } catch (Exception e) {
            log.error(">>> [ADDDELI] [inicis/mobile] error: "+ e.getMessage());
            log.debug(e.getMessage());
        }
        ModelAndView mav = new ModelAndView();
        mav.setView(new RedirectView(getUrl(session)));
        return mav;
    }

    @GetMapping("/kakaopay/cancel")
    public ModelAndView redirectCancel(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setView(new RedirectView(getUrl(session)));
        return mav;
    }

    private String getUrl(HttpSession session){
        OrderAddDeli orderAddDeli = (OrderAddDeli) session.getAttribute(ADDDELI_SESSION_KEY);
        if(FriendsUtil.isAnonymousUser()) {
            return "/" + localeUtils.whereAreYou() + "/order/shippingNonmember";
        } else {
            return "/" + localeUtils.whereAreYou() + "/order/shipping/" + orderAddDeli.getOdOmNum();
        }
    }
}
