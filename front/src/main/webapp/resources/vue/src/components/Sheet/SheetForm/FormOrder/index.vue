<template>
  <fieldset class="fld_order"
            :class="{ usd_on: payType === 'paypal' && !basket.hasForeigndelin }">
    <legend class="screen_out">{{ $t('order_form.legend') }}</legend>

    <order-cart></order-cart>
    <order-field></order-field>
    <order-pay-method></order-pay-method>
    <order-agree></order-agree>
    <order-submit></order-submit>
  </fieldset>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import OrderCart from './OrderCart'
import OrderField from './OrderField'
import OrderAgree from './OrderAgree'
import OrderPayMethod from './OrderPayMethod'
import OrderSubmit from './OrderSubmit'

export default {
  name: 'form-order',
  components: {
    OrderCart,
    OrderField,
    OrderAgree,
    OrderPayMethod,
    OrderSubmit,
  },
  computed: {
    ...mapState(['payType']),
    ...mapGetters(['basket']),
  },
}
</script>
