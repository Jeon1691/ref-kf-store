import { mapMutations } from 'vuex'

const { $ } = window

export function alertPopup(popupMessage) {
  window.addEventListener('load', () => {
    $('.dimmed_layer').show()
    $('.dimmed_layer').load('/popup/alert?popupMessage=' + popupMessage)
  })
}

export default {
  ...mapMutations(['SHOW_DIALOG']),
  alertPopup,
}
