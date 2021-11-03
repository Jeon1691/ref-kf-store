const SHOW_MODAL = 'SHOW_MODAL'
const HIDE_MODAL = 'HIDE_MODAL'

const modal = {
  state: {
    isVisible: false,
    component: null,
    name: '',
    onComplete: null,
  },
  mutations: {
    [SHOW_MODAL](state, { component, name, onComplete }) {
      state.isVisible = true
      state.component = component
      state.name = name
      state.onComplete = onComplete
    },
    [HIDE_MODAL](state) {
      state.isVisible = false
      state.component = null
      state.onComplete = null
      state.name = ''
    },
  },
}

export default modal
