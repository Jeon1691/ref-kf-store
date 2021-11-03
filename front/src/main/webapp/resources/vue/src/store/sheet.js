import Vue from 'vue'
import Vuex from 'vuex'
import state from './sheet/state'
import getters from './sheet/getters'
import mutations from './sheet/mutations'
import actions from './sheet/actions'
import modules from './modules'

Vue.use(Vuex)

Vue.prototype.$LANG = window.LANG

const store = new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
  modules,
})

export default store
