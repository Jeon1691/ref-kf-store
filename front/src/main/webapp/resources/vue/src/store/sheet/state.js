import ua from '@/common/ua'
import { assignOrderSheetExpansions } from './actions'

const { __INITIAL_STATE__, LANG, PG_INI_PAY_50: { mid } } = window

const {
  oaAddressType,
  oaCountryName,
  memberId,
  member,
  memberEmail,
  memberEmailDomain,
  anonymousUser,
  memberCountryName,
  memberAddress = {},
  orderCommonVO,
  basketVO,
  countryVO,
  membershipVO,
  deliveryaddress,
  productName,
  pointPrice,
  errMsg
} = __INITIAL_STATE__

const isPc = !ua.device.type

const state = {
  fieldset: {
    bsSeqList: basketVO.bsSeqList,
    accesstype: isPc ? 1 : 5,
    goodname: productName,
    originalAmt: basketVO.paymentAccount,
    paymentAccountNotDeli: basketVO.paymentAccountNotDeli,
    acceptmethod: `SKIN(YELLOW):HPP(1):below1000:Vbank(${basketVO.paymentDate})`,
    currency: 'WON',
    oid: basketVO.oid,
    reqsign: 'DONE',
    version: '5000',
    clickcontrol: 'enable',
    P_MNAME: orderCommonVO.kakaoFriendsOnlineStore,
    PayMethod: 'KAKAOPAY',
    GoodsCnt: basketVO.orderSheetExpansions.length,
    GoodsName: productName,
    MID: mid,
    certifiedFlag: 'CN',
    merchantEncKey: orderCommonVO.pgKakaopayMerchantEncKey,
    merchantHashKey: orderCommonVO.pgKakaopayMerchantHashKey,
    requestDealApproveUrl: `${orderCommonVO.pgKakaopayWebPath}${orderCommonVO.pgKakaopayMsgName}`,
    AuthFlg: '10',
    prType: isPc ? 'WPM' : 'MPM',
    channelType: isPc ? '4' : '2',
    osDeliMoenyUse: basketVO.deliveryCharge && basketVO.deliveryCharge > 0 ? 'Y' : 'N',
    deliveryCharge: basketVO.deliveryCharge,
    ordDeliveryCharge: basketVO.deliveryCharge,
    pointPrice: pointPrice,
    osDeliType: !countryVO.countryCode || countryVO.countryCode === 'KR' ? 1 : 6,
    osDeliPayType: '2'
  },
  productName,
  anonymousUser,
  oaAddressType,
  oaCountryName: oaCountryName || '한국',
  basket: {
    ...basketVO,
    orderSheetExpansions: assignOrderSheetExpansions(basketVO.orderSheetExpansions)
  },
  membership: membershipVO,
  country: countryVO,
  orderCommon: orderCommonVO,
  deliveryaddress,
  memberId,
  buyer: {
    oaBuyerCountryName: memberCountryName || LANG === 'kr' ? '한국' : 'Korea',
    oaBuyerCountryCode: member.country || 'KR',
    oaBuyerPhone: member.phoneNumber || '',
    oaBuyerPhoneCountry: 82,
    oaBuyerName: member.name,
    oaBuyerEmailName: memberEmail,
    oaBuyerEmailDomain: memberEmailDomain,
    oaBuyerEmail: memberEmail !== '' && memberEmailDomain !== '' ? memberEmail + '@' + memberEmailDomain : ''
  },
  shipping: {
    oaCountryName: oaCountryName || '한국',
    oaCountryCode: countryVO.countryCode || 'KR',
    oaName: memberAddress.name,
    oaPhoneCountry: memberAddress.phone
      ? memberAddress.phone.substring(0, memberAddress.phone.indexOf('-'))
      : countryVO.countryList.find(c => c.EC_CODE === countryVO.countryCode).EC_PHONECODE,
    oaPhone1: memberAddress.phone
      ? memberAddress.phone.slice(memberAddress.phone.indexOf('-') + 1)
      : '',
    oaZoneCode: memberAddress.zoneCode,
    oaAddr1: memberAddress.addr1,
    oaAddr2: memberAddress.addr2,
    oaAddr3: memberAddress.addr3,
    changeNationType: 'C',
    defaultAddressType: 'D',
    memo: ''
  },
  discount: {
    pointPrice: 0,
    coupon: {
      applied: {
        duplicate: {},
        normal: {}
      },
      selected: {
        duplicate: {},
        normal: {}
      }
    }
  },
  paypal: {
    isFetching: false
  },
  agreement: [],
  dialog: {
    isShow: false,
    message: ''
  },
  memberAddress,
  payType:
    !oaCountryName || (oaCountryName === '한국' || oaCountryName === 'Korea')
      ? 'kakaopay'
      : 'onlycard',
  errMsg,
  isFetching: false
}

export default state
