<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <div class="list-box">
            <p>账户详情</p>
        </div>
        <Card>
            <BaseDetailCard title="概览">
                <BaseDetailItem>
                    <span slot="label-left">账户地址</span>
                    <span slot="text-right" class="demo-spin-col">
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                         <span  v-show="!spinShow">
                            {{detailData.address}}
                        </span>
                    </span>
                </BaseDetailItem>
                <BaseDetailItem v-cloak>
                    <span slot="label-left">账户积分</span>
                    <span slot="text-right" class="demo-spin-col">
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                         <span  v-show="!spinShow">
                            {{handleNum(detailData.score)}}
                        </span>
                    </span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">交易数量</span>
                    <span slot="text-right"  class="demo-spin-col">
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                        <span  v-show="!spinShow">
                            {{handleNum(total)}}
                        </span>
                    </span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
        <Card>
            <DetailListTable
                title="交易记录"
                :page="total>10?true:false"
                @select-change="handleChange"
                :searchData="searchData"
              
                :total="total">
                <div slot="xc-table">
                    <table slot="table" class="box" cellspacing="0">
                        <thead>
                            <tr>
                                <th width="19%">交易哈希</th>
                                <th width="19%">所在区块</th>
                                <th width="15%">时间</th>
                                <th width="15%">发起方</th>
                                <th width="15%">接收方</th>
                                <th width="8.5%">积分</th>
                                <th width="8.5%">类型</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(item,index) in tableArr" :key="index">
                                <td @click="handleDetail(item)" class="link-to">
                                    <Poptip size="large" trigger="hover" word-wrap :content="item.transactionHash" placement="top-start">
                                        <div class="inlineEllipsis">{{item.transactionHash}}</div>
                                    </Poptip>
                                </td>
                                <td>
                                    <Poptip size="large" trigger="hover" word-wrap :content="item.blockHash" placement="top-start">
                                        <div class="inlineEllipsis">{{item.blockHash}}</div>
                                    </Poptip>
                                </td>
                                <td>{{getShowTime(item.createTime)}}</td>
                                <td>
                                    <Poptip size="large" trigger="hover" word-wrap :content="item.eventOutAddress" placement="top-start">
                                        <div class="inlineEllipsis">{{item.eventOutAddress}}</div>
                                    </Poptip>
                                </td>
                                <td>
                                    <Poptip size="large" trigger="hover" word-wrap :content="item.eventInAddress" placement="top-start">
                                        <div class="inlineEllipsis">{{item.eventInAddress}}</div>
                                    </Poptip>
                                </td>
                                <td>{{item.eventAmount}}</td>
                                <td>{{detailData.address == item.eventInAddress?'转入':'转出'}}</td>
                            </tr>
                        </tbody>
                    </table>
                    <div>
                        <span v-show="spinShow">
                            <Spin fix >加载中...</Spin>
                        </span>
                        <span v-show="!spinShow">
                            <NoData slot="no-data" v-if="total<=0"></NoData>
                        </span>
                    </div>
                </div>
            </DetailListTable>
        </Card>
        <!-- <XcSpin slot="xc-spin" :SpinStatus="SpinStatus" ></XcSpin>-->
    </div>
</template>

<script>
import { HeaderTopUser,Card,BaseDetailItem,BaseDetailCard,DetailListTable,NoData} from '@/components/index.js';
import utils from '@/utils'
import { accountApi } from '@/api/index.js';
import { loadingMixin } from '@/mixins/index';
export default {
    name:"account-detail",
    mixins:[loadingMixin],
    components:{
        HeaderTopUser,
        Card,
        BaseDetailItem,
        BaseDetailCard,
        DetailListTable,
        NoData,
    },
    data(){
        return{
            total:0,
            page:true,
            detailData:{},
            tableArr:[],
            searchData:{
                page:1,
            },
            spinShow:true
        }
    },
    mounted(){
        this.getAccountDetail();
        
    },

    methods:{
        handleNum(value){
            return utils.thousandSeparator(value)
        },
        getAccountDetail(){
            accountApi.accountDetail(utils.handleInterface({pageNum:this.searchData.page,pageSize:10})).then(res=>{
                if(res.code == 0){
                   this.detailData = res.data;
                   this.total = res.data.transactions.total;
                   this.tableArr = res.data.transactions.list;
                   this.spinShow=false
                }
                }).catch(err=>{
                    console.log(err)
            })
        },
        /**
         * 时间转换
         */
        getShowTime(value){
            return utils.changeTime(value)
        },
        /**
         * 详情
         */
        handleDetail(item){
            let depositType =  this.detailData.address == item.eventInAddress?true:false
            sessionStorage.setItem('depositType',depositType);
            sessionStorage.setItem('account_detail',JSON.stringify(item));
            this.$router.push({path:'account_details'})
        },
        //分页
        handleChange(page){
            if(!page)return;
            this.searchData.page = page;
            this.getAccountDetail()
        }
    }
}
</script>
<style lang="less" scoped>
    .inlineEllipsis{
        width: 100%;
        height: 45px;
        overflow: hidden;
            text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient:vertical;
        -webkit-line-clamp: 2;
        word-break: break-all;  /* 内容自动换行 */
    }
    /deep/ .no-data-warning{
        height: 142px;
        padding-top: 10px;
        box-sizing: border-box;
        text-align: center;
    }


    
</style>