package com.kakaofriends.front.common.external.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.inicis.util.etc.INIdata;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.api.PayResult;
import com.kakaofriends.front.domain.payment.PayCancel;
import com.kakaofriends.front.domain.payment.PayCancelResultData;
import com.kakaofriends.front.domain.payment.PayMethodType;
import com.kakaofriends.front.repository.OrderTempRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Component(value = "iniPayComponent")
public class IniPayComponent implements PayComponent {

	@Value("${pgIniPay50.inipayhome}")
	private String iniPayHome;

	@Value("${pgIniPay50.mid}")
	private String mid;

	@Value("${pgIniPay50.admin}")
	private String admin;

	@Value("${kakaoFriends.online.store.url}")
	private String kakaoFriendsOnlineStoreUrl;

    @Value("${kfo.payment.domain}")
    private String paymentDomain;

    @Value("${kfo.payment.inicis.post.process}")
    private String paymentInicisPostProcess;

    @Value("${kfo.payment.inicis.pre.process}")
    private String paymentInicisPreProcess;

    @Value("${kfo.payment.inicis.cancel.process}")
    private String paymentInicisCancelProcess;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private OrderTempRepository orderTempRepository;

	@PostConstruct
	private void init() {
		if (this.iniPayHome.isEmpty() && servletContext != null) {
			this.iniPayHome = servletContext.getRealPath("/WEB-INF/pg/INIpay50");
		}
	}

	@Override
	public List<PayMethodType> getPayMethodType() {
		return Lists.newArrayList(PayMethodType.ONLYCARD, PayMethodType.ONLYDBANK);
	}

    /**
     * 이니시스 웹 결재 주문 취소
     */
	@Override
	public PayCancelResultData cancelProcessing(HttpServletRequest httpServletRequest, PayCancel payCancel) {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("payCancel", payCancel);

        PayResult payResult = new PayResult();
        INIdata inipay = new INIdata();
        try {
            String resResult = KakaoFriendsUtil.httpEntity(httpServletRequest, paymentDomain + paymentInicisCancelProcess, HttpMethod.POST, multiValueMap);
            payResult = objectMapper.readValue(resResult, PayResult.class);
            inipay = objectMapper.convertValue(payResult.getResultObj(), INIdata.class);
        } catch (Exception e) {
            log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            PayCancelResultData payCancelResultData = new PayCancelResultData();
            payCancelResultData.setCancelSuccess(false);
            return payCancelResultData;
        }

        log.info("## 이니시스 결재 취소 :: ResultCode  = {}, ResultMsg = {}", inipay.getResult("ResultCode"), inipay.getResult("ResultMsg"));
		PayCancelResultData payCancelResultData = new PayCancelResultData();

		/****************************************************************
		 * 5. 취소 결과
		 *
		 * 결과코드 : inipay.getResult("ResultCode") ("00"이면 취소 성공)
		 * 결과내용 : inipay.getResult("ResultMsg") (취소결과에 대한 설명)
		 * 취소날짜 : inipay.getResult("CancelDate") (YYYYMMDD)
		 * 취소시각 : inipay.getResult("CancelTime") (HHMMSS)
		 * 현금영수증 취소 승인번호 : inipay.getResult("CSHR_CancelNum")
		 * (현금영수증 발급 취소시에만 리턴됨)
		 ****************************************************************/
		payCancelResultData.setResultCode(inipay.getResult("ResultCode"));
		payCancelResultData.setResultMsg(inipay.getResult("ResultMsg"));
		payCancelResultData.setCancelDate(inipay.getResult("CancelDate"));
		payCancelResultData.setCancelTime(inipay.getResult("CancelTime"));
		payCancelResultData.setTid(payCancel.getTid());

		payCancelResultData.setAuthDate(payCancelResultData.getCancelDate() + payCancelResultData.getCancelTime());
		payCancelResultData.setCancelSuccess(payCancelResultData.getResultCode().equals("00") ? true : false);

		log.info("## 이니시스 결제 cancelProcessing 결과 :: Result : {}, Tid : {}, Msg : {}", payCancelResultData.isCancelSuccess(),payCancel.getTid(),payCancel.getMessage());

		// 모바일 결제의 경우, mobileTemp테이블의 PG상태값 및 PG메세지 Update
		orderTempRepository.updateOrderMobileTempCancel(payCancel.getTid(),payCancel.getMessage());
		return payCancelResultData;
	}
}
