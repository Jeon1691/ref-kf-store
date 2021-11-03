<template>
  <div>
    <dl class="list_order list_order2">
      <dt>{{ $t('payment_detail.payment_method') }}</dt>
      <dd>
        <span class="txt_g">{{ orderInfo.omPayType[$i18n.locale === 'kr' ? 'alias' : 'alias_EN'] }}</span>
      </dd>
    </dl>

    <dl class="list_order">
      <dt>{{ $t('payment_detail.order_date') }}</dt>
      <dd>
        <span class="txt_g">
          {{ orderInfo.omInDate | datetime }}
        </span>
      </dd>
    </dl>

    <template v-if="orderInfo.omPayType.code === '7'">
      <dl class="list_order">
        <dt>{{ $t('payment_detail.items') }}</dt>
        <dd>
          <span class="txt_g">
            {{ orderInfo.exchangeItemsMoney | usd }} USD
          </span>
        </dd>
      </dl>

      <dl class="list_order">
        <dt v-if="globalOrder">{{ $t('payment_detail.shipping_to_global') }}</dt>
        <dt v-else>{{ $t('payment_detail.shipping_to') }}</dt>
        <dd>
          <span class="txt_g">
            {{ exchangeDeliveryMoney | usd }} USD
          </span>
        </dd>
      </dl>

      <dl v-if="orderInfo.omCouponMoney > 0"
          class="list_order">
        <dt>{{ $t('payment_detail.coupon') }}</dt>
        <dd>
          <span class="txt_g">- {{ orderInfo.exchangeCouponMoney | usd }} USD</span>
        </dd>
      </dl>

      <dl v-if="orderInfo.omPointMoney > 0"
          class="list_order">
        <dt>{{ $t('payment_detail.point') }}</dt>
        <dd>
          <span class="txt_g">- {{ orderInfo.exchangePointMoney | usd }} USD</span>
        </dd>
      </dl>

      <dl class="list_order">
        <dt>{{ $t('payment_detail.total') }}</dt>
        <dd>
          <span class="txt_g">
            <strong>
              {{ orderInfo.exchangeItemsMoney + exchangeDeliveryMoney - orderInfo.exchangeCouponMoney | usd }} USD
            </strong>
          </span>
        </dd>
      </dl>
    </template>
    <template v-else>
      <dl class="list_order">
        <dt>{{ $t('payment_detail.items') }}</dt>
        <dd>
          <span class="txt_g">
            {{ orderInfo.totalMoney + orderInfo.omCouponMoney + orderInfo.omPointMoney - orderInfo.omDeliveryMoney | krw }} {{ $t('common.krw') }}
          </span>
        </dd>
      </dl>

      <dl class="list_order">
        <dt v-if="globalOrder">{{ $t('payment_detail.shipping_to_global') }}</dt>
        <dt v-else>{{ $t('payment_detail.shipping_to') }}</dt>
        <dd>
          <span class="txt_g">
            {{ orderInfo.omDeliveryMoney | krw }} {{ $t('common.krw') }}</span>
        </dd>
      </dl>

      <dl v-if="orderInfo.omCouponMoney > 0"
          class="list_order">
        <dt>{{ $t('payment_detail.coupon') }}</dt>
        <dd>
          <span class="txt_g">- {{ orderInfo.omCouponMoney | krw }} {{ $t('common.krw') }}</span>
        </dd>
      </dl>

      <dl v-if="orderInfo.omPointMoney > 0"
          class="list_order">
        <dt>{{ $t('payment_detail.point') }}</dt>
        <dd>
          <span class="txt_g">- {{ orderInfo.omPointMoney | krw }} {{ $t('common.krw') }}</span>
        </dd>
      </dl>

      <dl class="list_order">
        <dt>{{ $t('payment_detail.total') }}</dt>
        <dd>
          <span class="txt_g">
            <strong>
              {{ orderInfo.totalMoney | krw }} {{ $t('common.krw') }}</strong>
          </span>
        </dd>
      </dl>
    </template>

    <dl v-if="orderAddDeli && (orderAddDeli.odOdPgTid || orderAddDeli.odEtc2)"
        class="list_order">
      <dt>{{ $t('payment_detail.recovery_cost') }}</dt>
      <dd v-if="!orderAddDeli.odEtc2">
        <span class="txt_g">
          <strong>
            {{ orderAddDeli.odReqMoney | krw }} {{ $t('common.krw') }} ({{ orderAddDeli.odPayType[$i18n.locale === 'kr' ? 'alias' : 'alias_EN'] }})</strong>
        </span>
      </dd>
      <dd v-else>
        <span class="txt_g">
          <strong>
            {{ orderAddDeli.odEtc2 }} {{ $t('common.krw') }} ( {{ orderAddDeli.odReqPayType[$i18n.locale === 'kr' ? 'alias' : 'alias_EN'] }}
            <template v-if="orderAddDeli.odEtc1"> 외 {{ orderAddDeli.odEtc1 }}건</template> )</strong>
        </span>
      </dd>
    </dl>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'payment-summary',
  computed: {
    ...mapState(['orderAddDeli', 'exchangeDeliveryMoney']),
    ...mapState({
      globalOrder: state => state.basket.globalOrder,
      orderInfo: state => state.orderShippingInfo.orderInfo,
    }),
  },
}
</script>
