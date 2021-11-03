<template>
  <div class="cart_complete info_product2">
    <h3 class="tit_orderit">{{ $t('item_list.title') }}</h3>
    <ul class="list_cart">
      <li v-for="item in chunkedOrderSubList"
          :key="item.orderSub.osPrCode">
        <span class="wrap_thumb">
          <img v-src="item.prImage1"
               :alt="item.prName"
               class="thumb_g">
        </span>

        <div class="desc_product">
          <strong class="tit_product">
            <em v-if="item.isEmsGiftProduct || item.isDomesticEvent"
                class="emph_gifts">[{{ $t('item_list.gifts') }}]
            </em>
            {{ item[$i18n.locale === 'kr' ? 'prName' : 'prName1'] }}
          </strong>

          <dl class="list_append">
            <template v-if="orderInfo.omPayType.code === '7'">
              <dt>{{ $t('item_list.price') }}</dt>
              <dd>{{ item.orderSub.exchangeSaleMoney * (item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa) | usd }} USD</dd>
            </template>
            <template v-else>
              <dt>{{ $t('item_list.price') }}</dt>
              <dd>{{ item.orderSub.osSaleMoney * (item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa) | krw }} {{ $t('common.krw') }}</dd>
            </template>

            <dt>{{ $t('item_list.option') }}</dt>
            <dd>
              <template v-if="!item.orderSub.osOptionName">-</template>{{ item.orderSub.osOptionName }}
            </dd>
          </dl>

          <dl class="list_append list_amount">
            <dt>{{ $t('item_list.quantity') }}</dt>
            <dd>{{ item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa }} {{ $i18n.locale === 'kr' ? '개' : '' }}</dd>
          </dl>
        </div>
      </li>
    </ul>

    <a v-if="isOverOrderSubList && !isMore"
       class="link_more"
       @click="handleMoreClick">
      <span class="txt_num">{{ orderSubList.length - chunked }}{{ $i18n.locale === 'kr' ? '개' : '' }}</span> {{ $t('item_list.more_items') }}
      <span class="ico_friends ico_arrow"></span>
    </a>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'complete-product',
  data() {
    return {
      slice: [0, 6],
      chunked: 6,
      isMore: false,
    }
  },
  methods: {
    handleMoreClick() {
      this.slice = [0, this.orderSubList.length]
      this.isMore = true
    },
  },
  computed: {
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
      orderSubList: state => state.orderShippingInfo.orderSubList,
      chunkedOrderSubList() {
        return this.orderSubList.slice(...this.slice)
      },
      isOverOrderSubList() {
        return this.orderSubList.length > this.chunked
      },
    }),
  },
}
</script>

<style scoped>
.link_more {
  cursor: pointer;
}
</style>