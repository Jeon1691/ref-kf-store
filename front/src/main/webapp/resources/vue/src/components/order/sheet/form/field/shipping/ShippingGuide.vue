<template>
  <div class="guide_bubble">
    <span class="ico_newfriends_v1 ico_arrow"></span>
    <p v-if="!oaCountryName || oaCountryName === '한국'"
       class="desc_bubble"
       v-html="$t('shipping.guide.ko')"></p>
    <p v-if="oaCountryName && oaCountryName !== '한국'"
       class="desc_bubble"
       v-html="$t('shipping.guide.en')"></p>
  </div>
</template>

<script>
  import { mapState } from 'vuex'

  export default {
    name: 'shipping-guide',
    computed: {
      ...mapState(['oaCountryName'])
    }
  }
</script>
