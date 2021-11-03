<template>
  <div id="kakaoWrap">
    <info-header info="char"></info-header>

    <hr class="hide">

    <div id="kakaoContent"
         class="cont_info"
         role="main">
      <div id="cMain">
        <char-visual></char-visual>
        <char-article></char-article>
      </div>
      <info-etc info="char"></info-etc>
    </div>

    <info-footer></info-footer>
  </div>
</template>

<script>
import InfoHeader from '@/components/Info/InfoHeader'
import InfoFooter from '@/components/Info/InfoFooter'
import InfoEtc from '@/components/Info//InfoEtc'
import CharVisual from './CharVisual'
import CharArticle from './CharArticle'

export default {
  name: 'Char',
  components: {
    InfoHeader,
    InfoFooter,
    CharVisual,
    CharArticle,
    InfoEtc,
  },
}
</script>