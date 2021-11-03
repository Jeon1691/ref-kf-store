import Vue from 'vue'
import Vuex from 'vuex'
import modules from './modules'
import state from './shipping/state'
import mutations from './shipping/mutations'

Vue.use(Vuex)

Vue.prototype.$LANG = window.LANG

const store = new Vuex.Store({
  state,
  mutations,
  modules,
})

export default store
