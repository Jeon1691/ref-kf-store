<template>
  <fieldset class="fld_order"
            :class="{ usd_on: payType === 'paypal' && !basket.hasForeigndelin }">
    <legend class="screen_out">{{ $t('order_form.legend') }}</legend>

    <form-cart></form-cart>
    <form-field></form-field>
    <form-pay></form-pay>

    <form-submit></form-submit>

  </fieldset>
</template>

<script>
  import { mapGetters, mapState } from 'vuex'
  import FormCart from './cart/FormCart'
  import FormField from './field/FormField'

  import FormPay from './pay/FormPay'
  import FormSubmit from './submit/FormSubmit'

  export default {
    name: 'form-order',
    components: {
      FormCart,
      FormField,
      FormPay,
      FormSubmit
    },
    computed: {
      ...mapState(['payType']),
      ...mapGetters(['basket'])
    }
  }
</script>

<style>


</style>