<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <Card class="detail-ti">
            <BaseDetailCard title="发布记录详情">
                <BaseDetailItem>
                    <span slot="label-left">发布时间：</span>
                    <span slot="text-right">{{getShowTime(listData.createTime)}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">域名:</span>
                    <span slot="text-right">{{listData.domain}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">解析记录</span>
                    <span slot="text-right">{{listData.dnsParseRecord}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">域名持有者名称（中文）：</span>
                    <span slot="text-right">{{listData.owner}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">所属区域：</span>
                    <span slot="text-right">{{listData.position}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">通讯地址（中文）：</span>
                    <span slot="text-right">{{listData.mailAddress}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">邮编：</span>
                    <span slot="text-right">{{listData.maillNo}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">联系电话：</span>
                    <span slot="text-right">{{listData.contactPhone}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">电子邮箱：</span>
                    <span slot="text-right">{{listData.email}}</span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
    </div>
</template>

<script>
import { HeaderTopUser,Card,BaseDetailItem,BaseDetailCard} from '@/components/index.js';
import utils from '@/utils'
export default {
    name:"release-detail",
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
            listData:{}
        }
    },
    created(){
        let value = sessionStorage.getItem('record_detail');
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
.detail-ti /deep/ .base-detail-card .base-title{
    font-size: 22px;
}
</style>