export default (async function postOrderIniPc() {
  try {
    const { data } = await this.postOrderPreparation(
      {
        orderNumber: this.orderInfo.omNum,
        buyerName: this.orderAddressRequest.oaBuyerName,
        buyerEmail: this.orderAddressRequest.oaBuyerEmail,
        buyerPhone: this.orderAddressRequest.oaBuyerPhone,
      },
      'INICIS'
    )

    await this.CHANGE_INICIS({
      inicisEncfield: data.inicisEncfield,
      inicisTid: data.inicisTid,
      orderNumber: data.orderNumber,
      paymentGateway: data.paymentGateway,
      buyerEmail: data.buyerEmail,
      buyerName: data.buyerName,
    })

    this.submitIniPay()
  } catch (error) {
    console.error(error)
  }
})
