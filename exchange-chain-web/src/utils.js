// import Config from '@/config.js';
import $http from '@/resource';
import { Message,Notice } from 'iview';
import Cookies from 'js-cookie';

let utils = {};
/**
 * 处理状态码
 */
utils.codeStatus = (codeList, data) => {
  let status = false;
  if (!data && !codeList) return;
  if (data == '') {
    status = true;
  }
  if (codeList.indexOf(data, 0) >= 0) {
    status = true;
  }
  return status;
}

//金额分割
utils.thousandSeparator = (num) => {
  let number = String(num);
  let arr = [];
  arr = String(number).split('.');
  let integer = arr[0];
  let decimal = '';
  if (number.indexOf(".") > -1) {
    decimal = arr[1];
  }
  var reg = /\d{1,3}(?=(\d{3})+$)/g;
  if(decimal){
    return (integer + '').replace(reg, '$&,') + "." + decimal;
  }else{
    return (integer + '').replace(reg, '$&,');
  }
}

utils.notice = (content, action = 'warning', duration = 2) => {
  let config = {};
  config.duration = duration;
  config.content = content;
  switch (action) {
    case 'info':
      return Message.info(config);
    case 'success':
      return Message.success(config);
    case 'error':
      return Message.error(config);
    case 'loading':
      return Message.loading(config);
    default:
      return Message.warning(config);
  }
}

utils.message = (title, action = 'warning', duration = 2) => {
  let config = {};
  config.duration = duration;
  config.title = title;
  switch (action) {
    case 'open':
      return Notice.open(config);
    case 'info':
      return Notice.info(config);
    case 'success':
      return Notice.success(config);
    case 'error':
      return Notice.error(config);
    default:
      return Notice.warning(config);
  }
}

/**
 * 过滤没有的数据
 * 
 * @param searchData  搜索数据，  
 * 
 * @param submitData  提交的数据，  
 * 
 * @returns 要提交的进行筛选过的数据（过滤了没有值得数据）
 */

utils.filterSearchData = (searchData, submitData) => {
  for (let key in searchData) {
    if (searchData[key]) {
      submitData[key] = searchData[key]
    }
  }
  return submitData;
}

utils.checkLogin = () => {
  if (Cookies.get('x-auth-token')) {
    return true;
  } else {
    return false;
  }
}

//提交请求数据
utils.handleInterface = (body) => {
  let sessionA = window.sessionStorage.getItem('customerId')
  let sessionB = window.sessionStorage.getItem('loginName')
  let generalBody = {
    "head":{
      customerId:sessionA,
      loginName:sessionB
    },
    body
}
  return generalBody;
}

utils.saveLogin = (data) => {
  Cookies.set('x-auth-token',data);
}

utils.loginOut = () => {
  Cookies.set("x-auth-token", "", -1);
}

//时间转换
utils.changeTime = (time) =>{
    var d = new Date(time.substr(0, 19));//加入substr(0, 19)处理兼容ios报错NAN
    var year = d.getFullYear();       //年  
    var month = d.getMonth() + 1;     //月  
    var day = d.getDate();            //日  
  
    var hh = d.getHours();            //时  
    var mm = d.getMinutes();          //分  
    var ss = d.getSeconds();           //秒  
  
    var clock = year + "-";
  
    if (month < 10)
      clock += "0";
  
    clock += month + "-";
  
    if (day < 10)
      clock += "0";
  
    clock += day + " ";
  
    if (hh < 10)
      clock += "0";
  
    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm + ":";
  
    if (ss < 10) clock += '0';
    clock += ss;
    return (clock);
  }

//获取缓存里的用户信息
utils.getStorage = () =>{
  window.sessionStorage.getItem('customerId')
}

/**
 * 过略数据请求前的为空的key
 * 
 */
utils.filterData =(formData)=>{
  const handleTrim = (value)=>{
    if (typeof value == 'string') {
      return value.trim();
    }
  }
    let datas= {}
        for(let key in formData){
 
            if (handleTrim(formData[key]) !== '' && formData[key] !== null && formData[key] !== [] && formData[key] !== {}) {
  
              datas[key] = formData[key]
            }
        }
    return datas
}

utils.getServerData = (method, formData, url, responseData) => {
  let promise;
  switch (method) {
    case 'GET':
      promise = new Promise(function (resolve, reject) {
        $http.get(url, {params: utils.filterData(formData)})
        .then(response => {
          if(response.code === 0) {
            resolve(response);
          }else if(response.code === 80001){
            Cookies.set("x-auth-token", "", -1);
            window.sessionStorage.clear();
            utils.notice("登录失效，请重新登录",'error');
            window.location.reload();
            this.$router.push({name:'exchange'})
          }else if(response.code === 401) {
            reject(response);
            utils.notice(response.message,'error');
          }else if(response.code === 500) {
            reject(response);
            utils.notice(response.message,'error');
          }else{
            reject(false);
          }
        })
      });
      break;
    case 'POST':
      promise = new Promise(function (resolve, reject) {
        $http.post(url, utils.filterData(formData)).then(response => {
          if (response.code === 0) {
            resolve(response);
          }else if(response.code === 80001){
            utils.notice("登录失效，请重新登录",'error');
            Cookies.set("x-auth-token", "", -1);
            window.sessionStorage.clear();
            window.location.reload();
            this.$router.push({name:'exchange'})
          }else if (response.code === 401) {
              reject(response);
              utils.notice(response.message,'error');
          }else if (response.code === 500) {
              reject(response);
              utils.notice(response.message,'error');
          }else{
              reject(false);
            }
        })
      });
      break
    case 'PUT':
      promise = new Promise(function (resolve, reject) {
        $http.put(url,formData).then(response => {
          if (response.code === 0) {
            resolve(response);
          } else {
             if (typeof response.msg == 'string') {
              utils.notice(response.msg, 'error');
              reject(false);
              return;
            } else if (response.code === 401) {
              reject(response);
            } else {
              for (let key in response.msg) {
                utils.notice(response.msg[key][0], 'error');
                reject(false);
                return;
              }
            }
          }
        })
      });
      break;
    case 'DELETE':
      promise = new Promise(function (resolve, reject) {
        $http.delete(url).then(response => {
          if (response.code === 200) {
            resolve(response);
          } else {
            if (typeof response.msg == 'string') {
              utils.notice(response.msg, 'error');
              reject(false);
              return;
            } else if (response.code === 401) {
              reject(response);
            } else {
              for (let key in response.msg) {
                utils.notice(response.msg[key][0], 'error');
                reject(false);
                return;
              }
            }
          }
        })
      });
      break;
  };
  return promise;
}

export default utils;