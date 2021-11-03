import { POST_JSON } from '@/common/http'

export default (async function postOrderPreparation(payment) {
  const { bsSeqList = '' } = this.basket
  const { isGlobal } = this.shipping
  const addressGroup = isGlobal
    ? {
        receiverState: this.shipping.oaAddr1,
        receiverAddress: this.shipping.oaAddr2,
        receiverDetailAddress: this.shipping.oaAddr3 || '',
      }
    : {
        receiverState: '',
        receiverAddress: this.shipping.oaAddr1,
        receiverDetailAddress: this.shipping.oaAddr2,
      }

  try {
    const response = await POST_JSON(
      '/order/preparation',
      {
        basketSequenceList: bsSeqList.split(',').map(seq => parseInt(seq, 10)),
        giftCardCodeList: this.discount.giftCardCodes,
        pointUsedPrice: this.discount.pointPrice,
        buyerCountry: this.buyer.oaBuyerCountryCode.toUpperCase(),
        buyerName: this.buyer.oaBuyerName,
        buyerEmail: this.buyer.oaBuyerEmail,
        receiverCountry: this.shipping.oaCountryCode,
        receiverName: this.shipping.oaName,
        receiverPhone: this.shipping.oaPhone,
        receiverZipCode: this.shipping.oaZoneCode,
        deliveryMemo: this.shipping.memo,
        buyerPhone: this.buyer.oaBuyerPhone,
        defaultAddress: this.shipping.oaAddressType === 'D' ? true : false,
        saveDefaultAddress: this.shipping.defaultAddressType === 'S' ? true : false,
        ...addressGroup,
      },
      {
        params: {
          payment,
        },
      }
    )

    return response
  } catch (error) {
    this.SHOW_DIALOG({
      message: error.response.data,
    })
  }
})
