import * as types from './mutation-types'
import utils from '@/utils';
import { exchangeApi } from '@/api/index';
const actions = {
    async [types.SEARCH_DATA]({dispatch,commit}) {
        //let searchList = await exchangeApi.exchangeSearchList()
        let searchList = {
            total:10,
            list:[
                {id:1,domainHash:'wwww',contentItems:'000',username:'lss',time:'20200604'},
                {id:2,domainHash:'wwww',contentItems:'111',username:'lss',time:'20200604'},
                {id:3,domainHash:'wwww',contentItems:'333',username:'lss',time:'20200604'}
            ]
        };
        window.localStorage.setItem('searchList',JSON.stringify(searchList));
        commit(types.SEARCH_DATA, searchList);
    }
}
export default actions;