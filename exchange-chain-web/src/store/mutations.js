import * as types from './mutation-types'
const matutaions = {
    [types.SEARCH_DATA](state, searchList) {
        state.searchList = searchList;
        // window.localStorage.setItem('searchList', JSON.stringify(searchList));
    },
}

export default matutaions