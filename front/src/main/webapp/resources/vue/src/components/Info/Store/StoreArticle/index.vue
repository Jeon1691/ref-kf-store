<template>
  <div id="mArticle">
    <info-tab></info-tab>

    <div class="wrap_storeinfo lang_on"
         :lang="$route.params.lang">
      <h2 class="screen_out">매장안내</h2>
      <article-flagship></article-flagship>

      <div class="group_tab">
        <stores-tab></stores-tab>
        <stores-select></stores-select>
      </div>

      <article-stores></article-stores>
    </div>
  </div>
</template>

<script>
import InfoTab from '@/components/Info/InfoTab'
import ArticleFlagship from './ArticleFlagship'
import ArticleStores from './ArticleStores'
import StoresTab from './ArticleStores/StoresTab'
import StoresSelect from './ArticleStores/StoresSelect'

export default {
  name: 'store-article',
  components: {
    InfoTab,
    ArticleFlagship,
    ArticleStores,
    StoresTab,
    StoresSelect,
  },
}
</script>
