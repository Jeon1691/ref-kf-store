<template>
  <div class="info_product info_product2">
    <h3 class="tit_sub">{{ $t('item_list.title') }}</h3>

    <ul class="list_item fst list_focus">
      <info-item v-for="(item, index) in orderSubList.slice(0, 5)"
                 :key="`${item.orderSub.osPrCode}-${index}`"
                 :item="item"></info-item>
    </ul>

    <ul class="list_item"
        :class="{ list_hidden: !isShowRest, list_focus: isShowRest }">
      <info-item v-for="(item, index) in orderSubList.slice(5)"
                 :key="`${item.orderSub.osPrCode}-${index}`"
                 :item="item"></info-item>
    </ul>

    <a v-if="orderSubList.length > 5 && !isShowRest"
       class="link_more"
       @click="isShowRest = true">
      <span class="txt_num">{{ orderSubList.length - orderSubListViewSize }}{{ $i18n.locale === 'kr' ? '개' : '' }}</span> {{ $t('item_list.more_items') }}
      <span class="ico_friends ico_arrow"></span>
    </a>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import InfoItem from './InfoItem'

export default {
  name: 'product-info',
  data() {
    return {
      isShowRest: false,
      orderSubListViewSize: 5,
    }
  },
  components: {
    InfoItem,
  },
  computed: {
    ...mapState(['basket']),
    ...mapState({
      orderSubList: state => state.orderShippingInfo.orderSubList,
    }),
  },
}
</script>

<style scoped>
.link_more {
  cursor: pointer;
}
</style>