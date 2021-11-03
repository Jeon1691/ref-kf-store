<template>
  <div id="cEtc">
    <a v-if="info === 'char'"
       :href="`/${urlLang}/info/storeInfo#${$route.params.lang}`"
       class="link_banner lang_on"
       :lang="$route.params.lang">
      <img :src="`https://t1.kakaocdn.net/friends/prod/info/banner_storeInfo_${imageLang}_W.png`"
           :alt="$t('etc.char')"
           class="thumb_g rw_show">
      <img :src="`https://t1.kakaocdn.net/friends/prod/info/banner_storeInfo_${imageLang}_M.png`"
           :alt="$t('etc.char')"
           class="thumb_g rw_hide">
    </a>
    <a v-else
       :href="`/${urlLang}/info/charInfo#${$route.params.lang}`"
       class="link_banner lang_on"
       :lang="$route.params.lang">
      <img :src="`https://t1.kakaocdn.net/friends/prod/info/banner_charInfo_${imageLang}_W.png`"
           :alt="$t('etc.store')"
           class="thumb_g rw_show">
      <img :src="`https://t1.kakaocdn.net/friends/prod/info/banner_charInfo_${imageLang}_M.png`"
           :alt="$t('etc.store')"
           class="thumb_g rw_hide">
    </a>
  </div>
</template>

<script>
export default {
  name: 'info-etc',
  props: {
    info: {
      type: String,
      required: true,
    },
  },
  computed: {
    urlLang() {
      return this.$route.params.lang === 'ko' ? 'kr' : 'en'
    },
    imageLang() {
      switch (this.$route.params.lang) {
        case 'ko':
          return 'kr'
        case 'en':
          return 'en'
        case 'ja':
          return 'ja'
        case 'zh-Hans':
          return 'sc'
        case 'zh-Hant':
          return 'tc'
        default:
          return 'kr'
      }
    },
  },
}
</script>