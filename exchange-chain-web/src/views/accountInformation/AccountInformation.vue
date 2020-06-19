<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <div class="list-box">
            <p>账户信息</p>
        </div>
        <Card>
            <BaseDetailCard title="基础信息">
                <BaseDetailItem>
                    <span slot="label-left">账户地址</span>
                    <span slot="text-right" class="demo-spin-col">
                        <router-link :to="{name:'account_detail'}" class="avatar-text">
                            <span class="dropdown-item-text">
                                <span v-show="spinShow">
                                    <Spin fix >加载中...</Spin>
                                </span>
                                <span v-show="!spinShow">
                                    {{infoMation.address}}
                                </span>
                            </span>
                        </router-link>
                    </span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">账户积分</span>
                    <span slot="text-right"  class="demo-spin-col">
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                        <span v-show="!spinShow">
                            {{handleNum(infoMation.score)}}
                        </span>
                    </span>
                </BaseDetailItem>
            </BaseDetailCard>
            <!-- <BaseDetailCard title="实名认证">
                <BaseDetailItem>
                    <span slot="label-left">实名认证</span>
                    <span slot="text-right">{{infoMation.realNameStatus?'已认证':'未认证'}}</span>
                </BaseDetailItem>
            </BaseDetailCard> -->
            <BaseDetailCard title="注册信息">
                <BaseDetailItem>
                    <span slot="label-left">注册手机</span>
                    <span slot="text-right" class="demo-spin-col">
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                        <span v-show="!spinShow">
                            {{infoMation.phone}}
                        </span>
                    </span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
    </div>
</template>

<script>
import { HeaderTopUser,Card,BaseDetailItem,BaseDetailCard} from '@/components/index.js';
import utils from '@/utils'
import { accountApi } from '@/api/index.js';

export default {
    name:"account-information",
    components:{
        HeaderTopUser,
        Card,
        BaseDetailItem,
        BaseDetailCard
    },
    data(){
        return{
            infoMation:{},
            spinShow:true
        }
    },
    mounted(){
        this.getInfo();
    },
    methods:{
        handleNum(value){
            return utils.thousandSeparator(value)
        },
        getInfo(){
            accountApi.accountInformation(utils.handleInterface()).then(res=>{
                if(res.code == 0){
                   this.infoMation = res.data;
                   this.spinShow=false;
                }
                }).catch(err=>{
                    console.log(err)
            })
        },
        /**
         * 转换显示金额
         */
        getShowMoney(money){
            return utils.thousandSeparator(money)
        },
    }
}
</script>
<style lang="less" scoped>

</style>