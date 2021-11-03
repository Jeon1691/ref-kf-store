const { orderReturnAllPopup, orderCancelPopup } = window

export default {
  orderReturnAllPopup() {
    orderReturnAllPopup(
      'alert_returnapplication_all',
      this.orderInfo.omNum,
      `/${this.$LANG}/order/shipping/returnRequestAll`
    )
  },
  orderCancelPopup() {
    orderCancelPopup(
      'alert_ordercancel',
      this.orderInfo.omNum,
      `/${this.$LANG}/order/shipping/orderCancel`
    )
  },
}
