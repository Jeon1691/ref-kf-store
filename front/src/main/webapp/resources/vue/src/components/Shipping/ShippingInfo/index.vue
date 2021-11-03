<template>
  <div class="delivery_area">
    <h3 class="tit_sub">{{ $t('order_info.title') }}</h3>

    <dl class="list_order">
      <dt>{{ $t('order_info.order') }}</dt>
      <dd>
        <span class="txt_g">{{ orderInfo.omNum }}</span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('order_info.order_date') }}</dt>
      <dd>
        <span class="txt_g">
          {{ orderInfo.omInDate | date }}
        </span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('order_info.item') }}</dt>
      <dd>
        <span class="txt_g">{{ orderInfo[$i18n.locale === 'kr' ? 'prName' : 'prName1'] }}
          <template v-if="orderInfo.orderSubPrTotCnt > 1">
            {{ $t('order_info.and_others', { product: orderInfo.orderSubPrTotCnt }) }}
          </template>
        </span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('order_info.total') }}</dt>
      <dd v-if="orderInfo.omPayType.code === '7'">
        <span class="txt_g">{{ orderInfo.exchangeItemsMoney + exchangeDeliveryMoney - orderInfo.exchangeCouponMoney | usd }} USD</span>
      </dd>
      <dd v-else>
        <span class="txt_g">{{ orderInfo.totalMoney | krw }} {{ $t('common.krw') }}</span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('order_info.transit') }}</dt>
      <dd class="state_order">
        <span class="txt_g">{{ shippingStatusType[$i18n.locale === 'kr' ? 'name' : 'name_EN'] }}</span>
      </dd>
    </dl>

    <template v-if="!basket.isCustomProductFlag && !basket.isEventProductFlag">
      <a v-if="!basket.globalOrder && shippingStatusType.code === 4"
         @click="orderReturnAllPopup"
         class="link_g">{{ $t('order_info.return_all') }}</a>

      <a v-if="shippingStatusType.code === 1"
         @click="orderCancelPopup"
         class="link_g">{{ $t('order_info.cancel') }}</a>
    </template>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import methods from './methods'

export default {
  name: 'shipping-info',
  computed: {
    ...mapState(['basket', 'shippingStatusType', 'exchangeDeliveryMoney']),
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
    }),
  },
  methods,
}
</script>

<style scoped>
.link_g {
  cursor: pointer;
}
</style>
