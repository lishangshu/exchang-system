<template>
    <div class="wrapper-header">
        <div class="wrapper-title-left">
            <router-link :to="{name: 'exchange'}">
                <h4>互联网数据交换平台</h4>
                <p>Internet data exchange platform</p>
            </router-link>
        </div>
        <div class="wrapper-title-right">
            <div>
                <router-link :to="{name: 'register'}">
                    <div class="title-home">数据上链</div>
                </router-link>
                <div class="header-border"></div>
            </div>
             <router-link  :to="{name: 'login'}">
                <Button class="login-btn" type="primary">登录</Button>
             </router-link>
             <router-link  :to="{name: 'register'}">
                <Button class="login-reginer">注册</Button>
             </router-link>
        </div>
    </div>
</template>

<script>
export default {
    name:"header-top",
    data(){
        return{
            
        }
    }
}
</script>
<style lang="less" scoped>
.wrapper-header{
        padding: 0 6%;
        height: 85px;
        display: flex;
        align-items: center;
        justify-content: space-between;
        min-width: 1200px;
  .wrapper-title-left h4{
        font-size: 22px;
        font-weight:400;
        color:rgba(51,51,51,1);
        line-height:36px;
  }
   .wrapper-title-left p{
        font-size:13px;
        font-weight:400;
        color:rgba(79,148,255,1);
        line-height:21px;
   }
   .wrapper-title-right{
        display: flex;
        align-items: center;
        .header-border{
            width:64px;
            height:3px;
            background:rgba(22,97,203,1);
            position: absolute;
            top: 78px;
        }
       .title-home{
            display: inline-block;
            font-size:16px;
            font-weight:400;
            color:rgba(71,71,71,1);
        }
        .login-btn{
            margin-left: 110px;
            margin-right: 10px;
            color:rgba(255,255,255,1);
        }
        .login-reginer{
            color:rgba(129,129,129,1);
        }
        Button{
            font-size:14px;
            font-weight:400;
            width: 108px;
            height: 38px;
        }
   }

}
</style>
