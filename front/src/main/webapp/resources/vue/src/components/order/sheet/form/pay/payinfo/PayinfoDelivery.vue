<template>
  <li>
    <strong>{{ $t('agree_payinfo.delivery.title') }}</strong>
    <p>
      <template v-if="$LANG === 'kr'">
        <template v-if="basket.deliveryCharge === 0">
          <span class="txt_free">무료</span>
        </template>
        <template v-else>
          {{ basket.deliveryCharge | krw }}{{ $t('common.krw') }}
        </template>
      </template>
      <template v-else>
        {{ basket.exchangeDeliveryCharge | usd }} USD
      </template>
    </p>
  </li>
</template>

<script>
  import { basket } from './payinfoMixin'

  export default {
    name: 'payinfo-delivery',
    mixins: [basket]
  }
</script>