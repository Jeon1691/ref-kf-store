<template>
  <dl class="list_price price_total">
    <dt>{{ $t('agree_payinfo.total.title') }}</dt>
    <dd class="txt_total usd_check usd_show">
      <strong id="total_price">
        <span class="num_price">
          {{ payment.paymentAccount | krw }}
        </span>{{ $t('common.krw') }}
      </strong>
      <span class="txt_usd">
        {{ payment.exchangePaymentAccount | usd }} USD
      </span>
    </dd>
    <dd class="txt_total usd_check">
      <strong id="total_price">
        <span class="num_price">
          {{ payment.exchangePaymentAccount | usd }}
        </span> USD
      </strong>
    </dd>
  </dl>
</template>

<script>
import { payment } from '../mixin'

export default {
  name: 'payinfo-total',
  mixins: [payment],
}
</script>