<template>
  <div id="mArticle"
       class="IS_VUE">
    <complete-product></complete-product>
    <complete-detail></complete-detail>
    <complete-payment></complete-payment>
    <complete-footer></complete-footer>

    <app-modal v-if="modal.isVisible"></app-modal>
    <app-dialog v-if="dialog.isVisible"></app-dialog>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import '@/filters/order'
import '@/directives/order'
import AppModal from '@/components/common/Modal'
import AppDialog from '@/components/common/Dialog'
import CompleteProduct from './CompleteProduct'
import CompleteDetail from './CompleteDetail'
import CompletePayment from './CompletePayment'
import CompleteFooter from './CompleteFooter'
import { alertPopup } from '@/components/Shipping/methods'

export default {
  name: 'Complete',
  components: {
    AppModal,
    AppDialog,
    CompleteProduct,
    CompleteDetail,
    CompletePayment,
    CompleteFooter,
  },
  computed: {
    ...mapState([
      'statusChangedFail',
      'cancelResult',
      'orderShippingInfo',
      'basket',
      'modal',
      'dialog',
    ]),
  },
  methods: {
    ...mapMutations(['SHOW_DIALOG']),
    alertPopup,
    sendGa() {
      const { ga } = window

      ga('require', 'ecommerce', 'ecommerce.js')
      ga('ecommerce:addTransaction', {
        id: this.orderShippingInfo.orderInfo.omNum,
        affiliation: 'store.kakaofriends.com',
        revenue: this.orderShippingInfo.orderInfo.totalMoney,
        shipping: this.orderShippingInfo.orderInfo.omDeliveryMoney,
      })

      this.orderShippingInfo.orderSubList.forEach(order => {
        ga('ecommerce.additem', {
          id: this.orderShippingInfo.orderInfo.omNum,
          name: order.prName,
          sku: order.orderSub.osPrCode,
          category: order.ctName,
          price: order.orderSub.osSaleMoney,
          quantity: order.orderSub.osEa,
        })
      })

      ga('ecommerce:send')
    },
    sendPixel() {
      const { kakaoPixel } = window
      const CODES = ['FRPBFRKMP0001', 'FRPBNEKMC0001', 'FRPBFRKMC0001', 'FRPBRYKMC0003', 'FRPBRYKMC0002', 'FRPBMZKMC0001', 'FRPBAPKMC0001', 'FRPBRYKMC0001']
      const isMini = this.orderShippingInfo.orderSubList.some(order => CODES.includes(order.orderSub.osPrCode))

     if (isMini) {
        kakaoPixel('5931839826969542280').pageView()
        kakaoPixel('5931839826969542280').purchase()
      }
    }
  },
  mounted() {
    if (process.env.NODE_ENV === 'production') {
      this.sendGa()
    }

    this.sendPixel()

    if (this.cancelResult) {
      if (this.basket.globalOrder) {
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
