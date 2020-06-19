import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from '@/store/index'
import iview from 'iview'
import 'iview/dist/styles/iview.css'
import './theme/index.less';

Vue.config.productionTip = false
Vue.use(iview)

//数字格式化
Vue.filter('handleNumber', function (num) {
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
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
