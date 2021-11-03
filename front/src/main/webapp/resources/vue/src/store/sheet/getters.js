import { exchangeRate } from '@/filters/order'

const getters = {
  shipping: ({
    oaAddressType,
    shipping,
    shipping: { oaPhoneCountry, oaPhone1, oaCountryName },
  }) => ({
    ...shipping,
    oaPhone: `${oaPhoneCountry}-${oaPhone1.replace(/-/gi, '')}`,
    isGlobal: oaCountryName !== '한국' && oaCountryName !== 'Korea',
    oaAddressType,
  }),
  buyer: ({
    buyer,
    buyer: { oaBuyerPhoneCountry, oaBuyerPhone, oaBuyerEmail },
  }) => ({
    ...buyer,
    oaBuyerPhone: `${oaBuyerPhoneCountry}-${oaBuyerPhone.replace(/-/gi, '')}`,
    oaBuyerEmail: `${oaBuyerEmail}`,
  }),
  basket: ({ basket }) => {
    return {
      ...basket,
      productCount: basket.orderSheetExpansions
        .filter(o => o.product.prType !== '8')
        .reduce((p, n) => p + n.bsEa, 0),
      giftbagCount: basket.orderSheetExpansions
        .filter(o => o.product.prType === '8')
        .reduce((a, b) => a + b.bsEa, 0),
      payOnly: basket.orderSheetExpansions
        .filter(o => o.product.prCode === 'FRPBRYCBT8100')
        .reduce((p, n) => p + n.bsEa, 0)
    }
  },
  discount: ({ discount, discount: { pointPrice, coupon: { applied, selected } } }) => {
    const selectedCouponPrice =
      (selected.normal.cph_PRICE || 0) + (selected.duplicate.cph_PRICE || 0)
    const totalCouponPrice = (applied.normal.cph_PRICE || 0) + (applied.duplicate.cph_PRICE || 0)
    const totalDiscountPrice = totalCouponPrice + pointPrice

    return {
      ...discount,
      selectedCouponPrice,
      totalCouponPrice,
      totalDiscountPrice,
      exchangeselectedCouponPrice: exchangeRate(selectedCouponPrice),
      exchangeTotalDiscountPrice: exchangeRate(totalDiscountPrice),
      exchangePointPrice: exchangeRate(pointPrice),
      giftCardCodes: [applied.duplicate.cph_CODE, applied.normal.cph_CODE].filter(c => c),
    }
  },
  payment: (
    { basket: { paymentAccountNotDeli, deliveryCharge } },
    { discount: { totalDiscountPrice } }
  ) => {
    const paymentAccount = paymentAccountNotDeli - totalDiscountPrice + deliveryCharge

    return {
      paymentAccount,
      exchangePaymentAccount: exchangeRate(paymentAccount),
    }
  },
  coupon: ({ membership: { myAvailableCouponList } }) => {
    return {
      normalCoupon: myAvailableCouponList.filter(c => c.cph_DUPLICATION === 'N'),
      duplicateCoupon: myAvailableCouponList.filter(c => c.cph_DUPLICATION === 'Y'),
    }
  },
}

export default getters
