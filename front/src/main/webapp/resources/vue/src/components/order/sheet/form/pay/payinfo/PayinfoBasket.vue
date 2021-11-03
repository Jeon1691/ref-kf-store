<template>
  <li>
    <strong>{{ $t('agree_payinfo.basket.title') }}</strong>
    <p class="txt_price">
      <template v-if="$LANG === 'kr'">
        {{ basket.basketAccount | krw }} {{ $t('common.krw') }}
      </template>
      <template v-else>
        {{ basket.exchangeBasketAccount | usd }} USD
      </template>
    </p>
  </li>

</template>

<script>
  import { basket } from './payinfoMixin'

  export default {
    name: 'payinfo-basket',
    mixins: [basket]
  }
</script>
