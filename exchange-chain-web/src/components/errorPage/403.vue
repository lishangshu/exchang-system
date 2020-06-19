<template>
    <Card class="error-page">
        <div class="error-page-box">
            <div class="error-page-left">
                <img :src="bac403" alt="">
            </div>
            <div class="error-page-right">
                <img  class="error-page-icon" :src="icon403" alt="">
                <p class="error-page-tip">很抱歉，你暂时没有权限访问该页面哦</p>
                <div class="button-bottom-box">
                    <div class="button-item button-item-back" @click="handleJumpBack">返回上一页</div>
                    <div class="button-item button-item-home" @click="handleJumpPage('home')">返回首页</div>
                </div>
            </div>
        </div>
    </Card>
</template>

<script>
import { Card } from '@/components/index';
import bac403 from '@/assets/images/403-bag@2x.png';
import icon403 from '@/assets/images/403@2x.png';
import { mapActions } from 'vuex'

export default {
    name:'',
    components:{
        Card
    },
    data(){
        return{
            bac403,
            icon403
        }
    },
    mounted(){
        this.dispathAuthorCode();
    },
    methods:{
        handleJumpPage(name){
            this.$router.push({
                name
            })
        },
        handleJumpBack(){
            this.$router.go(-1);
        }
    }
}
</script>

<style lang="less" scoped>
@import './error-page.less';
</style>
