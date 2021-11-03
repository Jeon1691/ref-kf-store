<template>
  <ul class="list_info_price">
    <li>
      <strong>{{ $t('cart.price_item') }}</strong>
      <p>
        <template v-if="$LANG === 'kr'">
          <span class="txt_number">{{ basket.basketAccount | krw }}</span> {{ $t('common.krw') }}
        </template>
        <template v-else>
          <span class="txt_number">{{ basket.exchangeBasketAccount | usd }}</span> USD
        </template>
      </p>
    </li>
    <li>
      <strong>{{ $t('cart.price_delivery') }}</strong>
      <p>
        <template v-if="$LANG === 'kr'">
          <template v-if="basket.deliveryCharge === 0">
            <span class="txt_free">무료</span>
          </template>
          <template v-else>
            <span class="txt_number">{{ basket.deliveryCharge | krw }}</span> {{ $t('common.krw') }}
          </template>
        </template>
        <template v-else>
          <span class="txt_number">{{ basket.exchangeDeliveryCharge | usd }}</span> USD
        </template>
      </p>
    </li>
    <li class="total_price">
      <strong>{{ $t('cart.price_total') }}</strong>
      <p>
        <template v-if="$LANG === 'kr'">
          <span class="txt_number">{{ payment.paymentAccount | krw }}</span> {{ $t('common.krw') }}
        </template>
        <template v-else>
          <span class="txt_number">{{ payment.exchangePaymentAccount | usd }}</span> USD
        </template>
      </p>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'cart-price',
  props: {
    basket: {
      type: Object,
      required: true,
    },
    payment: {
      type: Object,
      requred: true
    }
  },
}
</script>
