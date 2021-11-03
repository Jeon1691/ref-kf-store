import { mapState } from 'vuex'

export default {
  ...mapState({
    orderInfo: state => state.orderShippingInfo.orderInfo,
    orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
  }),
  buyerName: {
    get() {
      if (this.orderAddressRequest.buyerName === '') {
        return ''
      }
      return this.orderAddressRequest.buyerName || this.orderAddressRequest.oaBuyerName
    },
    set(buyerName) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        buyerName,
      })
    },
  },
  buyerEmail: {
    get() {
      if (this.orderAddressRequest.buyerEmail === '') {
        return ''
      }
      return this.orderAddressRequest.buyerEmail || this.orderAddressRequest.oaBuyerEmail
    },
    set(buyerEmail) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        buyerEmail,
      })
    },
  },
}
