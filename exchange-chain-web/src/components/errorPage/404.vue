<template>
    <Card class="error-page">
        <div class="error-page-box">
            <div class="error-page-left">
                <img :src="bac404" alt="">
            </div>
            <div class="error-page-right">
                <img  class="error-page-icon" :src="icon404" alt="">
                <p class="error-page-tip">哎呀，您访问的页面消失了</p>
                <div class="button-bottom-box">
                    <div class="button-item button-item-back" @click="handleJumpBack">返回上一页</div>
                    <div class="button-item button-item-home" @click="handleJumpPage()">返回首页</div>
                </div>
            </div>
        </div>
    </Card>
</template>

<script>
import { Card } from '@/components/index';
import bac404 from '@/assets/images/404-bag@2x.png';
import icon404 from '@/assets/images/404.png';


export default {
    name:'',
    components:{
        Card
    },
    data(){
        return{
            bac404,
            icon404
        }
    },
    mounted(){
        console.log(this.icon404)
    },
    methods:{
        handleJumpPage(){
            this.$router.push({
                name:'exchange'
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
