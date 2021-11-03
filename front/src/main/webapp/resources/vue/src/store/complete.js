import Vue from 'vue'
import Vuex from 'vuex'
import state from './complete/state'
import mutations from './complete/mutations'
import modules from './modules'

Vue.use(Vuex)

Vue.prototype.$LANG = window.LANG

const store = new Vuex.Store({
  state,
  mutations,
  modules,
})

export default store
