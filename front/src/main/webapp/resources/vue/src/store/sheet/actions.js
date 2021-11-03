import {
  CHANGE_FIELDSET,
  CHANGE_SHIPPING_FIELDS,
  RESET_SHIPPING_FIELDS,
  CHANGE_BASKET,
  CHANGE_PAY_TYPE,
  CHANGE_IS_FETCHING,
} from './types'
import { POST_URL } from '@/common/http'
import { SHOW_DIALOG } from '@/store/modules/dialog'

export function assignOrderSheetExpansions(orderSheetExpansions) {
  return orderSheetExpansions.map(order => ({
    ...order,
    isDisabled: true,
    isOutOfStock: order.bsEa > order.stEa,
  }))
}

const actions = {
  changeFieldset({ commit }, payload) {
    return new Promise(resolve => {
      commit(CHANGE_FIELDSET, payload)
      resolve()
    })
  },
  async changeBasket({ commit, getters }, payload) {
    commit(CHANGE_IS_FETCHING, true)

    const { data: { basketVO, errMsg } } = await POST_URL(`/${window.LANG}/sheet/basketUpdate`, {
      ...payload,
      oaCountryCode: getters.shipping.oaCountryCode,
    })

    await commit(CHANGE_IS_FETCHING, false)

    if (errMsg) {
      commit(SHOW_DIALOG, { message: errMsg })
      return false
    } else {
      commit(CHANGE_BASKET, {
        ...basketVO,
        orderSheetExpansions: assignOrderSheetExpansions(basketVO.orderSheetExpansions),
      })
      return true
    }
  },
  async changeNation({ commit }, payload) {
    const isKr = payload.oaCountryCode === 'KR'

    commit(CHANGE_IS_FETCHING, true)

    const { data } = await POST_URL(`/${window.LANG}/sheet/deliUpdate`, {
      countryCode: payload.oaCountryCode,
    })

    await commit(CHANGE_IS_FETCHING, true)

    if (data.errMsg) {
      commit(SHOW_DIALOG, { message: data.errMsg })
      return
    }

    commit(CHANGE_PAY_TYPE, isKr ? 'kakaopay' : 'onlycard')
    commit(CHANGE_BASKET, {
      ...data,
      orderSheetExpansions: assignOrderSheetExpansions(data.orderSheetExpansions),
    })
    commit(RESET_SHIPPING_FIELDS)
    commit(CHANGE_SHIPPING_FIELDS, payload)
  },
}

export default actions
