import { mapMutations } from 'vuex'
import ua from '@/common/ua'
import postOrderKakao from './postOrderKakao'
import postOrderIniPay from './postOrderIniPay'
import postOrderIniMobile from './postOrderIniMobile'
import postOrderPreparation from './postOrderPreparation'
import submitIniPay from './submitIniPay'

export default {
  ...mapMutations(['CHANGE_INICIS', 'SHOW_DIALOG', 'HIDE_DIALOG']),
  postOrderKakao,
  postOrderIniPay,
  postOrderIniMobile,
  postOrderPreparation,
  submitIniPay,
  onSubmit() {
    if (this.payType === 'kakaopay') {
      this.postOrderKakao()
    } else {
      const isPc = !ua.device.type
      const isMobile = !isPc

      if (isPc) {
        this.postOrderIniPay()
      } else if (isMobile) {
        this.postOrderIniMobile()
      }
    }
  },
}
