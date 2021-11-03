import { POST_JSON } from '@/common/http'

export default function postOrderPreparation(data, payment) {
  try {
    return POST_JSON('/orderadddeli/preparation', data, {
      params: {
        payment,
      },
    })
  } catch (error) {
    this.SHOW_DIALOG({
      message: error.response.data,
    })
  }
}
