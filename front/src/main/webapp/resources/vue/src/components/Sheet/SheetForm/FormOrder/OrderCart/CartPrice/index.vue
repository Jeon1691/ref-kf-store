<template>
  <div class="info_price">
    <dl class="list_price price_total">
      <dt>{{ $t('cart.total_items') }}</dt>
      <dd>
        <strong class="txt_price">
          <span class="usd_check usd_show">
            <span class="num_price">
              {{ basket.basketAccount | krw }} {{ $t('common.krw') }}
            </span>
          </span>
          <span class="usd_check">
            <span class="num_price">
              {{ basket.exchangeBasketAccount | usd }} USD
            </span>
          </span>
        </strong>
      </dd>
    </dl>
  </div>
</template>

<script>
export default {
  name: 'cart-price',
  props: {
    basket: {
      type: Object,
      required: true,
    },
  },
}
</script>
