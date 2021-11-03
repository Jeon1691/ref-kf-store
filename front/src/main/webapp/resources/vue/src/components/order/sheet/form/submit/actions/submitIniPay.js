const { MakePayMessage, IsPluginModule } = window

export default function submitIniPay() {
  window.flashPayClose = () => {
    setTimeout(() => {
      this.SHOW_DIALOG({
        message: this.$t('order_submit.cancel_payment'),
      })
    }, 500)
  }

  setTimeout(() => {
    if (document.ini.clickcontrol.value === 'enable') {
      document.ini.action = '/order/inicis'

      if (MakePayMessage(document.ini)) {
        document.ini.submit()
        return true
      } else {
        if (IsPluginModule()) {
          this.SHOW_DIALOG({
            message: this.$t('order_submit.cancel_payment'),
          })
        }
        return false
      }
    } else {
      return false
    }
  }, 500)
}
