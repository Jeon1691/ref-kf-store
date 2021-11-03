<template>
  <div id="kakaoWrap">
    <info-header info="store"
                 headtype="2"></info-header>

    <hr class="hide">

    <div id="kakaoContent"
         class="cont_info"
         role="main">
      <div id="cMain">
        <store-visual></store-visual>
        <store-article></store-article>
      </div>
      <info-etc info="store"></info-etc>
    </div>

    <info-footer></info-footer>
  </div>
</template>

<script>
import InfoHeader from '@/components/Info/InfoHeader'
import InfoEtc from '@/components/Info/InfoEtc'
import InfoFooter from '@/components/Info/InfoFooter'
import StoreVisual from './StoreVisual'
import StoreArticle from './StoreArticle'

export default {
  name: 'info-store',
  components: {
    InfoHeader,
    InfoFooter,
    InfoEtc,
    StoreVisual,
    StoreArticle,
  },
}
</script>