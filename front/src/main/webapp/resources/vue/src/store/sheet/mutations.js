import {
  APPLY_POINT,
  CHANGE_BUYER_FIELD,
  CHANGE_BUYER_NATION,
  CHANGE_SHIPPING_FIELDS,
  CHANGE_PAY_TYPE,
  CHANGE_FIELDSET,
  CHANGE_DISCOUNT_FIELDS,
  CHANGE_BASKET,
  CHANGE_BASKET_EA,
  CHANGE_BASKET_DISABLED,
  CHANGE_DIALOG,
  CHANGE_AGREEMENT,
  CHANGE_OA_ADDRESS_TYPE,
  RESET_SHIPPING_FIELDS,
  CHANGE_IS_FETCHING,
} from './types'

const mutations = {
  [APPLY_POINT](state, pointPrice) {
    state.discount.pointPrice = pointPrice
  },
  [CHANGE_BASKET](state, fields) {
    state.basket = {
      ...state.basket,
      ...fields,
    }
  },
  [CHANGE_BASKET_EA](state, { index, ea }) {
    state.basket.orderSheetExpansions[index].bsEa = ea
  },
  [CHANGE_BASKET_DISABLED](state, { index, disabled }) {
    state.basket.orderSheetExpansions[index].isDisabled = disabled
  },
  [CHANGE_BUYER_NATION](state, { oaCountryName, oaCountryCode, oaPhoneCountry }) {
    state.shipping.oaAddr1 = oaCountryCode === 'US' ? 'CA (California)' : ''
    state.buyer.oaBuyerCountryName = oaCountryName
    state.buyer.oaBuyerCountryCode = oaCountryCode
    state.buyer.oaBuyerPhoneCountry = oaPhoneCountry
  },
  [CHANGE_BUYER_FIELD](state, field) {
    state.buyer = {
      ...state.buyer,
      ...field,
    }
  },
  [CHANGE_SHIPPING_FIELDS](state, fields) {
    state.shipping = {
      ...state.shipping,
      ...fields,
    }
  },
  [RESET_SHIPPING_FIELDS](state) {
    state.shipping = {
      ...state.shipping,
      oaAddr1: '',
      oaAddr2: '',
      oaAddr3: '',
      oaName: '',
      oaPhone1: '',
      oaZoneCode: '',
    }
  },
  [CHANGE_PAY_TYPE](state, type) {
    state.payType = type
  },
  [CHANGE_FIELDSET](state, fieldset) {
    state.fieldset = {
      ...state.fieldset,
      ...fieldset,
    }
  },
  [CHANGE_DISCOUNT_FIELDS](state, fields) {
    state.discount = {
      ...state.discount,
      ...fields,
    }
  },
  [CHANGE_DIALOG](state, message) {
    state.dialog = {
      isShow: !state.dialog.isShow,
      message,
    }
  },
  [CHANGE_AGREEMENT](state, checked) {
    state.agreement = checked
  },
  [CHANGE_OA_ADDRESS_TYPE](state, type) {
    state.oaAddressType = type
  },
  [CHANGE_IS_FETCHING](state, fetching) {
    state.isFetching = fetching
  },
}

export default mutations
