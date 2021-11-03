<template>
  <dl class="list_price">
    <dt>{{ $t('agree_payinfo.basket.title') }}</dt>
    <dd>
      <span class="usd_check usd_show">
        <strong>
          <span class="num_price">{{ basket.basketAccount | krw }}</span> {{ $t('common.krw') }}
        </strong>
        <span class="txt_usd">{{ basket.exchangeBasketAccount | usd }} USD</span>
      </span>
      <span class="usd_check">
        <strong>
          <span class="num_price">
            {{ basket.exchangeBasketAccount | usd }}
          </span> USD
        </strong>
      </span>
    </dd>
  </dl>
</template>

<script>
import { basket } from '../mixin'

export default {
  name: 'payinfo-basket',
  mixins: [basket],
}
</script>
