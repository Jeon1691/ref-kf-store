<template>
  <div class="delivery_area">
    <h3 class="tit_sub">{{ $t('payment_detail.title') }}</h3>
    <payment-summary></payment-summary>
    <payment-form></payment-form>
  </div>
</template>

<script>
import PaymentSummary from './PaymentSummary'
import PaymentForm from './PaymentForm'

export default {
  name: 'product-payment',
  components: {
    PaymentSummary,
    PaymentForm,
  },
}
</script>
