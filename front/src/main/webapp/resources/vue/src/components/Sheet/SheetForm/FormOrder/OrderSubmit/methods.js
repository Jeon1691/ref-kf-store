import { mapMutations, mapActions } from 'vuex'
import payByIni from './actions/payByIni'
import payByKakao from './actions/payByKakao'
import postOrderIniPay from './actions/postOrderIniPay'
import postOrderIniMobile from './actions/postOrderIniMobile'
import postOrderPreparation from './actions/postOrderPreparation'
import postOrderPayment from './actions/postOrderPayment'
import renderPaypal from './actions/renderPaypal'
import submitIniPay from './actions/submitIniPay'
import { handleAlert } from '@/common/validations'

export default {
  ...mapMutations(['CHANGE_FIELDSET', 'SHOW_DIALOG']),
  ...mapActions(['changeFieldset']),
  payByKakao,
  payByIni,
  postOrderIniPay,
  postOrderIniMobile,
  postOrderPreparation,
  postOrderPayment,
  renderPaypal,
  handleAlert,
  submitIniPay,
  onPay() {
    if (this.$v.$invalid) {
      this.handleValidate()
      return
    }

    switch (this.payType) {
      case 'kakaopay':
        this.payByKakao()
        break
      case 'onlycard':
        this.payByIni()
        break
    }
  },
  handleValidate() {
    const isKr = this.$LANG === 'kr'
    const names = this.basket.orderSheetExpansions
      .filter(o => o.isOutOfStock)
      .map(o => o.product[isKr ? 'prName' : 'prName1'])

    if (names.length) {
      this.SHOW_DIALOG({
        message: this.$t('cart.out_of_stock_currently[0]', { names: `[${names.join(', ')}]` }),
      })
      return
    }

    this.handleAlert(
      [
        ['basket.orderSheetExpansions', 'order_validate.quantity'],
        ['buyer.oaBuyerName', 'order_validate.buyer.name'],
        ['buyer.oaBuyerEmail', 'order_validate.buyer.email'],
        ['buyer.oaBuyerPhoneCountry', 'order_validate.buyer.phone_country'],
        ['buyer.oaBuyerPhone', 'order_validate.buyer.phone'],
        ['shipping.oaName', 'order_validate.shipping.name'],
        ['shipping.oaPhoneCountry', 'order_validate.shipping.phone_country'],
        ['shipping.oaPhone', 'order_validate.shipping.phone'],
        ['shipping.oaZoneCode', 'order_validate.shipping.zone_code'],
        ['shipping.memo', 'order_validate.shipping.memo'],
        ['payType', 'order_validate.pay_type'],
        ['agreement', 'order_validate.agreement'],
      ],
      [
        ['shipping.oaAddr1.required', 'order_validate.shipping.addr1'],
        ['shipping.oaAddr2.required', 'order_validate.shipping.addr2'],
        ['shipping.oaAddr2.isNotSpecialChar', 'order_validate.shipping.addr2_is_not_special_char'],
        ...(this.shipping.isGlobal
          ? [
              ['shipping.oaAddr3.required', 'order_validate.shipping.addr2'],
              ['shipping.oaAddr1.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
              ['shipping.oaAddr2.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
              ['shipping.oaAddr3.isAlpha', 'order_validate.shipping.addr1_is_alpha'],
              [
                'shipping.oaAddr3.isNotSpecialChar',
                'order_validate.shipping.addr2_is_not_special_char',
              ],
            ]
          : []),
      ]
    )
  },
  handlePaypal() {
    this.handleValidate()
  },
  handleDialog() {
    this.SHOW_DIALOG({
      message: this.$t('order_validate.not_eligible'),
    })
  },
  onPaypalValidate(actions) {
    this.actions = actions
  },
}
