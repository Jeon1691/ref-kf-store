<template>
  <div class="wrap_tab">
    <ul class="tab_lang">
      <router-link v-for="item in nav"
                   :key="item.lang"
                   tag="li"
                   :to="item.lang"
                   :class="`item_tab item_${item.name}`">
        <a :lang="item.lang"
           class="link_tab">{{ item.text }}</a>
      </router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'info-tab',
  data() {
    return {
      nav: [
        { text: '한국어', lang: 'ko', name: 'kr' },
        { text: 'English', lang: 'en', name: 'en' },
        { text: '日本語', lang: 'ja', name: 'ja' },
        { text: '中文(简体)', lang: 'zh-Hans', name: 'hans' },
        { text: '中文(繁體)', lang: 'zh-Hant', name: 'hant' },
      ],
    }
  },
}
</script>
