import { CHANGE_ORDER_ADDRESS_REQUEST, CHANGE_PAY_TYPE, CHANGE_INICIS } from './types'

export default {
  [CHANGE_ORDER_ADDRESS_REQUEST](state, fields) {
    state.orderShippingInfo.orderAddressRequest = {
      ...state.orderShippingInfo.orderAddressRequest,
      ...fields,
    }
  },
  [CHANGE_PAY_TYPE](state, type) {
    state.payType = type
  },
  [CHANGE_INICIS](state, fields) {
    state.inicis = {
      ...state.inicis,
      ...fields,
    }
  },
}
