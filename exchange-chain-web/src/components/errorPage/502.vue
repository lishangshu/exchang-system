<template>
    <Card class="error-page">
        <div class="error-page-box">
            <div class="error-page-left">
                <img :src="bac502" alt="">
            </div>
            <div class="error-page-right">
                <img  class="error-page-icon" :src="icon502" alt="">
                <p class="error-page-tip">服务器开小差了，请稍后再试</p>
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
import bac502 from '@/assets/images/502-bag@2x.png';
import icon502 from '@/assets/images/502@2x.png';


export default {
    name:'',
    components:{
        Card
    },
    data(){
        return{
            bac502,
            icon502
        }
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
