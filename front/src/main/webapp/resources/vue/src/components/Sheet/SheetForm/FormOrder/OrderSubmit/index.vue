<template>
  <div class="order_btn">
    <a v-show="$v.$invalid && shipping.isGlobal && !basket.hasForeigndelin && payType === 'paypal'"
       class="btn_paypal"
       @click="handlePaypal"></a>
    <div v-show="shipping.isGlobal && !basket.hasForeigndelin && payType === 'paypal'"
         id="paypal_payment"
         class="btn_paypal"></div>

    <button type="button"
            class="btn_order btn_payment"
            @click="onPay"
            v-show="!(shipping.isGlobal && basket.hasForeigndelin)">
      <span class="txt_g">{{ $t('order_submit.check_out') }}</span>
    </button>

    <span class="btn_order btn_dimmed"
          v-show="shipping.isGlobal && basket.hasForeigndelin"
          @click="handleDialog">
      <span class="txt_g">{{ $t('order_submit.check_out') }}</span>
    </span>

    <div id="inicisMobileForm"></div>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import { validationMixin } from 'vuelidate'
import validations from './validations'
import methods from './methods'
import watch from './watch'

export default {
  name: 'order-submit',
  mixins: [validationMixin],
  data() {
    return {
      actions: null,
    }
  },
  computed: {
    ...mapState(['orderCommon', 'fieldset', 'productName', 'agreement', 'payType']),
    ...mapGetters(['shipping', 'buyer', 'payment', 'basket', 'discount']),
  },
  methods,
  watch,
  mounted() {
    if (this.shipping.isGlobal) {
      this.renderPaypal()
    }
  },
  validations,
}
</script>

<style scoped>
.order_btn .btn_paypal {
  top: 30px;
  z-index: 10;
  opacity: 0;
}

.order_btn a.btn_paypal {
  z-index: 11;
  cursor: pointer;
}

.btn_order.btn_dimmed {
  background-color: #f4c900;
  color: #fff;
  cursor: pointer;
}
</style>
