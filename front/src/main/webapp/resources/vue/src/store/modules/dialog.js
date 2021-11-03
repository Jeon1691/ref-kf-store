export const SHOW_DIALOG = 'SHOW_DIALOG'
export const HIDE_DIALOG = 'HIDE_DIALOG'

const dialog = {
  state: {
    isVisible: false,
    message: null,
    onComplete: null,
  },
  mutations: {
    [SHOW_DIALOG](state, { message, onComplete }) {
      state.isVisible = true
      state.message = message
      state.onComplete = onComplete
    },
    [HIDE_DIALOG](state) {
      state.isVisible = false
      state.message = null
      state.onComplete = null
    },
  },
}

export default dialog
