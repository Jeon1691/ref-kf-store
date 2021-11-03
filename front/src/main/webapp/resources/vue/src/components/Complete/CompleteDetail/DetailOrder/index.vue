<template>
  <div class="inbox_readonly inbox_orderit">
    <h3 class="tit_orderit">{{ $t('order_info.title') }}</h3>
    <dl class="list_orderit">
      <dt>{{ $t('order_info.order') }}</dt>
      <dd>
        <span class="inner_txt">{{ orderInfo.omNum }}</span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <dt>{{ $t('order_info.order_date_complete') }}</dt>
      <dd>
        <span class="inner_txt">
          {{ orderInfo.omInDate | date }}
        </span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <dt>{{ $t('order_info.item') }}</dt>
      <dd>
        <span class="inner_txt">
          {{ orderInfo[$LANG === 'kr' ? 'prName' : 'prName1'] }}
          <template v-if="orderInfo.orderSubPrTotCnt > 1">
            {{ $t('order_info.and_others', { product: orderInfo.orderSubPrTotCnt - 1 }) }}
          </template>
        </span>
      </dd>
    </dl>

    <dl class="list_orderit">
      <dt>{{ $t('order_info.total') }}</dt>
      <dd>
        <span v-if="orderInfo.omPayType.code === '7'"
              class="inner_txt">
          {{ orderInfo.exchangeItemsMoney + orderInfo.exchangeDeliveryMoney - orderInfo.exchangeCouponMoney | usd }} USD
        </span>
        <span v-else
              class="inner_txt">
          {{ orderInfo.totalMoney }} {{ $t('common.krw') }}
        </span>
      </dd>
    </dl>

    <template v-if="!isCustomProductFlag && !isEventProductFlag">
      <a v-if="!basket.isGlobalOrder && shippingStatusType.code === 4"
         @click="orderReturnAllPopup('alert_returnapplication_all', orderInfo.omNum, `/${$LANG}/order/shipping/returnRequestAll`)"
         class="link_edit">{{ $t('order_info.return_all') }}</a>
      <a v-if="shippingStatusType.code === 1"
         @click="orderCancelPopup('alert_ordercancel', orderInfo.omNum, `/${$LANG}/order/shipping/orderCancel`)"
         class="link_edit">{{ $t('order_info.cancel') }}</a>
    </template>
  </div>
</template>

<script>
import { mapState } from 'vuex'

const { orderReturnAllPopup, orderCancelPopup } = window

export default {
  name: 'detail-order',
  computed: {
    ...mapState(['isCustomProductFlag', 'isEventProductFlag', 'basket', 'shippingStatusType']),
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
    }),
  },
  methods: {
    orderReturnAllPopup(popupMessage, orderNumber, returnUrl) {
      orderReturnAllPopup(popupMessage, orderNumber, returnUrl)
    },
    orderCancelPopup(popupMessage, orderNumber, returnUrl) {
      orderCancelPopup(popupMessage, orderNumber, returnUrl)
    },
  },
}
</script>
