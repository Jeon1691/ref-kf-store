const { $ } = window

export default (async function postOrderIniMobile() {
  try {
    const { data: { inicisMobileDom } } = await this.postOrderPreparation('INICIS_MOBILE')

    const $inicisMobileForm = $('#inicisMobileForm')
    const $inicisMobileDom = $(inicisMobileDom)

    let $dom = $inicisMobileDom.eq(0)

    if($dom.prop('tagName') !== 'FORM') {
      $dom = $inicisMobileDom.eq(1)

      if($dom.prop('tagName') !== 'FORM') {
        $dom = $inicisMobileDom.eq(2)
      }
    }

    $dom.acceptCharset = 'euc-kr'
    if (this.$LANG === 'en') {
      $dom.append($('<input type="hidden" name="P_LANG" value="en" />')[0])
    }

    $inicisMobileForm.html($inicisMobileDom)
  } catch (error) {
    console.error(error)
  }
})
