import { requiredUnless } from 'vuelidate/lib/validators'
import {
  oaName,
  oaNameEn,
  oaPhone,
  oaZoneCode,
  oaAddr1,
  oaAddr1En,
  oaAddr2,
  oaAddr2En,
  memo,
  memoEn,
} from '@/common/validations/shipping'

export default function validations() {
  return {
    oaName: this.globalOrder ? oaNameEn : oaName,
    oaPhone,
    oaZoneCode,
    oaAddr1: this.globalOrder ? oaAddr1En : oaAddr1,
    oaAddr2: this.globalOrder ? oaAddr2En : oaAddr2,
    oaAddr3: this.globalOrder ? oaAddr2En : requiredUnless,
    oaDeliMemo: this.globalOrder ? memoEn : memo,
  }
}
