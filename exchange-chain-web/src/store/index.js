// import Vue from 'vue'
// import Vuex from 'vuex'

// Vue.use(Vuex)

// export default new Vuex.Store({
//   state: {
//     searchResult :''
//   },
//   mutations: {
//     searchResult(state,res){
//       state.searchResult = res;
//     }
//   },
//   actions: {

//   },
//   modules: {

//   }
  
// })

import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'
import * as getters from './getters'
import state from './state'
import mutations from './mutations'

Vue.use(Vuex)

export default new Vuex.Store({
  actions,
  getters,
  state,
  mutations,
})

