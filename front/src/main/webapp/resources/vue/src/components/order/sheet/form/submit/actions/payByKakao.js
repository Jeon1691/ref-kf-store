export default (async function payByKakao() {
  try {
    const { data } = await this.postOrderPreparation('KAKAOPAY')
    if (data.kakaopayUrl) {
      window.location.href = data.kakaopayUrl
    }
  } catch (error) {
    console.log(error)
  }
})
