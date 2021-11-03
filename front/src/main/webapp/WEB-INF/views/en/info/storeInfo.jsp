<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    /* 임시 스크립트 */
    $(document).ready(function(){
        $(".link_tab").click(function(){
            var curLang = $(this).attr("lang"),
                onCls = "lang_on";

            $(".item_tab, .wrap_link, .cont_info .link_banner, .wrap_storeinfo").removeClass(onCls);
            $(".cont_info").attr("lang", curLang);
            $(".wrap_link:lang("+ curLang + "), .cont_info .link_banner:lang("+ curLang + "), .wrap_storeinfo:lang("+ curLang + ")").addClass(onCls);
            $(this).parent().addClass(onCls);

            return false;
        })
    })
</script>

<div id="mArticle">
    <!-- tab -->
    <div class="wrap_tab">
        <ul class="tab_lang">
            <li class="item_tab item_kr"><a href="#none" class="link_tab" lang="ko">한국어</a></li>
            <li class="item_tab item_en lang_on"><a href="#none" class="link_tab" lang="en">English</a></li>
            <li class="item_tab item_ja"><a href="#none" class="link_tab" lang="ja">日本語</a></li>
            <li class="item_tab item_hans"><a href="#none" class="link_tab" lang="zh-Hans">中文(简体)</a></li>
            <li class="item_tab item_hant"><a href="#none" class="link_tab" lang="zh-Hant">中文(繁體)</a></li>
        </ul>
    </div>
    <!-- // tab -->

    <!-- ko -->
    <div class="wrap_storeinfo" lang="ko">
        <h2 class="screen_out">매장안내</h2>
        <!-- 플래그쉽 -->
        <div class="inner_storeinfo">
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">강남 플래그십 스토어</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                        <dd>02-6494-1100</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                        <dd>매일 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                        <dd>서울 서초구 서초동 1305-7 유창빌딩 1~3층</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">홍대 플래그십 스토어</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                        <dd>02-6010-0104</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                        <dd>매일 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                        <dd>서울 마포구 양화로 162 (동교동, 동교동대아빌딩) 좋은사람들빌딩 1~3층</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">부산 플래그십 스토어</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                        <dd>051-256-0815</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                        <dd>매일 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                        <dd>부산 중구 광복로 62 (광복동2가)</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
        </div>
        <!-- //플래그쉽 -->

        <div class="group_tab">
            <ul class="tab_friends">
                <li class="on"><a href="#none" class="link_tab">전지역</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                <li><a href="#none" class="link_tab">서울</a></li>
                <li><a href="#none" class="link_tab">경기</a></li>
                <li><a href="#none" class="link_tab">인천</a></li>
                <li><a href="#none" class="link_tab">대구</a></li>
                <li><a href="#none" class="link_tab">부산</a></li>
            </ul>
            <div class="area_sort">
                <strong class="tit_sort">지역별 매장</strong>
                <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                    <strong class="screen_out">지역 선택</strong>
                    <a href="#none" class="link_selected">
                        <span class="txt_sort">전지역</span><!-- list_sort에서 선택한 텍스트를 넣어주세요 -->
                        <span class="screen_out">선택됨</span>
                        <span class="ico_friends ico_arr"></span>
                    </a>
                    <div class="box_sort">
                        <em class="screen_out">선택옵션</em>
                        <ul class="list_sort">
                            <li class="on"><a href="#none" class="link_sort">전지역</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                            <li><a href="#none" class="link_sort">서울</a></li>
                            <li><a href="#none" class="link_sort">경기</a></li>
                            <li><a href="#none" class="link_sort">인천</a></li>
                            <li><a href="#none" class="link_sort">대구</a></li>
                            <li><a href="#none" class="link_sort">부산</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 전체 지역 매장
        서울(data-area="seoul") : 002, 003, 006, 007, 009, 011, 012, 013, 014, 015, 017, 019, 021
        경기(data-area="gyeonggi") : 004, 010, 016
        인천(data-area="incheon") : 001
        대구(data-area="daegu") : 008, 020
        부산(data-area="busan") : 005, 018
        -->
        <div class="inner_storeinfo">
            <div class="group_storelist">
                <div class="section_store" data-area="incheon"><!-- 001 -->
                    <div class="area_img">
                        <img src="http://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">인천공항 T2 면세점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>032-743-4759</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 6:50 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>인천 중구 공항로 272 (운서동, 인천공항)  T2 3층 서편 248게이트 부근</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 002 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">롯데 영플라자 명동점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-2118-5150</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 11:30 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 중구 남대문로 67 (남대문로2가, 롯데영플라자) 1층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 003 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">타임스퀘어점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-2638-2750</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 영등포구 영중로 15 (영등포동4가, 타임스퀘어) 1층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 004 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">스타필드 고양점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>031-5173-1007</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:00 - 22:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>경기 고양시 덕양구 고양대로 1955 (동산동, 스타필드 고양) 1층 1113호</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 005 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">부산 플래그십 스토어</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>051-256-0815</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>부산 중구 광복로 62 (광복동2가)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 006 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">롯데월드타워 면세점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-3213-6743~4</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 9:30 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 송파구 올림픽로 300 (신천동) 월드타워점 8층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 007 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">DDP 동대문점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-2231-3552</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00 (매월 셋째주 월요일 휴무)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 중구 을지로 281 (을지로7가) DDP 지하2층 어울림광장 앞</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 008 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">신세계백화점 동대구점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>053-661-6942</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 11:00 - 21:30<br>(쇼핑몰 전체 정기휴무일 휴점)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>대구 동구 동부로 149 (신천동) 신세계백화점 8층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 009 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">홍대 플래그십 스토어</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-6010-0104</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 마포구 양화로 162 (동교동, 동교동대아빌딩) 좋은사람들빌딩 1~3층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 010 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">스타필드 하남점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>031-8072-8231</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>경기 하남시 미사대로 750 (신장동 스타필드 하남) 스타필드 하남 1층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 011 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">신라아이파크 면세 용산점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-490-3927</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 9:00 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 용산구 한강대로23길 55 (한강로3가, 용산민자역사) 아이파크몰 6층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 012 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">강남 플래그십 스토어</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-6494-1100</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 서초구 서초동 1305-7 유창빌딩 1~3층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 013 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">신세계면세 명동점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-6370-4278</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 9:00 -  20:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 중구 소공로 63 (충무로1가, 신세계백화점건물) 신세계면세점 11층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 014 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">롯데월드몰 잠실점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-3213-4514</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 송파구 올림픽로 300(신천동) 잠실 롯데월드몰 5층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 015 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">신세계백화점 강남점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-3479-1328</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 서초구 신반포로 176 (반포동, 센트럴시티빌딩) 신세계백화점 강남점 지하1층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 016 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">현대백화점 판교점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>031-5170-2451</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 20:00 <br>(쇼핑몰 전체 정기휴무일 휴점)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>경기 성남시 분당구 판교역로 146번길 8 (백현동) 현대백화점 판교점 유플렉스 4층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 017 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">CGV 여의도점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-6137-5550</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 영등포구 여의도동 23 IFC몰 지하3층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 018 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">롯데백화점 부산점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>051-810-4757</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 20:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>부산 부산진구 가야대로 772 (부전동) 롯데백화점 부산본점 7층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 019 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">스타필드 코엑스몰점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-6002-1880</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 강남구 영동대로 513 (삼성동, 코엑스) 코엑스몰. B1층 C108호</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 020 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">현대백화점 대구점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>053-245-3039</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 21:00 <br>(쇼핑몰 전체 정기휴무일 휴점)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>대구 중구 달구벌대로 2077 (계산동2가, 현대백화점) 유플렉스 지하2층 아트리움 광장</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 021 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">현대백화점 신촌점</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">전화번호 :</span></dt>
                            <dd>02-3145-1722</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">영업시간 :</span></dt>
                            <dd>매일 10:30 - 22:00 <br>(쇼핑몰 전체 정기휴무일 휴점)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">주소 :</span></dt>
                            <dd>서울 서대문구 신촌로 83 (창천동, 현대백화점신촌점) 본관 지하2층</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>지도 자세히보기</a>
                    </div>
                </div>
            </div>
            <!-- // 전체 지역 매장 -->
        </div>
        <!-- // ko -->
    </div>

    <!-- en -->
    <div class="wrap_storeinfo lang_on" lang="en">
        <h2 class="screen_out">Store Info</h2>
        <!-- 플래그쉽 -->
        <div class="inner_storeinfo">
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">Gangnam Flagship Store</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                        <dd>02-6494-1100</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                        <dd>Daily 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                        <dd>1-3rd Fl., Yuchang Bldg., 1305-7, Seocho-dong, Seocho-gu, Seoul</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">Hongdae Flagship Store</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                        <dd>02-6010-0104</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                        <dd>Daily 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                        <dd>1-3rd Fl., Joeun Saramdeul Bldg., 162, Yanghwa-ro, Mapo-gu, Seoul (Donggyo Daea Bldg., Donggyo-dong)
                        </dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">Busan Flagship Store</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                        <dd>051-256-0815</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                        <dd>Daily 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                        <dd>62, Gwangbok-ro, Jung-gu, Busan (Gwangbok-dong 2-ga)</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
        </div>
        <!-- //플래그쉽 -->

        <div class="group_tab">
            <ul class="tab_friends">
                <li class="on"><a href="#none" class="link_tab">All Regions</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                <li><a href="#none" class="link_tab">Seoul</a></li>
                <li><a href="#none" class="link_tab">Gyeonggi</a></li>
                <li><a href="#none" class="link_tab">Incheon</a></li>
                <li><a href="#none" class="link_tab">Daegu</a></li>
                <li><a href="#none" class="link_tab">Busan</a></li>
            </ul>
            <div class="area_sort">
                <strong class="tit_sort">Stores by Region</strong>
                <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                    <strong class="screen_out">select country</strong>
                    <a href="#none" class="link_selected">
                        <span class="txt_sort">All Regions</span><!-- list_sort에서 선택한 텍스트를 넣어주세요 -->
                        <span class="screen_out">selected</span>
                        <span class="ico_friends ico_arr"></span>
                    </a>
                    <div class="box_sort">
                        <em class="screen_out">select option</em>
                        <ul class="list_sort">
                            <li class="on"><a href="#none" class="link_sort">All Regions</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                            <li><a href="#none" class="link_sort">Seoul</a></li>
                            <li><a href="#none" class="link_sort">Gyeonggi</a></li>
                            <li><a href="#none" class="link_sort">Incheon</a></li>
                            <li><a href="#none" class="link_sort">Daegu</a></li>
                            <li><a href="#none" class="link_sort">Busan</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 전체 지역 매장
        서울(data-area="seoul") : 002, 003, 006, 007, 009, 011, 012, 013, 014, 015, 017, 019, 021
        경기(data-area="gyeonggi") : 004, 010, 016
        인천(data-area="incheon") : 001
        대구(data-area="daegu") : 008, 020
        부산(data-area="busan") : 005, 018
        -->
        <div class="inner_storeinfo">
            <div class="group_storelist">
                <div class="section_store" data-area="incheon"><!-- 001 -->
                    <div class="area_img">
                        <img src="http://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Incheon International Airport T2 Shinsegae Duty Free</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>Daily 6:50 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>032-743-4759</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>Near West Wing Gate 248, 3rd Fl., T2, 272, Gonghang-ro, Jung-gu, Incheon (Incheon International Airport, Unseo-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 002 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Myeongdong Lotte Young Plaza</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-2118-5150</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 11:30 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>1st Fl., 67, Namdaemun-ro, Jung-gu, Seoul (Lotte Young Plaza, Namdaemun-ro 2-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 003 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Times Square Yeongdeungpo </strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-2638-2750</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Every day 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>Kakao Friends, 1st Fl., 15, Yeongjung-ro, Yeongdeungpo-gu, Seoul (Times Square, Yeongdeungpo-dong 4(sa)-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 004 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield Goyang Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>031-5173-1007</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:00 - 22:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>#1113, 1st Fl., 1955, Goyang-daero, Deogyang-gu, Goyang-si, Gyeonggi-do (Starfield Goyang, Dongsan-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 005 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Busan Flagship Store</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>051-256-0815</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>62, Gwangbok-ro, Jung-gu, Busan (Gwangbok-dong 2-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 006 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Lotte World Tower Duty Free</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-3213-6743~4</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 9:30 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>8th Fl., Lotte World Tower, 300, Olympic-ro, Songpa-gu, Seoul (Sincheon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 007 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">DDP</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-2231-3552</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00<br>(Closed on third Monday of each month)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>In front of Eoullim Square, B2 Fl., DDP, 281, Eulji-ro, Jung-gu, Seoul (Euljiro 7-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 008 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Shinsegae Department Store Dongdaegu Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>053-661-6942</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 11:00 - 21:30<br>(Closed on regular mall holidays)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>Kakao Friends, 8th Fl., Shinsegae Department Store, 149, Dongbu-ro, Dong-gu, Daegu (Sincheon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 009 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Hongdae Flagship Store</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-6010-0104</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>1-3rd Fl., Joeun Saramdeul Bldg., 162, Yanghwa-ro, Mapo-gu, Seoul (Donggyo Daea Bldg., Donggyo-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 010 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield Hanam Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>031-8072-8231</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>1st Fl., Starfield Hanam, 750, Misa-daero, Hanam-si, Gyeonggi-do (Starfield Hanam, Sinjang-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 011 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Yongsan Shilla I'PARK Duty Free</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-490-3927</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 9:00 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>6th Fl., I'PARK Mall, 55, Hangang-daero 23-gil, Yongsan-gu, Seoul (Yongsan Station, Hangang-ro 3-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 012 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Gangnam Flagship Store</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-6494-1100</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>1-3rd Fl., Yuchang Bldg., 1305-7, Seocho-dong, Seocho-gu, Seoul</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 013 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Myeongdong Shinsegae Duty Free</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-6370-4278</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 9:00 -  20:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>11th Fl., Shinsegae Duty Free, 63, Sogong-ro, Jung-gu, Seoul (Shinsegae Department Store Bldg., Chungmuro 1-ga)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 014 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Jamsil Lotte World Mall</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-3213-4514</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>5th Fl., Jamsil Lotte World Mall, 300, Olympic-ro, Songpa-gu, Seoul (Sincheon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 015 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Shinsegae Department Store Gangnam Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-3479-1328</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>B1 Fl., Shinsegae Department Store Gangnam Branch, 176, Sinbanpo-ro, Seocho-gu, Seoul (Central City Bldg., Banpo-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 016 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Hyundai Department Store Pangyo Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>031-5170-2451</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 20:00<br>(Closed on regular mall holidays)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>4th Fl., Uplex, Hyundai Department Store Pangyo Branch, 8, Pangyoyeok-ro 146beon-gil, Bundang-gu, Seongnam-si, Gyeonggi-do (Baekhyeon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 017 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">CGV Yeouido Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-6137-5550</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>B3 Fl., IFC Mall, 23, Yeouido-dong, Yeongdeungpo-gu, Seoul</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 018 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Lotte Department Store Busan Main Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>051-810-4757</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 20:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>7th Fl., Lotte Department Store Busan Main Branch, 772, Gaya-daero, Busanjin-gu, Busan (Bujeon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 019 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">COEX Mall</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-6002-1880</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>#C108, B1 Fl., COEX Mall, 513, Yeongdong-daero, Gangnam-gu, Seoul (COEX, Samseong-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 020 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Hyundai Department Store Daegu Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>053-245-3039</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 21:00<br>(Closed on regular mall holidays)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>Atrium Square, B2 Fl., Uplex, 2077, Dalgubeol-daero, Jung-gu, Daegu (Hyundai Department Store, Gyesan-dong 2-ga)
                            </dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 021 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Hyundai Department Store Sinchon Branch</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">telephone number :</span></dt>
                            <dd>02-3145-1722</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">business hours :</span></dt>
                            <dd>Daily 10:30 - 22:00<br>(Closed on regular mall holidays)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">address :</span></dt>
                            <dd>B2 Fl., Main Bldg., 83, Sinchon-ro, Seodaemun-gu, Seoul (Hyundai Department Store Sinchon Branch, Changcheon-dong)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>View Map</a>
                    </div>
                </div>
            </div>
            <!-- // 전체 지역 매장 -->
        </div>
        <!-- // en -->
    </div>

    <!-- ja -->
    <div class="wrap_storeinfo " lang="ja">
        <h2 class="screen_out">ストア案内</h2>
        <!-- 플래그쉽 -->
        <div class="inner_storeinfo">
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">江南フラッグシップストア</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                        <dd>02-6494-1100</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                        <dd>毎日 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                        <dd>ソウル特別市 瑞草区 瑞草洞 1305-7 ユチャンビルディング 1～3階</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">弘大フラッグシップストア</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                        <dd>02-6010-0104</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                        <dd>毎日 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                        <dd>ソウル特別市 麻浦区 ヤンファロ 162 (東橋洞、東橋洞テアビルディング) チョウンサラムドゥルビルディング 1～3階</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">釜山フラッグシップストア</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                        <dd>051-256-0815</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                        <dd>毎日 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                        <dd>釜山広域市 中区 クァンボクロ 62 (光復洞2街)</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
        </div>
        <!-- //플래그쉽 -->

        <div class="group_tab">
            <ul class="tab_friends">
                <li class="on"><a href="#none" class="link_tab">全地域</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                <li><a href="#none" class="link_tab">ソウル</a></li>
                <li><a href="#none" class="link_tab">京畿</a></li>
                <li><a href="#none" class="link_tab">仁川</a></li>
                <li><a href="#none" class="link_tab">大邱</a></li>
                <li><a href="#none" class="link_tab">釜山</a></li>
            </ul>
            <div class="area_sort">
                <strong class="tit_sort">各地域のストア</strong>
                <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                    <strong class="screen_out">地域選択</strong>
                    <a href="#none" class="link_selected">
                        <span class="txt_sort">全地域</span><!-- list_sort에서 선택한 텍스트를 넣어주세요 -->
                        <span class="screen_out">選択された</span>
                        <span class="ico_friends ico_arr"></span>
                    </a>
                    <div class="box_sort">
                        <em class="screen_out">選択オプション</em>
                        <ul class="list_sort">
                            <li class="on"><a href="#none" class="link_sort">全地域</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                            <li><a href="#none" class="link_sort">ソウル</a></li>
                            <li><a href="#none" class="link_sort">京畿</a></li>
                            <li><a href="#none" class="link_sort">仁川</a></li>
                            <li><a href="#none" class="link_sort">大邱</a></li>
                            <li><a href="#none" class="link_sort">釜山</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 전체 지역 매장
        서울(data-area="seoul") : 002, 003, 006, 007, 009, 011, 012, 013, 014, 015, 017, 019, 021
        경기(data-area="gyeonggi") : 004, 010, 016
        인천(data-area="incheon") : 001
        대구(data-area="daegu") : 008, 020
        부산(data-area="busan") : 005, 018
        -->
        <div class="inner_storeinfo">
            <div class="group_storelist">
                <div class="section_store" data-area="incheon"><!-- 001 -->
                    <div class="area_img">
                        <img src="http://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">仁川国際空港 T2新世界免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>032-743-4759</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 6:50 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>仁川広域市 中区 コンハンロ 272 (雲西洞、仁川国際空港) T2 3階西側 248番ゲート付近</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 002 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞 ロッテヤングプラザ店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-2118-5150</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 11:30 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 中区 ナムデムンロ 67 (南大門路2街、ロッテヤングプラザ) 1階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 003 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">タイムズスクエア 永登浦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-2638-2750</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 永登浦区 ヨンジュンロ 15 (永登浦洞4街、タイムズスクエア) 1階 カカオフレンズ</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 004 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">スターフィールド 高陽店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>031-5173-1007</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:00 - 22:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>京畿道 高陽市 徳陽区 コヤンデロ 1955 (東山洞、スターフィールド高陽) 1階1113号</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 005 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">釜山フラッグシップストア</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>051-256-0815</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>釜山広域市 中区 クァンボクロ 62 (光復洞2街)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 006 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">ロッテワールドタワー免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-3213-6743~4</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 9:30 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 松坡区 オリンピックロ 300 (新川洞) ワールドタワー店 8階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 007 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">DDP店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-2231-3552</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00<br>(休業日：毎週第3月曜日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 中区 ウルチロ 281 (乙支路7街) DDP地下2階 オウルリム・スクエア前</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 008 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百貨店 東大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>053-661-6942</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 11:00 - 21:30<br>(休業日：ショッピングモールの定休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>大邱広域市 東区 トンブロ 149 (新川洞) 新世界百貨店 8階 カカオフレンズ</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 009 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">弘大フラッグシップストア</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-6010-0104</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 麻浦区 ヤンファロ 162 (東橋洞、東橋洞テアビルディング) チョウンサラムドゥルビルディング 1～3階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 010 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">スターフィールド 河南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>031-8072-8231</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>京畿道 河南市 ミサデロ 750 (新長洞、スターフィールド河南) スターフィールド河南 1階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 011 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">龍山 新羅アイパーク免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-490-3927</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 9:00 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 龍山区 ハンガンデロ23ギル 55 (漢江路3街、龍山民資駅舎) アイパークモール6階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 012 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">江南フラッグシップストア</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-6494-1100</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 瑞草区 瑞草洞 1305-7 ユチャンビルディング 1～3階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 013 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞 新世界免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-6370-4278</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 9:00 -  20:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 中区 ソゴンロ 63 (忠武路1街、新世界百貨店) 新世界免税店 11階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 014 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">蚕室 ロッテワールドモール店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-3213-4514</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 松坡区 オリンピックロ 300 (新川洞) 蚕室ロッテワールドモール 5階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 015 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百貨店 江南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-3479-1328</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 瑞草区 シンバンポロ 176 (盤浦洞、セントラルシティビルディング) 新世界百貨店・江南店 地下1階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 016 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨店 板橋店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>031-5170-2451</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 20:00<br>(休業日：ショッピングモールの定休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>京畿道 城南市 盆唐区 パンギョヨクロ 146ボンギル 8 (柏峴洞) 現代百貨店・板橋店 U-PLEX 4階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 017 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">CGV汝矣島店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-6137-5550</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 永登浦区 汝矣島洞 23 IFCモール 地下3階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 018 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">ロッテ百貨店 釜山本店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>051-810-4757</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 20:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>釜山広域市 釜山鎮区 カヤデロ 772 (釜田洞) ロッテ百貨店・釜山本店 7階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 019 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">COEXモール</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-6002-1880</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 江南区 ヨンドンデロ 513 (三成洞、COEX) COEXモール 地下1階 C108号</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 020 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨店 大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>053-245-3039</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 21:00<br>(休業日：ショッピングモールの定休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>大邱広域市 中区 タルグボルデロ 2077 (桂山洞2街、現代百貨店) U-PLEX 地下2階 アトリウム広場</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 021 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨店 新村店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話番号 :</span></dt>
                            <dd>02-3145-1722</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">営業時間 :</span></dt>
                            <dd>毎日 10:30 - 22:00<br>(休業日：ショッピングモールの定休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">住所 :</span></dt>
                            <dd>ソウル特別市 西大門区 シンチョンロ 83 (滄川洞、現代百貨店・新村店) 本館地下2階</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>マップで見る</a>
                    </div>
                </div>
            </div>
            <!-- // 전체 지역 매장 -->
        </div>
        <!-- // ja -->
    </div>

    <!-- zh-Hans -->
    <div class="wrap_storeinfo " lang="zh-Hans">
        <h2 class="screen_out">店铺信息</h2>
        <!-- 플래그쉽 -->
        <div class="inner_storeinfo">
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">江南旗舰店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                        <dd>02-6494-1100</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>首尔瑞草区瑞草洞1305-7 Yoo Chang大厦1-3楼</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">弘大旗舰店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                        <dd>02-6010-0104</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>首尔麻浦区杨花路162（东桥洞，东桥洞Dea大厦）好人们大厦1-3楼</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">釜山旗舰店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                        <dd>051-256-0815</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>釜山中区光复路62 （光复洞2街）</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
        </div>
        <!-- //플래그쉽 -->

        <div class="group_tab">
            <ul class="tab_friends">
                <li class="on"><a href="#none" class="link_tab">所有地区</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                <li><a href="#none" class="link_tab">首尔</a></li>
                <li><a href="#none" class="link_tab">京畿</a></li>
                <li><a href="#none" class="link_tab">仁川</a></li>
                <li><a href="#none" class="link_tab">大邱</a></li>
                <li><a href="#none" class="link_tab">釜山</a></li>
            </ul>
            <div class="area_sort">
                <strong class="tit_sort"> 各地区店铺</strong>
                <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                    <strong class="screen_out">选择区域</strong>
                    <a href="#none" class="link_selected">
                        <span class="txt_sort">所有地区</span><!-- list_sort에서 선택한 텍스트를 넣어주세요 -->
                        <span class="screen_out">所选择的</span>
                        <span class="ico_friends ico_arr"></span>
                    </a>
                    <div class="box_sort">
                        <em class="screen_out">选择选项</em>
                        <ul class="list_sort">
                            <li class="on"><a href="#none" class="link_sort">所有地区</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                            <li><a href="#none" class="link_sort">首尔</a></li>
                            <li><a href="#none" class="link_sort">京畿</a></li>
                            <li><a href="#none" class="link_sort">仁川</a></li>
                            <li><a href="#none" class="link_sort">大邱</a></li>
                            <li><a href="#none" class="link_sort">釜山</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 전체 지역 매장
        서울(data-area="seoul") : 002, 003, 006, 007, 009, 011, 012, 013, 014, 015, 017, 019, 021
        경기(data-area="gyeonggi") : 004, 010, 016
        인천(data-area="incheon") : 001
        대구(data-area="daegu") : 008, 020
        부산(data-area="busan") : 005, 018
        -->
        <div class="inner_storeinfo">
            <div class="group_storelist">
                <div class="section_store" data-area="incheon"><!-- 001 -->
                    <div class="area_img">
                        <img src="http://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">仁川机场T2新世界免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>032-743-4759</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 6:50 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>仁川中区机场路272（云西洞，仁川机场）T2 3楼西侧248号登机口附近</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 002 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞乐天Young Plaza店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-2118-5150</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 11:30 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔中区南大门路67（南大门路2街，乐天Young Plaza）1楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 003 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">时代广场永登浦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-2638-2750</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔永登浦区永中路15（永登浦洞4街，时代广场) 1楼 Kakao Friends</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 004 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield高阳店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>031-5173-1007</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:00 - 22:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿高阳市德阳区高阳大路1955（东山洞，Starfield高阳）1楼1113号</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 005 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">釜山旗舰店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>051-256-0815</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>釜山中区光复路62 （光复洞2街）</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 006 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">乐天世界塔免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-3213-6743~4</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 9:30 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔松坡区奥林匹克路300（新川洞）世界塔店8楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 007 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">DDP店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-2231-3552</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00<br>（每个月第三个周一休息）</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔中区乙支路281（乙支路7街）DDP地下2楼和谐广场前</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 008 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百货商店东大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>053-661-6942</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 11:00 - 21:30<br>(公休时间同百货商店定期休息日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>大邱东区东部路149（新川洞）新世界百货商店8楼 Kakao Friends</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 009 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">弘大旗舰店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-6010-0104</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔麻浦区杨花路162（东桥洞，东桥洞Dea大厦）好人们大厦1-3楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 010 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield河南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>031-8072-8231</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿河南市渼沙大陆750（新长洞，Starfield河南）Starfield河南1楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 011 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">龙山新罗爱宝客免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-490-3927</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 9:00 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔龙山区汉江大路23街55（汉江路3街，龙山民营车站）爱宝客购物中心6楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 012 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">江南旗舰店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-6494-1100</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔瑞草区瑞草洞1305-7 Yoo Chang大厦1-3楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 013 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞新世界免税店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-6370-4278</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 9:00 -  20:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔中区小公路63（忠武路1街，新世界百货商店内）新世界免税店11楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 014 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">蚕室乐天世界购物城店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-3213-4514</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔松坡区奥林匹克路300（新川洞）蚕室乐天世界购物中心5楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 015 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百货商店江南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-3479-1328</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔瑞草区新盘浦路176（盘浦洞，中央城大厦） 新世界百货商店江南店地下1楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 016 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">现代百货商店板桥店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>031-5170-2451</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 20:00<br>（公休时间同百货商店定期休息日）</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿城南市盆堂区板桥站路146号街8（柏岘洞） 现代百货商店板桥店U Plex 4楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 017 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">CGV汝矣岛店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-6137-5550</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔永登浦区汝矣岛洞23 IFC Mall 地下3楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 018 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">乐天百货商店釜山总店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>051-810-4757</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 20:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>釜山釜山镇区伽倻大路772（釜田洞）乐天百货商店釜山总店7楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 019 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">COEX Mall</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-6002-1880</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔江南区永东大路513（三成洞，COEX） COEX Mall B1 C108号</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 020 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">现代百货商店大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>053-245-3039</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 21:00<br>（公休时间同百货商店定期休息日）</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>大邱中区达句伐大路2077（鸡山洞2街，现代百货商店）U Plex地下2楼Atrium广场</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 021 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">现代百货商店新村店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">电话号码 :</span></dt>
                            <dd>02-3145-1722</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">营业时间 :</span></dt>
                            <dd>每天 10:30 - 22:00<br>（公休时间同百货商店定期休息日）</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首尔西大门区新村路83（沧川洞，现代百货商店新村店）本馆地下2楼</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
            </div>
            <!-- // 전체 지역 매장 -->
        </div>
        <!-- // zh-Hans -->
    </div>

    <!-- zh-Hant -->
    <div class="wrap_storeinfo " lang="zh-Hant">
        <h2 class="screen_out">店面資訊</h2>
        <!-- 플래그쉽 -->
        <div class="inner_storeinfo">
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_gangnam_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">江南旗艦店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                        <dd>02-6494-1100</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>首爾瑞草區瑞草洞1305-7 Yoo Chang大廈1～3樓</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_hongdae_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">弘大旗艦店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                        <dd>02-6010-0104</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>首爾麻浦區楊花路162(東橋洞，東橋洞Dea大廈) 好人們大廈1~3樓</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
            <div class="section_store">
                <div class="area_img">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_W.jpg" alt="" class="thumb_g rw_show">
                    <img src="https://t1.kakaocdn.net/friends/prod/info/bg_storeInfo_busan_M.jpg" alt="" class="thumb_g rw_hide">
                </div>
                <div class="area_cont">
                    <strong class="tit_store">釜山旗艦店</strong>
                    <dl class="store_info">
                        <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                        <dd>051-256-0815</dd>
                        <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                        <dd>每天 10:30 - 22:00</dd>
                        <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                        <dd>釜山中區光復路62 (光復洞2街)</dd>
                    </dl>
                    <a href="#none" class="link_map">
                        <div>지도영역</div>
                    </a>
                </div>
            </div>
        </div>
        <!-- //플래그쉽 -->

        <div class="group_tab">
            <ul class="tab_friends">
                <li class="on"><a href="#none" class="link_tab">所有地區</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                <li><a href="#none" class="link_tab">首爾</a></li>
                <li><a href="#none" class="link_tab">京畿</a></li>
                <li><a href="#none" class="link_tab">仁川</a></li>
                <li><a href="#none" class="link_tab">大邱</a></li>
                <li><a href="#none" class="link_tab">釜山</a></li>
            </ul>
            <div class="area_sort">
                <strong class="tit_sort"> 各地區賣場</strong>
                <div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
                    <strong class="screen_out">區域選擇</strong>
                    <a href="#none" class="link_selected">
                        <span class="txt_sort">所有地區</span><!-- list_sort에서 선택한 텍스트를 넣어주세요 -->
                        <span class="screen_out">所選擇的</span>
                        <span class="ico_friends ico_arr"></span>
                    </a>
                    <div class="box_sort">
                        <em class="screen_out">選擇選項</em>
                        <ul class="list_sort">
                            <li class="on"><a href="#none" class="link_sort">所有地區</a></li><!-- 선택 시 li에 on 클래스 추가 -->
                            <li><a href="#none" class="link_sort">首爾</a></li>
                            <li><a href="#none" class="link_sort">京畿</a></li>
                            <li><a href="#none" class="link_sort">仁川</a></li>
                            <li><a href="#none" class="link_sort">大邱</a></li>
                            <li><a href="#none" class="link_sort">釜山</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 전체 지역 매장
        서울(data-area="seoul") : 002, 003, 006, 007, 009, 011, 012, 013, 014, 015, 017, 019, 021
        경기(data-area="gyeonggi") : 004, 010, 016
        인천(data-area="incheon") : 001
        대구(data-area="daegu") : 008, 020
        부산(data-area="busan") : 005, 018
        -->
        <div class="inner_storeinfo">
            <div class="group_storelist">
                <div class="section_store" data-area="incheon"><!-- 001 -->
                    <div class="area_img">
                        <img src="http://t1.kakaocdn.net/friends/prod/info/W001_incheon_T2.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">仁川機場T2新世界免稅店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>032-743-4759</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 6:50 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>仁川中區機場路272(雲西洞，仁川機場)T2 3樓西側248號登機門附近</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 002 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W002_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞樂天Young Plaza店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-2118-5150</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 11:30 - 21:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾中區南大門路67(南大門路2街，樂天Young Plaza)1樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 003 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W003_Timesquare.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">時代廣場永登浦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-2638-2750</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>매일10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾永登浦區永中路15（永登浦洞4街，時代廣場) 1樓 Kakao Friends”</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 004 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W004_goyang.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield高陽店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>031-5173-1007</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:00 - 22:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿高陽市德陽區高陽大路1955(東山洞，Starfield高陽)1樓1113號</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 005 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W005_busan.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">釜山旗艦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>051-256-0815</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>釜山中區光復路62 (光復洞2街)</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 006 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W006_lotteworldtower.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">樂天世界塔免稅店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-3213-6743~4</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 9:30 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾松坡區奧林匹克路300(新川洞)世界塔店8樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 007 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W007_ddp.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">DDP店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-2231-3552</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00<br>(每個月第三個週一公休)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾中區乙支路281(乙支路7街)DDP地下2樓和諧廣場前</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 008 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W008_dongdaegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百貨公司東大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>053-661-6942</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 11:00 - 21:30<br>(公休時間同百貨公司定期公休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>大邱東區東部路149(新川洞)新世界百貨公司8樓Kakao Friends</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 009 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W009_hongdae.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">弘大旗艦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-6010-0104</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾麻浦區楊花路162(東橋洞，東橋洞Dea大廈) 好人們大廈1~3樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 010 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W010_hanam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">Starfield河南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>031-8072-8231</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿河南市渼沙大陸750(新長洞，Starfield河南)Starfield河南1樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 011 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W011_silla.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">龍山新羅I'PARK免稅店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-490-3927</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 9:00 - 21:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾龍山區漢江大路23街55(漢江路3街，龍山民營車站)I'PARK購物中心6樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 012 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W012_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">江南旗艦店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-6494-1100</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾瑞草區瑞草洞1305-7 Yoo Chang大廈1～3樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 013 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W013_ssg.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">明洞新世界免稅店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-6370-4278</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 9:00 -  20:30</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾中區小公路63(忠武路1街，新世界百貨公司內) 新世界免稅店11樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 014 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W014_lotte.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">蠶室樂天世界購物城店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-3213-4514</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾松坡區奧林匹克路300(新川洞)蠶室樂天世界購物城5樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 015 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W015_gangnam.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">新世界百貨公司江南店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-3479-1328</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾瑞草區新盤浦路176(盤浦洞，中央城大廈) 新世界百貨公司江南店地下1樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="gyeonggi"><!-- 016 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W016_pangyo.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨公司板橋店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>031-5170-2451</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 20:00<br>(公休時間同百貨公司定期公休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>京畿城南市盆堂區板橋站路146號街8(柏峴洞) 現代百貨公司板橋店U Plex 4樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 017 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W017_yeouido.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">CGV汝矣島店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-6137-5550</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:00 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾永登浦區汝矣島洞23 IFC Mall 地下3樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="busan"><!-- 018 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W018_busan_re.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">樂天百貨公司釜山總店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>051-810-4757</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 20:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>釜山釜山鎮區伽倻大路772(釜田洞)樂天百貨公司釜山總店7樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 019 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W019_coex_renewal.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">COEX Mall</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-6002-1880</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾江南區永東大路513(三成洞，COEX) COEX Mall B1 C108號</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="daegu"><!-- 020 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W020_daegu.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨公司大邱店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>053-245-3039</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 21:00<br>(公休時間同百貨公司定期公休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>大邱中區達句伐大路2077(雞山洞2街，現代百貨公司)U Plex地下2樓Atrium廣場</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
                <div class="section_store" data-area="seoul"><!-- 021 -->
                    <div class="area_img">
                        <img src="https://t1.kakaocdn.net/friends/prod/info/W021_sinchon.jpg" alt="" class="thumb_g">
                    </div>
                    <div class="area_cont">
                        <strong class="tit_store">現代百貨公司新村店</strong>
                        <dl class="store_info">
                            <dt><span class="ico_newfriends_v1 ico_tel">電話號碼 :</span></dt>
                            <dd>02-3145-1722</dd>
                            <dt><span class="ico_newfriends_v1 ico_time">營業時間 :</span></dt>
                            <dd>每天 10:30 - 22:00<br>(公休時間同百貨公司定期公休日)</dd>
                            <dt><span class="ico_newfriends_v1 ico_address">地址 :</span></dt>
                            <dd>首爾西大門區新村路83(滄川洞，現代百貨公司新村店)本館地下2樓</dd>
                        </dl>
                        <a href="#none" class="link_location"><span class="ico_newfriends_v1 ico_location"></span>查看位置</a>
                    </div>
                </div>
            </div>
            <!-- // 전체 지역 매장 -->
        </div>
        <!-- // zh-Hant -->
    </div>
</div>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=29599ee5293369c9514c9b0674da5840" />
<script>
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

    //    http://map.daum.net/link/map/18577297
    //    http://map.daum.net/link/map/37.402056,127.108212
</script>