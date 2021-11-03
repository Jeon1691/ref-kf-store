const { MakePayMessage, IsPluginModule } = window

export default function submitIniPay() {
  setTimeout(() => {
    if (document.ini.clickcontrol.value === 'enable') {
      document.ini.action = '/orderadddeli/inicis'

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
