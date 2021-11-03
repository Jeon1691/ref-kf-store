<template>
  <li class="total_price">
    <strong>{{ $t('agree_payinfo.total.title') }}</strong>
    <p>
      <template v-if="$LANG === 'kr'">
        <span class="txt_number">{{ payment.paymentAccount | krw }}</span> {{ $t('common.krw') }}
      </template>
      <template v-else>
        <span class="txt_number">{{ payment.exchangePaymentAccount | usd }}</span> USD
      </template>
    </p>
  </li>
</template>

<script>
  import { payment } from './payinfoMixin'

  export default {
    name: 'payinfo-total',
    mixins: [payment]
  }
</script>