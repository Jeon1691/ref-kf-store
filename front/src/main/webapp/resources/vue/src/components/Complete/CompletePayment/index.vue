<template>
  <div class="order_detail order_payment">
    <h3 class="tit_orderit">{{ $t('payment_detail.title') }}</h3>

    <div class="info_price info_price2">
      <dl class="list_price">
        <dt>{{ $t('payment_detail.payment_method') }}</dt>
        <dd>
          <strong class="txt_price">{{ orderInfo.omPayType[$i18n.locale === 'kr' ? 'alias' : 'alias_EN' ] }}</strong>
        </dd>
      </dl>

      <dl class="list_price">
        <dt>{{ $t('payment_detail.order_date') }}</dt>
        <dd>
          <strong class="txt_price">
            {{ orderInfo.omInDate | datetime }}
          </strong>
        </dd>
      </dl>
    </div>

    <div class="info_price">
      <dl class="list_price">
        <dt>{{ $t('payment_detail.items') }}</dt>
        <dd>
          <strong class="txt_price">
            <span class="num_price">
              {{ orderInfo.totalMoney + orderInfo.omCouponMoney + orderInfo.omPointMoney - orderInfo.omDeliveryMoney | krw }}
            </span>{{ $t('common.krw') }}</strong>
          <span class="txt_usd">
            <template v-if="orderInfo.omPayType.code === '7'">
              {{ orderInfo.exchangeItemsMoney | usd }}
            </template>
            <template v-else>
              {{ orderInfo.exchangeItemsMoney | exchange | usd }}
            </template>
            USD
          </span>
        </dd>
      </dl>

      <dl class="list_price">
        <dt>{{ $t('payment_detail.discounted_price') }}</dt>
        <dd>
          <strong class="txt_price">
            <span class="num_price">
              {{ orderInfo.omCouponMoney + orderInfo.omPointMoney === 0 ? '' : '-' }} {{ orderInfo.omCouponMoney + orderInfo.omPointMoney | krw }}
            </span>{{ $t('common.krw') }}
          </strong>
          <span class="txt_usd">
            {{ exchangeDiscountMoney === 0 ? '' : '-' }} {{ exchangeDiscountMoney | usd }} USD</span>
        </dd>
      </dl>

      <dl class="list_price">
        <dt>{{ globalOrder ? $t('payment_detail.shipping_to_global') : $t('payment_detail.shipping_to') }}</dt>
        <dd>
          <strong class="txt_price">
            <span class="num_price">
              {{ orderInfo.omDeliveryMoney | krw }}
            </span>{{ $t('common.krw') }}
          </strong>
          <span class="txt_usd">
            {{ exchangeDeliveryMoney | usd }} USD
          </span>
        </dd>
      </dl>

      <dl class="list_price price_total">
        <dt>{{ $t('payment_detail.total') }}</dt>
        <dd>
          <strong class="txt_price">
            <span class="num_price">
              {{ orderInfo.totalMoney | krw }}
            </span>{{ $t('common.krw') }}
          </strong>
          <span class="txt_usd">
            {{ exchangeTotalMoney | usd }} USD
          </span>
        </dd>
      </dl>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'complete-payment',
  computed: {
    ...mapState([
      'exchangeProdAmountCharge',
      'exchangeDiscountMoney',
      'exchangeDeliveryMoney',
      'exchangeTotalMoney',
    ]),
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
      globalOrder: state => state.basket.globalOrder,
    }),
  },
}
</script>
