import { required, email } from 'vuelidate/lib/validators'
import { RE_ID, RE_TEL, RE_TEL_ZERO, RE_COUNTRY } from './regex'

export const oaBuyerName = {
  required,
  isName(value) {
    return RE_ID.test(value)
  },
}

export const oaBuyerEmail = {
  required,
  email,
}

export const oaBuyerPhoneCountry = {
  required,
  isCountryCode(value) {
    return RE_COUNTRY.test(value)
  },
}

export const oaBuyerPhone = {
  required,
  isPhone(value) {
    if (value.includes('-0')) {
      return RE_TEL_ZERO.test(value)
    } else {
      return RE_TEL.test(value)
    }
  },
}
