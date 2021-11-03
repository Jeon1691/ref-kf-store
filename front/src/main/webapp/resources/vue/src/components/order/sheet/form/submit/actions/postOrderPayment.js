import { POST_JSON } from '@/common/http'

export default function postOrderPayment({ paymentID, payerID }) {
  return POST_JSON(
    '/order/payment',
    {
      tid: paymentID,
      payerId: payerID,
    },
    {
      params: {
        payment: 'PAYPAL',
      },
    }
  )
}
