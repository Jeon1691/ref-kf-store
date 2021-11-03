<template>
  <div id="kakaoFoot" role="contentinfo">
    <div class="inner_footer">
      <h2 class="screen_out">서비스 이용정보</h2>
      <div class="info_service">
        <a href="/kr/policy/privacy" class="link_service">개인정보처리방침</a>
        <a href="/kr/policy/provision" class="link_service link_service2">이용약관</a>
        <!--<a href="/kr/global/globalInfo" class="link_service link_service2">글로벌 배송 안내</a>-->
      </div>
      <!--<strong class="ico_newfriends_v1 tit_logo">KAKAO FRIENDS</strong>-->
      <small class="info_copy">
        <span class="txt_copy">카카오아이엑스 사업자등록번호 : 354-86-00070</span>
        <span class="txt_copy">통신판매업 신고번호 : 2017-서울강남-02573</span>
        <span class="txt_copy">대표이사 : 권승조</span>
        <span class="txt_copy">주소 : 서울특별시 강남구 테헤란로 521 파르나스타워, 27층</span>
        <span class="txt_copy">고객센터 : 1577-6263 / 평일 10시 ~ 18시</span>
        <span class="txt_copy">
          <a href="mailto:store@kakaofriends.com" class="link_mailto">store@kakaofriends.com</a>
        </span>
        <span class="txt_copy">글로벌 배송 문의 : <a href="mailto:global@kakaofriends.com" class="link_mailto">global@kakaofriends.com</a></span>
        <span class="txt_corp">Copyright &copy; <a href="#none" class="link_copyright">KAKAO IX CORP.</a></span>
      </small>
    </div>
  </div>	<!-- // kakaoFoot -->
</template>

<script>
export default {
  name: 'info-footer',
  computed: {
    lang() {
      return this.$route.params.lang === 'ko' ? 'kr' : 'en'
    },
  },
}
</script>
