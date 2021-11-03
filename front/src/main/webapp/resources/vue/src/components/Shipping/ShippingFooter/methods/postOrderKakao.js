export default (async function postOrderKakao() {
  const { data } = await this.postOrderPreparation(
    {
      orderNumber: this.orderInfo.omNum,
    },
    'KAKAOPAY'
  )

  window.location.href = data.kakaopayUrl
})
