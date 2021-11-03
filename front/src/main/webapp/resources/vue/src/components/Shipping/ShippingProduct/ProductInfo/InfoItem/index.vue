<template>
  <li>
    <span class="wrap_thumb">
      <img v-src="item.prImage1"
           :alt="item.prName"
           class="thumb_g">
    </span>

    <div class="desc_product">
      <strong class="tit_product">
        <em v-if="item.isEmsGiftProduct || item.isEventProduct"
            class="emph_gifts">[{{ $t('item_list.gifts') }}]
        </em>
        {{ $i18n.locale === 'kr' ? item.prName : item.prName1 }}
      </strong>

      <ul class="list_append">
        <li v-if="orderInfo.omPayType.code !== '7'">
          <em class="tit_append">{{ $t('item_list.price') }} :</em>
          {{ item.orderSub.osSaleMoney * (item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa) | krw }} {{ $t('common.krw') }}
        </li>
        <li v-else>
          <em class="tit_append">{{ $t('item_list.price') }} :</em>
          {{ item.orderSub.exchangeSaleMoney * (item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa) | usd }} USD
        </li>

        <li>
          <em class="tit_append">{{ $t('item_list.transit') }} :</em>{{ item.orderSub.osStatus[$i18n.locale === 'kr' ? 'name' : 'name_EN'] }}
        </li>

        <li>
          <em class="tit_append">{{ $t('item_list.option') }} :</em>
          <template v-if="!item.orderSub.osOptionName">-</template>
          {{ item.orderSub.osOptionName }}
        </li>

        <li>
          <em class="tit_append">{{ $t('item_list.quantity') }} :</em>{{ item.orderSub.osStatus.code === 300000 ? item.orderSub.osEa : item.orderSub.osOutEa }} {{ $i18n.locale === 'kr' ? '개' : '' }}
        </li>

        <li v-if="item.orderSub.osEtc7">
          <em class="tit_append">{{ $t('item_list.memo') }} :</em>{{ item.orderSub.osEtc7 }}
        </li>
      </ul>

      <template v-if="item.orderSub.osStatus.code === 7">
        <div v-if="globalOrder"
             class="product_btn">
          <a @click="globalShipSearchPopup(orderInfo.omNum)"
             class="link_g">{{ $t('item_list.tracking') }}</a>
        </div>
        <div v-else
             class="product_btn">
          <a @click="shippingInQueryNewWindowPopup(item.pccUrl, item.orderSub.osDeliNum)"
             class="link_g">{{ $t('item_list.tracking') }}</a>
        </div>
      </template>

      <div v-if="!globalOrder && item.orderSub.osStatus.code === 8"
           class="product_btn">
        <template v-if="orderInfo.omCouponMoney === 0 && orderInfo.omPointMoney === 0">
          <a @click="orderPurchaseFinalizedPopup('alert_purchasefinalized', orderInfo.omNum, item.orderSub.osSeq, `/${$LANG}/order/shipping/purchaseFinalized`)"
             class="link_g">{{ $t('item_list.confirm') }}</a>

          <template v-if="!(item.isCustomProduct || item.isEventProduct)">
            <a @click="orderExchangeReturnPopup('alert_returnapplication', orderInfo.omNum, item.orderSub.osSeq, `/${$LANG}/order/shipping/returnRequest`)"
               class="link_g">{{ $t('item_list.return') }}</a>
            <a @click="orderExchangeReturnPopup('alert_exchangeapplication', orderInfo.omNum, item.orderSub.osSeq, `/${$LANG}/order/shipping/exchangeRequest`)"
               class="link_g">{{ $t('item_list.exchange') }}</a>
          </template>
        </template>
        <template v-else>
          <a @click="orderPurchaseFinalizedPopup('alert_purchasefinalized', orderInfo.omNum, item.orderSub.osSeq, `/${$LANG}/order/shipping/purchaseFinalized`)"
             class="link_g">{{ $t('item_list.confirm') }}</a>

          <template v-if="!(item.isCustomProduct || item.isEventProduct)">
            <span class="link_g">{{ $t('item_list.return') }}</span>
            <a @click="orderExchangeReturnPopup('alert_exchangeapplication', orderInfo.omNum, item.orderSub.osSeq, `/${$LANG}/order/shipping/exchangeRequest`)"
               class="link_g">{{ $t('item_list.exchange') }}</a>
            <p class="note_info">
              <span class="ico_friends ico_bullet"></span>{{ $t('item_list.not_eligible') }}</p>
          </template>
        </template>
      </div>
    </div>
  </li>
</template>

<script>
import { mapState } from 'vuex'

const {
  globalShipSearchPopup,
  shippingInQueryNewWindowPopup,
  orderPurchaseFinalizedPopup,
  orderExchangeReturnPopup,
} = window

export default {
  name: 'info-item',
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  computed: {
    ...mapState({
      globalOrder: state => state.basket.globalOrder,
      orderInfo: state => state.orderShippingInfo.orderInfo,
    }),
  },
  methods: {
    globalShipSearchPopup(omNum) {
      globalShipSearchPopup(omNum)
    },
    shippingInQueryNewWindowPopup(pccUrl, osDeliNum) {
      shippingInQueryNewWindowPopup(pccUrl, osDeliNum)
    },
    orderPurchaseFinalizedPopup(alert, omNum, osSeq, url) {
      orderPurchaseFinalizedPopup(alert, omNum, osSeq, url)
    },
    orderExchangeReturnPopup(alert, omNum, osSeq, url) {
      orderExchangeReturnPopup(alert, omNum, osSeq, url)
    },
  },
}
</script>

<style scoped>
.link_g {
  cursor: pointer;
}
</style>