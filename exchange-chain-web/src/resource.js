import axios from 'axios'
import Cookies from 'js-cookie';
import utils from './utils';
import {
  Object
} from 'core-js';
// import { authorityApi } from '@/api/index';
import vue from 'vue';
import router from './router'

let $this = new vue({router})
var $http = axios.create({
    //baseURL: 'http://192.168.10.194:18080',
    baseURL: 'http://47.94.148.204:18080',
    timeout: 55000,
    withCredentials: true,
    headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
        "Content-Type": "application/json;charset=utf-8"
    },
});
$http.defaults.withCredentials=true;
$http.interceptors.request.use(
    config => {
        if (Cookies.get('x-auth-token')) {
            config.headers['x-auth-token'] = Cookies.get('x-auth-token');
        }
        // config.headers['x-auth-token'] ='Bearer '+Cookies.get('x-auth-token');
        return config;
    }
)

// 刷新token
// let count = 1;

// async function handleRefresh(response) {
//   count = count + 1
//   try{
//     let res = await authorityApi.getAuthRefresh();
//     if (res.code === 200) {
//       if (res.data.access_token) {
//         Cookies.set('x-auth-token', res.data.access_token);
//         let config = response.config;
//         config.headers['Authorization'] = 'Bearer ' + res.data.access_token;
//         const data = await $http.request(config);
//         count = 1;
//         return data;
//       }
//     } else {
//       //清token
//       utils.notice("登录失效", 'error');
//       Cookies.set('x-auth-token','')
//       window.location.reload();
//     }
//   }catch(err){
//     //清token
//     // utils.notice("登录失效", 'error');
//     // Cookies.set('x-auth-token', '')
//     // window.location.reload();
//   }
// }


//登录失效计数器
let failCount = 0;

$http.interceptors.response.use(
    response => {
       if (response.data.code == 403){
            $this.$router.push({
                name:'page-403'
            })
        }else if (response.data.code == 401) {
            failCount++;
            if (failCount == 1) {
                utils.notice("登录失效", 'error');
                setTimeout(() => {
                    Cookies.set('x-auth-token', '')
                    window.location.reload();
                }, 1000)
            }
        } else if (response.data.code == 1001) {
            failCount++;
            if (failCount == 1) {
                utils.notice("登录失效", 'error');
                setTimeout(() => {
                    Cookies.set('x-auth-token', '')
                    window.location.reload();
                }, 1000)
            }
        }
        return response.data;
    },
    error => { //这是异常
        if (error.response) {
            const code = error.response.status;
            if (code == 401) {
                // Cookies.set('x-auth-token', '');
                // utils.notice("认证失败，请重新登录", 'error');
            }
            if (code == 500) {
                utils.notice("接口错误，请联系管理员", 'error');
            }
            if (code == 404) {
                utils.notice("404 NOT FOUND", 'error');
            }
        }
        return Promise.reject(error)
    }
);

export default $http;