import Vue from 'vue'
import Router from 'vue-router'
import {routers} from './router'
import utils from "@/utils"

// 路由配置
const RouterConfig = {
  routes: routers,
  mode:'history'
};
const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
Vue.use(Router)
const router = new Router(RouterConfig)
router.beforeEach((to, from, next) => {
  //如果不存在token
  if(!utils.checkLogin()) { 
    if(to.name === 'login' || to.name === 'register' || to.name === 'exchange' || to.name ==='search_detail'){
      next();
    }else {
			next({name: 'login'});
		}
  }else{
    //token存在
    if(to.matched.length === 0) {
      next({name: 'page-404'}) // 判断此跳转路由的来源路由是否存在，存在的情况跳转到来源路由，否则跳转到404页面
    }else{
      next();
    }
  }
});

export default router
