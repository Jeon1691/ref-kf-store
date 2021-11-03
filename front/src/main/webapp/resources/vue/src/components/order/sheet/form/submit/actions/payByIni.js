import ua from '@/common/ua'

export default function payWithIni () {
  const isPayTypeIni = this.payType === 'onlycard' || this.payType === 'onlydbank'
  const isPc = !ua.device.type
  const isMobile = !isPc
  const isChrome = ua.browser.name === 'Chrome'
  const isEdge = ua.browser.name === 'Edge'
  const { ini_IsInstalledPlugin } = window

  const getMessage = () => {
    if (isChrome) {
      return this.$t('order_validate.not_compatible_chrome')
    } else if (isEdge) {
      return this.$t('order_validate.not_compatible_edge')
    }
  }

  if (isPayTypeIni) {
    if (isPc) {
      if (ini_IsInstalledPlugin()) {
        this.postOrderIniPay()
      } else {
        this.SHOW_DIALOG({
          message: getMessage()
        })
      }
    } else if (isMobile) {
      this.postOrderIniMobile()
    } else {
      this.SHOW_DIALOG({
        message: this.$t('order_validate.not_compatible_tablet')
      })
    }
  }
}
