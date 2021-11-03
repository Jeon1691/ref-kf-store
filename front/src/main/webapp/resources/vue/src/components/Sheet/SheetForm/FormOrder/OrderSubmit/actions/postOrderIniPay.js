export default (async function postOrderIniPay() {
  try {
    const { data } = await this.postOrderPreparation('INICIS')

    await this.changeFieldset({
      ini_encfield: data.inicisEncfield,
      ini_certid: data.inicisTid,
      ini_paymethod: 'onlycard',
      gopaymethod: 'onlycard',
      payMethodType: 'ONLYCARD',
    })

    this.submitIniPay()
  } catch (error) {
    console.error(error)
  }
})
