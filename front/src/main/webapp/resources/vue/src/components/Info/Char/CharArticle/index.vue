<template>
  <div id="mArticle">
    <info-tab></info-tab>
    <article-char></article-char>
  </div>
</template>

<script>
import InfoTab from '@/components/Info/InfoTab'
import ArticleChar from './ArticleChar'

export default {
  name: 'char-article',
  components: {
    InfoTab,
    ArticleChar,
  },
}
</script>
