<template>
  <div id="kakaoHead"
       :class="{head_info: true, head_type2: headtype === '2'}"
       role="banner">
    <div class="inner_head">
      <h1 class="tit_head">
        <a :href="`/${lang}/index`"
           id="kakaoServiceLogo"
           class="img_gnb link_friends">KAKAO FRIENDS</a>
      </h1>

      <div class="wrap_link lang_on"
           :lang="lang">
        <a :href="`/${lang}/info/charInfo#/${$route.params.lang}`"
           :class="{ link_info: true, link_on: isChar }">{{ $t('header.character') }}</a>
        <a :href="`/${lang}/info/storeInfo#/${$route.params.lang}`"
           :class="{ link_info: true, link_on: isStore }">{{ $t('header.store') }}</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'info-header',
  props: {
    info: {
      type: String,
      required: true,
    },
    headtype: {
      type: String,
    },
  },
  computed: {
    lang() {
      return this.$route.params.lang === 'ko' ? 'kr' : 'en'
    },
    isChar() {
      return this.info === 'char'
    },
    isStore() {
      return this.info === 'store'
    },
  },
}
</script>
