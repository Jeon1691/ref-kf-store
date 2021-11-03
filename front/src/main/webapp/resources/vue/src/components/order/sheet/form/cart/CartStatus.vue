<template>
  <div class="desc_cart">
    <strong class="tit_product">{{ order.product[$i18n.locale === 'kr' ? 'prName' : 'prName1'] }}</strong>
    <dl class="list_append">
      <dt>{{ $t('cart.price') }}</dt>
      <dd class="usd_check usd_show">
        <template v-if="!order.isDiscountPeriod">
          {{ order.productLevelPrice.prlpSaleprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
        </template>
        <template v-else>
          {{ order.productLevelPrice.prlpDiscountprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
          <br>
          <span class="prev_price">
            {{ order.productLevelPrice.prlpSaleprice1 * order.bsEa | krw }} {{ $t('common.krw') }}
          </span>
        </template>
      </dd>
      <dd class="usd_check">
        <template v-if="!order.isDiscountPeriod">
          {{ order.productLevelPrice.exchangePrice * order.bsEa | usd }} USD
        </template>
        <template v-else>
          {{ order.productLevelPrice.exchangeDiscountPrice * order.bsEa | usd }} USD
          <br>
          <span class="prev_price">
            {{ order.productLevelPrice.exchangePrice * order.bsEa | usd }} USD
          </span>
        </template>
      </dd>
      <dt>{{ $t('cart.option') }}</dt>
      <dd>-</dd>
    </dl>

    <dl class="list_append list_amount">
      <dt>{{ $t('cart.quantity') }}</dt>
      <dd>{{ order.bsEa }} {{ $i18n.locale === 'kr' ? $t('cart.ea') : '' }}</dd>
    </dl>
  </div>
</template>

<script>
  import { order } from './cartProps'

  export default {
    name: 'cart-status',
    props: {
      order
    }
  }
</script>
