import { requiredUnless } from 'vuelidate/lib/validators'
import * as buyer from '@/common/validations/buyer'
import {
  oaName,
  oaNameEn,
  oaPhoneCountry,
  oaPhone,
  oaZoneCode,
  oaAddr1,
  oaAddr1En,
  oaAddr2,
  oaAddr2En,
  memo,
  memoEn,
} from '@/common/validations/shipping'
import payType from './modules/payType'
import agreement from './modules/agreement'

export default function validations() {
  const { isGlobal } = this.shipping

  return {
    buyer,
    shipping: {
      oaName: isGlobal ? oaNameEn : oaName,
      oaPhoneCountry,
      oaPhone,
      oaZoneCode,
      oaAddr1: isGlobal ? oaAddr1En : oaAddr1,
      oaAddr2: isGlobal ? oaAddr2En : oaAddr2,
      oaAddr3: isGlobal ? oaAddr2En : requiredUnless,
      memo: isGlobal ? memoEn : memo,
    },
    payType,
    agreement,
    basket: {
      orderSheetExpansions: {
        $each: {
          isDisabled: {
            isTrue(disabled) {
              return disabled ? true : false
            },
          },
          isOutOfStock: {
            isTrue(disabled) {
              return disabled ? false : true
            },
          },
        },
      },
    },
  }
}
