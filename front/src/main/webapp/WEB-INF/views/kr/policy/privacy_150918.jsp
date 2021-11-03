<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="mArticle">
    <div class="info_privacy"><strong class="screen_out">개인정보보호 서비스 안내</strong>
        <ul class="tab_friends">
            <li class="on"><a class="link_tab" href="/kr/policy/privacy">개인정보취급방침</a></li>
            <li><a class="link_tab" href="/kr/policy/provision">이용약관</a></li>
        </ul>
        <h3 class="screen_out">개인정보취급방침</h3><strong
                class="tit_privacy">개인정보취급방침이란?</strong>
        <p class="txt_privacy">카카오프렌즈 주식회사 (이하 "회사")는 이용자의 동의를 기반으로 개인정보를 수집·이용 및 제공하고
            있으며, 이용자의 권리 (개인정보자기결정권)를 적극적으로 보장합니다. 회사는 정보통신서비스제공자가 준수하여야 하는 대한민국의 관계 법령 및
            개인정보보호 규정, 가이드라인을 준수하고 있습니다.<br>"개인정보취급방침”이란 이용자의 소중한 개인정보를 보호하여 안심하고 서비스를 이용할 수
            있도록 회사가 서비스를 운영함에 있어 준수해야 할 지침을 말합니다.</p><strong class="tit_privacy">개인정보의
            수집</strong>
        <p class="txt_privacy">이용자로부터 다음과 같은 개인정보를 수집하고 있습니다. 모든 이용자는 회사가 제공하는 서비스를 이용할
            수 있고, 카카오 계정 연동을 통해 더욱 다양한 서비스를 제공받을 수 있습니다. 이용자의 개인정보를 수집하는 경우에는 반드시 사전에 이용자에게
            해당 사실을 알리고 동의를 구하도록 하겠습니다.<br>수집 방법에는 서비스 이용, 이벤트 응모, 고객센터, 팩스, 전화 등 이 있으며, 아래의
            원칙을 준수하고 있습니다.</p>
        <ul class="list_agree list_privacy">
            <li>1. 서비스 제공에 필요한 최소한의 개인정보를 수집하고 있습니다.<br>필수정보란? : 해당 서비스의 본질적 기능을 수행하기 위한
                정보<br> 선택정보란? : 보다 특화된 서비스를 제공하기 위해 추가 수집하는 정보 (선택 정보를 입력하지 않은 경우에도 서비스 이용
                제한은 없습니다.)
            </li>
            <li>2. 민감정보를 수집하지 않습니다.<br>민감정보란? : 이용자의 소중한 인권을 침해할 우려가 있는 정보 (인종, 사상 및 신조,
                정치적 성향이나 범죄기록, 의료정보 등)<br>단, 법령에서 민감 정보의 처리를 요구하거나 허용하는 경우에는 반드시 사전에 이용자에게 해당
                사실을 알리고 동의를 구하도록 하겠습니다.
            </li>
            <li>카카오계정 연동 시 아래와 같은 개인정보가 수집 됩니다.<br> (필수) 프로필 이름, 프로필 이미지</li>
            <li> 상품 주문/배송 또는 교환신청 시 아래와 같은 개인정보가 수집됩니다.<br> (필수) 이름, 휴대폰번호, 주소, 이메일주소
            </li>
            <li> 또한, 서비스 이용과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.<br>- IP Address, 쿠키,
                방문 일시, 서비스 이용 기록, 불량 이용 기록
            </li>
        </ul>
        <strong class="tit_privacy">개인정보의
            이용</strong>
        <p class="txt_privacy">어떠한 목적으로 개인정보를 이용할까요?<br>이용자의 개인정보를 다음과 같은 목적으로만 이용하며,
            목적이 변경될 경우에는 반드시 사전에 이용자에게 동의를 구하도록 하겠습니다. 이용자 식별, 불량회원 부정한 이용 방지 다양한 서비스 제공,
            문의사항 또는 불만 처리 이용자와 약속한 서비스 제공, 유료서비스 구매 및 이용 시 요금 정산 서비스 이용 기록과 접속 빈도 분석, 서비스
            이용에 대한 통계, 맞춤형 서비스 제공, 서비스 개선에 활용</p>
        <p class="txt_privacy">얼마 동안 개인정보를 이용할까요?<br>이용자의 개인정보를&nbsp; 수집 및 이용 목적, 이용
            기간에만 제한적으로 이용하고 있으며, 탈퇴를 요청하거나 동의를 철회하는 경우 지체 없이 파기합니다. 다만, 서비스의 부정한 이용으로 인한 분쟁을
            방지하기 위한 내부 방침에 따라 서비스의 부정이용기록은 1년간 보존한 다음 안전한 방법으로 파기됩니다. 다만, 관계법령에 의해 보관해야 하는
            정보는 법령이 정한 기간동안 보관합니다.</p>
        <ul class="list_agree list_privacy">
            <li>1. 서비스 이용 관련 개인정보(사이트 방문기록)<br>- 보존 근거 : 통신비밀보호법<br>- 보존 기간 : 3개월</li>
            <li>2. 계약 또는 청약철회 등에 관한 기록<br>- 보존 근거 : 전자상거래 등에서의 소비자보호에 관한 법률<br>- 보존 기간 :
                5년
            </li>
            <li>3. 대금결제 및 재화 등의 공급에 관한 기록<br>- 보존 근거 : 전자상거래 등에서의 소비자보호에 관한 법률<br>- 보존 기간
                : 5년
            </li>
            <li>4. 소비자의 불만 또는 분쟁처리에 관한 기록<br>- 보존 근거 : 전자상거래 등에서의 소비자보호에 관한 법률<br>- 보존 기간
                : 3년
            </li>
        </ul>
        <strong class="tit_privacy">개인정보의 제공</strong>
        <p class="txt_privacy">이용자와 약속한 서비스를 제공하기 위해 다음과 같은 업무를 위탁하고 있습니다. 이용자에게 다양한
            서비스를 제공하는 데에 반드시 필요한 업무 중 일부를 외부업체로 하여금 수행하도록 개인 정보를 위탁하고 있습니다.</p>
        <div class="desc_privacy">
            <div class="privacy_table" style="width:590px">
                <table class="tbl_privacy">
                    <caption class="screen_out">위탁업무 내용 안내표</caption>
                    <colgroup>
                        <col style="width: 34%;">
                        <col style="width: 66%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">수탁업체</th>
                        <th scope="col">위탁업무 내용</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>케이지이니시스㈜</td>
                        <td>결제처리 (휴대폰, 계좌이체, 신용카드 및 기타 결제수단, 환불계좌 인증)</td>
                    </tr>
                    <tr>
                        <td>㈜디케이테크인</td>
                        <td>인프라 관리, 서비스 개발 및 테스트</td>
                    </tr>
                    <tr>
                        <td>카카오</td>
                        <td>인프라 관리, 서비스 개발 및 테스트</td>
                    </tr>
                    <tr>
                        <td>케이지로직스㈜</td>
                        <td>구매상품 및 이벤트 경품 배송</td>
                    </tr>
                    <tr class="lst">
                        <td>TCK</td>
                        <td>고객상담, 서비스 운영</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="privacy_table2" style="width:409px">
                <table class="tbl_privacy">
                    <caption class="screen_out">개인정보의 보유 및 이용기간 안내표</caption>
                    <colgroup>
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">개인정보의 보유 및 이용기간</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="lst">
                        <td style="height:354px;text-align:center">회원탈퇴시 혹은 위탁계약 종료시까지</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <p class="txt_privacy">다만 해당 정보는 이용자가 확인한 시점을 기준으로 한 정보이며, 위탁 업체 또는 위탁 업무가 변경되는
            경우 반드시 해당 사실을 알려드리겠습니다.그리고 회사는 위탁받은 업체가 개인정보보호 관련 법령을 위반하지 않도록 관리·감독하고 있습니다</p>
        <p class="txt_privacy">이용자에게 법령에 따른 동의를 받은 경우에만 개인정보를 제3자에게 제공하고 있습니다. 회사는 이용자의
            개인정보를 제3자에게 제공하지 하지 않으며, 개인정보를 제3자에게 제공해야 하는 경우 반드시 사전에 이용자에게 해당 사실을 알리고 동의를
            구하도록 하겠습니다.</p>
        <p class="txt_privacy">다만 다음의 경우는 예외로 하고 있습니다.</p>
        <ul class="list_agree">
            <li>1. 서비스 제공에 따른 요금정산을 위해 필요한 경우</li>
            <li>2. 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는
                경우
            </li>
        </ul>

        <div class="area_link">
            <a href="/kr/policy/privacy" class="link_privacy link_privacy_current">현재 개인정보처리방침 보기</a>
        </div>
    </div>
</div>
<!--// mArticle -->