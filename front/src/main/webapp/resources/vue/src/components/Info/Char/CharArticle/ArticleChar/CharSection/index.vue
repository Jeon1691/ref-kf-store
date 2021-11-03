<template>
  <div class="section_charinfo">
    <div class="inner_character">
      <div class="area_img">
        <span :class="`img_charInfo ico_${id}`"></span>
      </div>

      <div class="area_cont">
        <h3 :class="`tit_character img_charInfo tit_${id}`">{{ name }}</h3>
        <em class="desc_character"
            v-html="desc"></em>
        <p class="txt_character"
           v-html="longdesc"></p>
        <a class="link_view"
           :href="`${reqPath}/${lang}/products/groups/characters/${randomCategory}`">
          <span class="ico_newfriends_v1 ico_arrow"></span>{{ $t('chars.see_products') }}</a>
      </div>
    </div>
  </div>
</template>

<script>
import shuffle from 'lodash/shuffle'
const { REQ_PATH } = window

export default {
  name: 'char-section',
  props: ['id', 'name', 'desc', 'longdesc', 'group'],
  data() {
    return {
      reqPath: REQ_PATH,
    }
  },
  computed: {
    lang() {
      return this.$route.params.lang === 'ko' ? 'kr' : 'en'
    },
    randomCategory() {
      if (this.group === '5') {
        return shuffle([5, 11])[0]
      }

      if (this.group === '7') {
        return shuffle([7, 8])[0]
      }

      return this.group
    },
  },
}
</script>
