<template>
  <div class="group_order_foot">
    <footer-attention></footer-attention>

    <div class="order_btn">
      <button v-if="orderAddDeli && !orderAddDeli.odOdPgTid"
              type="button"
              class="link_order btn_confirm"
              id="orderAddDeliSubmit"
              @click="onSubmit">
        <span class="txt_g">{{ $t('shipping_address.check_out') }}</span>
      </button>
      <a v-else
         :href="`/${$LANG}/index`"
         class="link_order btn_confirm">
        <span class="txt_g">{{ $t('usage_note.ok') }}</span>
      </a>
    </div>

    <div id="inicisMobileForm"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import FooterAttention from './FooterAttention'
import methods from './methods'

export default {
  name: 'shipping-footer',
  components: {
    FooterAttention,
  },
  computed: {
    ...mapState(['orderAddDeli', 'basket', 'payType']),
    ...mapState({
      orderInfo: state => state.orderShippingInfo.orderInfo,
      orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    }),
  },
  methods,
}
</script>
