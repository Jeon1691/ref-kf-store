import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const CHANGE_AREA = 'CHANGE_AREA'

const store = new Vuex.Store({
  state: {
    area: {
      key: '',
      name: '전지역',
    },
  },
  mutations: {
    [CHANGE_AREA](state, payload) {
      state.area = payload
    },
  },
  actions: {
    changeArea({ commit }, area) {
      commit(CHANGE_AREA, area)
    },
  },
})

export default store
