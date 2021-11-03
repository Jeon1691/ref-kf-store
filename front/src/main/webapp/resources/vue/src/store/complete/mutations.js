import { CHANGE_ORDER_ADDRESS_REQUEST } from './types'

export default {
  [CHANGE_ORDER_ADDRESS_REQUEST](state, fields) {
    state.orderShippingInfo.orderAddressRequest = {
      ...state.orderShippingInfo.orderAddressRequest,
      ...fields,
    }
  },
}
