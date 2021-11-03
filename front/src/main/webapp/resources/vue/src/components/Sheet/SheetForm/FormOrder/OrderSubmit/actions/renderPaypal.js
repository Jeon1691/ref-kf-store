import isObject from 'lodash/isObject'

const { paypal } = window

export default function renderPaypal() {
  const { $LANG, $t, onPaypalValidate, postOrderPayment, postOrderPreparation, SHOW_DIALOG } = this

  paypal.Button.render(
    {
      env: this.orderCommon.paypalButton,
      style: {
        label: 'pay',
        size: 'responsive',
        shape: 'rect',
        color: 'gold',
      },
      commit: true,
      validate(actions) {
        actions.disable()
        onPaypalValidate(actions)
      },
      payment() {
        return new paypal.Promise((resolve, reject) => {
          postOrderPreparation('PAYPAL')
            .then(response => response.data)
            .then(data => {
              resolve(data.paypalPaymentId)
            })
            .catch(error => {
              reject(error.response.data)
            })
        })
      },
      onAuthorize(data) {
        postOrderPayment(data)
          .then(response => {
            if (isObject(response.data)) {
              window.location.href = `/${$LANG}/order/complete`
            }
          })
          .catch(error => {
            setTimeout(() => {
              SHOW_DIALOG({
                message: error.response.data,
              })
            }, 250)
          })
      },
      onCancel() {
        SHOW_DIALOG({
          message: $t('order_submit.cancel_payment'),
        })
      },
    },
    '#paypal_payment'
  )
}
