import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    n: 10
  },
  getters: {
    getN(state) {
      return state.n
    }
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
