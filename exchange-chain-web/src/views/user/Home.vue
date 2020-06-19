<template>
    <div class="wrapper">
        <HeaderTop></HeaderTop>
        <div class="home-wrapper">
            <Row class="home-input">
                <Col :span="11" style="height:44px">
                    <Input v-model="searchText" class="obj-input" placeholder="请输入域名进行查询">
                        <Button @click="searchBtn" slot="append" icon="ios-search"></Button>
                    </Input>
                </Col>
            </Row>
            <div class="home-tip">
                <p class="home-tip-notice"><Icon class="icon-space" type="ios-alert" />注意</p>
                <p>1、支持查询域名数据；</p>
                <p>2、数据上链后可获得积分奖励；</p>
                <p>3、使用数据时，需先向提供者支付积分报酬。</p>
            </div>
        </div>
    </div>
</template>

<script>
import { HeaderTop } from '@/components/index.js';
import { exchangeApi } from '@/api/index.js'; 
import utils from "@/utils"
export default {
    name:"home",
    components:{
        HeaderTop
    },
    data(){
        return{
            searchText:''
        }
    },
    created(){
   
    },
    methods:{
        searchBtn(){
            if(this.searchText == ''){
                this.$Message.warning('请先输入域名再搜索');
            }else{
                exchangeApi.exchangeSearchList(utils.handleInterface({domain:this.searchText})).then(res=>{
                    if(res.code == 0 ){
                        
                    }
					}).catch(err=>{
                        console.log(err)
                    })
            }
        }
    }
}
</script>
<style lang="less" scoped>
    .home-wrapper{
        background: url(../../assets/images/bg.png) no-repeat;
        background-size:100% 100%;  
        width: 100%;
        height: 100%;
        .home-input{
            display: flex;
            justify-content: center;
            padding-top: 116px;
        }
        .home-tip{
            margin: 0 auto;;
            padding-top: 11%;
            width:379px;
            height:134px;
            font-size:16px;
            font-weight:400;
            color:rgba(255,255,255,1);
            line-height:43px;
            .home-tip-notice{
                font-size:24px;
                font-weight:500;
                line-height:37px;
                margin-bottom: 30px;
            }
        }
    }
    .ivu-input-group /deep/ .ivu-input, .ivu-input-group .ivu-input-inner-container {
        height: 45px;
        border-top-left-radius: 35px;
        border-bottom-left-radius:35px;
        font-size:16px;
        font-weight:400;
        color:rgba(153,153,153,1);
        line-height:30px;
        padding-left: 40px;
        border-right: none;
    }
    /deep/ .ivu-input-group-append, .ivu-input-group>.ivu-input:last-child{
        border-top-right-radius: 35px;
        border-bottom-right-radius:35px;
        background:rgba(244,246,248,1)!important;
    }
    /deep/ .ivu-icon-ios-search:before{
        color: #135DCC;
        font-size: 30px;
        position: relative;
        top: 1px;
        left: -5px;
    }
    /deep/ .ivu-btn>.ivu-icon{
        line-height: 1;
    }
    /deep/ .ivu-input-group-append, .ivu-input-group-prepend{
        border: none;
    }
    /deep/ .ivu-input-search:before{
        display: none;
    }
    /deep/ .ivu-input-group-append .ivu-btn, .ivu-input-group-prepend .ivu-btn{
        margin: -7px -7px;
        padding: 9px 25px;
    }
</style>