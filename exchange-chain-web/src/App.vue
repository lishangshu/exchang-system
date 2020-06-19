<template>
  <div id="app">
    <div class="top-tip" v-if="!isMainstreamBrowserShow">
      <img class="broswer-tips" src="./assets/images/broswer_tips@2x.png" alt="">温馨提示：您当前的浏览器版本过低，存在安全风险，建议尽快升级（推荐使用谷歌浏览器，360浏览器极速模式，qq浏览器）
      <img class="broswer-close"   @click="closeTip" src="./assets/images/broswer_close@2x.png" alt="">
    </div>
    <transition :name="direction">
        <router-view></router-view>
    </transition>
  </div>
</template>
<script>
export default {
    name: 'App',
    provide(){
        return{
          reload:this.reload
        }
    },
    data(){
        return{
          isMainstreamBrowserShow:true,
          isRouterAlive:true,
          direction: "slide-right"
        }
    },
     watch: {
        $route(to, from) {
          const toDepth = to.path.split("/").length;
          const fromDepth = from.path.split("/").length;
          if (to.path == "/") {
            this.direction = "slide-right";
          } else if (from.path == "/") {
            this.direction = "slide-left";
          }else{
            this.direction = toDepth < fromDepth ? "slide-right" : "slide-left";
          }
        }
      },
    created(){
        this.isMainstreamBrowser()
    },
    methods:{
      reload(){
            this.isRouterAlive = false ;
            this.$nextTick(function(){
                this.isRouterAlive = true ;
            })
        },
        closeTip(){
            this.isMainstreamBrowserShow = true;
        },
        isMainstreamBrowser(){
            let userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
            //判断是否IE浏览器
            if((!!window.ActiveXObject || "ActiveXObject" in window)){
                this.isMainstreamBrowserShow = false
                return "IE";
            }
        }
    }    
}
</script>
<style lang="less" scoped>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  width: 100%;
  height: 100%;
  min-height: 100%;
  font-family:PingFangSC-Regular,PingFang SC;
}
.top-tip{
    width: 100%;
    height: 32px;
    line-height: 32px;
    padding: 0 24px;
    color: #464C5B;
    font-size: 14px;
    background-color: rgba(255,153,0,.1);
    text-align: center;
}
.broswer-tips{
    width: 16px;
    height: 16px;
    vertical-align: top;
    margin-top: 8px;
    margin-right: 16px;
}
.broswer-close{
    width: 16px;
    height: 16px;
    vertical-align: top;
    margin-top: 8px;
    float: right;
    cursor: pointer;
}

</style>
