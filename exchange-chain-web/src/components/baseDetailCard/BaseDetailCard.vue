<template>
    <div class="base-detail-card">
        <div class="base-title">
            <span>{{title}}</span>
            <slot name="clickIcon"></slot>
        </div>
        <slot></slot>
    </div>
</template>

<script>

    export default {
        name:'base-detail-card',
        props:{
            title:{
                type:String,
                default:''
            }
        },
        data(){
            return{
               
            }
        },
        methods:{
         
        }
    }
</script>

<style lang="less" scoped>
.base-detail-card{
    margin: 0 10%;
    margin-top: 30px;
    background-color: #fff;
    box-shadow:0px 3px 34px 0px rgba(0,5,46,0.07);
    border-radius:8px;
    
    .base-title{
        position: relative;
        background:rgba(244,245,252,1);
        height: 80px;
        font-size:16px;
        font-weight:400;
        color:rgba(0,0,0,1);
        line-height:80px;
        padding-left: 8%;
        font-size: 17px;
        color:rgba(0,0,0,1);
        font-weight: 500;
        .icon-img{
            position: absolute;
            right: 8%;
            transform: translate(0,-50%);
            top: 50%;
            cursor: pointer;
        }
    }
}
</style>
