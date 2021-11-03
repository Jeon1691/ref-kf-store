import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const { LANG } = window
const CHANGE_LANG = 'CHANGE_LANG'

const store = new Vuex.Store({
  state: {
    lang: LANG || 'kr', // ko, en, ja, zh-Hans, zh-Hant
  },
  mutations: {
    [CHANGE_LANG](state, lang) {
      state.lang = lang
    },
  },
})

export default store
