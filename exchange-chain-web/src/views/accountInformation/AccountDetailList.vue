<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <div class="list-box">
            <p>交易详情</p>
        </div>
        <Card>
            <BaseDetailCard title="交易详情">
                <BaseDetailItem>
                    <span slot="label-left">交易哈希：</span>
                    <span slot="text-right">{{listData.transactionHash}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">时间:</span>
                    <span slot="text-right">{{getShowTime(listData.createTime)}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">所在区块：</span>
                    <span slot="text-right">{{listData.blockHash}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">区块哈希：</span>
                    <span slot="text-right">{{listData.transactionHash}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">发起方：</span>
                    <span slot="text-right">{{listData.eventOutAddress}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">接收方：</span>
                    <span slot="text-right">{{listData.eventInAddress}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">积分：</span>
                    <span slot="text-right">{{listData.eventAmount}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">类型：</span>
                    <span slot="text-right">{{depositType}}</span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
    </div>
</template>

<script>
import { HeaderTopUser,Card,BaseDetailItem,BaseDetailCard} from '@/components/index.js';
import utils from '@/utils'
export default {
    name:"account-detail-detail",
    components:{
        HeaderTopUser,
        Card,
        BaseDetailItem,
        BaseDetailCard,
    },
    data(){
        return{
            total:0,
            page:true,
            listData:{},
            depositType:''
        }
    },
    created(){
        let value = sessionStorage.getItem('account_detail');
        let depositType = sessionStorage.getItem('depositType');
        this.depositType = JSON.parse(depositType) ? '转入':'转出';
        this.listData = JSON.parse(value);
    },
    methods:{
        /**
         * 时间转换
         */
        getShowTime(value){
            return utils.changeTime(value)
        },
    }
}
</script>
<style lang="less" scoped>

</style>