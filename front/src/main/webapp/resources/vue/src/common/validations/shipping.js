import { required, minLength, maxLength } from 'vuelidate/lib/validators'
import {
  RE_ID,
  RE_EID,
  RE_EN,
  RE_TEL,
  RE_TEL_ZERO,
  RE_TEL_GLOBAL,
  RE_POSTAL,
  RE_MEMO,
  RE_COUNTRY,
  RE_ADDRESS,
} from './regex'

export const oaName = {
  required,
  isName(value) {
    return RE_ID.test(value)
  },
}

export const oaNameEn = {
  required,
  isAlpha(value) {
    return RE_EID.test(value)
  },
}

export const oaPhoneCountry = {
  required,
  isCountryCode(value) {
    return RE_COUNTRY.test(value)
  },
}

export const oaPhone = {
  required,
  isPhone(value) {
    if (value.includes('-0')) {
      return RE_TEL_ZERO.test(value)
    } else {
      return RE_TEL.test(value)
    }
  },
}

export const oaPhoneGlobal = {
  required,
  isPhone(value) {
    return RE_TEL_GLOBAL.test(value)
  },
}

export const oaZoneCode = {
  required,
  isPostal(value) {
    return RE_POSTAL.test(value)
  },
}

export const oaAddr1 = {
  required,
  minLength: minLength(2),
  maxLength: maxLength(100),
}

export const oaAddr1En = {
  ...oaAddr1,
  isAlpha(value) {
    return !RE_EN.test(value)
  },
}

export const oaAddr2 = {
  required,
  minLength: minLength(2),
  maxLength: maxLength(100),
  isNotSpecialChar(value) {
    return !RE_ADDRESS.test(value)
  },
}

export const oaAddr2En = {
  ...oaAddr2,
  isAlpha(value) {
    return !RE_EN.test(value)
  },
}

export const memo = {
  isNotSpecialChar(value) {
    return !RE_MEMO.test(value)
  },
}

export const memoEn = {
  ...memo,
  isAlpha(value) {
    return !RE_EN.test(value)
  },
}
