<template>
  <div id="mArticle">
    <h2 id="kakaoBody"
        class="tit_order">{{ $t('title') }}</h2>

    <div class="info_delivery">
      <shipping-info></shipping-info>
      <shipping-delivery></shipping-delivery>
    </div>

    <shipping-product></shipping-product>
    <shipping-footer></shipping-footer>

    <app-modal v-if="modal.isVisible"></app-modal>
    <app-dialog v-if="dialog.isVisible"></app-dialog>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import ua from '@/common/ua'
import '@/filters/order'
import '@/directives/order'
import AppModal from '@/components/common/Modal'
import AppDialog from '@/components/common/Dialog'
import ShippingInfo from './ShippingInfo'
import ShippingDelivery from './ShippingDelivery'
import ShippingProduct from './ShippingProduct'
import ShippingFooter from './ShippingFooter'
import methods from './methods'

export default {
  name: 'Shipping',
  components: {
    AppModal,
    AppDialog,
    ShippingInfo,
    ShippingDelivery,
    ShippingProduct,
    ShippingFooter,
  },
  computed: {
    ...mapState(['modal', 'dialog', 'cancelResult', 'statusChangedFail', 'errMsg', 'complete']),
    ...mapState({
      globalOrder: state => state.basket.globalOrder,
    }),
  },
  methods,
  mounted() {
    const { StartSmartUpdate } = window

    if (!ua.device.type && ua.browser.name !== 'chrome') {
      StartSmartUpdate()
    }

    if (this.errMsg) {
      this.SHOW_DIALOG({
        message: this.errMsg,
      })
    }

    if (this.complete) {
      this.SHOW_DIALOG({
        message: this.complete,
      })
    }

    if (this.cancelResult) {
      if (this.globalOrder) {
        this.alertPopup(
          this.cancelResult ? 'alert_globalordercancel_success' : 'alert_ordercancel_fail'
        )
      } else {
        this.alertPopup(this.cancelResult ? 'alert_ordercancel_success' : 'alert_ordercancel_fail')
      }
    }

    if (this.statusChangedFail) {
      this.SHOW_DIALOG({
        message: this.statusChangedFail,
      })
    }
  },
}
</script>
