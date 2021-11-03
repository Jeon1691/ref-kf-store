import { mapState } from 'vuex'

export default {
  ...mapState({
    globalOrder: state => state.basket.globalOrder,
    orderAddressRequest: state => state.orderShippingInfo.orderAddressRequest,
    orderInfo: state => state.orderShippingInfo.orderInfo,
    usStateList: state => state.country.usStateList,
  }),
  oaName: {
    get() {
      return this.orderAddressRequest.oaName
    },
    set(oaName) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaName,
      })
    },
  },
  oaPhone: {
    get() {
      return this.orderAddressRequest.oaPhone
    },
    set(oaPhone) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaPhone,
      })
    },
  },
  oaZoneCode: {
    get() {
      return this.orderAddressRequest.oaZoneCode
    },
    set(oaZoneCode) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaZoneCode,
      })
    },
  },
  oaAddr1: {
    get() {
      return this.orderAddressRequest.oaAddr1
    },
    set(oaAddr1) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaAddr1,
      })
    },
  },
  oaAddr2: {
    get() {
      return this.orderAddressRequest.oaAddr2
    },
    set(oaAddr2) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaAddr2,
      })
    },
  },
  oaAddr3: {
    get() {
      return this.orderAddressRequest.oaAddr3
    },
    set(oaAddr3) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaAddr3,
      })
    },
  },
  oaDeliMemo: {
    get() {
      return this.orderAddressRequest.oaDeliMemo
    },
    set(oaDeliMemo) {
      this.CHANGE_ORDER_ADDRESS_REQUEST({
        oaDeliMemo,
      })
    },
  },
  oaDeliMemoLength() {
    return this.oaDeliMemo.length
  },
}
