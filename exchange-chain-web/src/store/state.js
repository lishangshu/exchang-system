const state = {
    searchList: window.localStorage.getItem('searchList') ? JSON.parse(window.localStorage.getItem('searchList')):{},
}

export default state