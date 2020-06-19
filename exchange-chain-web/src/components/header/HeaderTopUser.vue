
<template>
    <div class="wrapper-header">
        <div class="wrapper-title-left">
            <router-link :to="{name: 'exchange'}">
                <h4>互联网数据交换平台</h4>
                <p>Internet data exchange platform</p>
            </router-link>
        </div>
        <div class="wrapper-title-right">
            <div class="top-nav">
                <router-link :to="{name: 'add_data'}">
                    <div class="title-home">数据上链</div>
                </router-link>
                <div class="header-border"></div>
            </div>
            <div class="demo-avatar">  
                <Dropdown>
                    <Avatar size="large" class="avatar" style="background-color: #2D8CF0" icon="ios-person"></Avatar>
                    <DropdownMenu slot="list" class="avatar-menu">
                        <DropdownItem>
                            <router-link :to="{name:'information'}" class="avatar-text">
                                <span class="dropdown-item-text">账户信息</span>
                            </router-link>
                        </DropdownItem>
                        <DropdownItem>
                            <router-link :to="{name:'account_detail'}" class="avatar-text">
                                <span class="dropdown-item-text">账户详情</span>
                            </router-link>
                        </DropdownItem>
                        <DropdownItem>
                            <router-link :to="{name:'release_record'}" class="avatar-text">
                                <span class="dropdown-item-text">发布记录</span>
                            </router-link>
                        </DropdownItem>
                        <DropdownItem>
                            <span class="avatar-text dropdown-item-text" @click="loginOut()">退出登录</span>
                        </DropdownItem>
                    </DropdownMenu>
                </Dropdown>
            </div>
        </div>
    </div>
</template>

<script>
import utils from "@/utils"
export default {
    name:"header-top-user",
    data(){
        return{
             user:''
        }
    },
    mounted(){
        let IconName  = sessionStorage.getItem('username');
        this.user = IconName.charAt(0)
    },
    methods:{
        loginOut(){
            this.$Modal.confirm({
                title: '退出',
                content: '您确定要退出登录吗？',
                onOk: () => {
                    this.$Message.success({
                        content: "退出成功",
                        duration: 2,
                        onClose:()=>{
                            utils.loginOut();
                            this.$router.push({name:'login'})
                            window.sessionStorage.clear();
                            // window.location.reload();
                        }
                    });
                }
            });
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
        .top-nav{
            margin-right: 210px;
        }
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
        .demo-avatar{
            .avatar{
                background: #007CFA;
                cursor: pointer;
            }
        }
   }
    .avatar-menu{
        width: 116px;
    }
    /deep/ .ivu-dropdown-item{
        text-align: center;
        font-size:16px!important;
        font-weight:400;
        color:rgba(102,102,102,1);
        padding: 9px 16px;
    }
    /deep/ .ivu-dropdown-item:hover {
        color:rgba(102,102,102,0.6);
        background: none;
    }
    .avatar-text{
        color: #666666;
    }
    .avatar-text:hover{
        color:rgba(102,102,102,0.6);
    }
}
</style>
