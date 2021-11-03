const { $ } = window

export default (async function postOrderIniMobile() {
  try {
    const { data: { inicisMobileDom } } = await this.postOrderPreparation(
      {
        orderNumber: this.orderInfo.omNum,
        buyerName: this.orderAddressRequest.oaBuyerName,
        buyerEmail: this.orderAddressRequest.oaBuyerEmail,
        buyerPhone: this.orderAddressRequest.oaBuyerPhone,
      },
      'INICIS_MOBILE'
    )
    const $inicisMobileForm = $('#inicisMobileForm')
    const $inicisMobileDom = $(inicisMobileDom)

    $inicisMobileDom[0].acceptCharset = 'euc-kr'
    if (this.$LANG === 'en') {
      $inicisMobileDom[0].append($('<input type="hidden" name="P_LANG" value="en" />')[0])
    }

    $inicisMobileForm.html($inicisMobileDom)
  } catch (error) {
    console.error(error)
  }
})
