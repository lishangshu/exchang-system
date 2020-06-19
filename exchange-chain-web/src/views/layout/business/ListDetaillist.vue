<template>
    <div class="all-content">
        <div class="list-box">
            <p>提供者：{{author}}</p>
        </div>
        <Card>
            <BaseDetailCard title="whois信息">
                <BaseDetailItem>
                    <span slot="label-left">域名</span>
                    <span slot="text-right">{{listData.domain}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">注册商</span>
                    <span slot="text-right">{{listData.wiRegistrarSupport}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">创建时间</span>
                    <span slot="text-right">{{listData.wiCreateTime}}</span>
                </BaseDetailItem>
                 <BaseDetailItem>
                    <span slot="label-left">过期时间</span>
                    <span slot="text-right">{{listData.wiExpirationTime}}</span>
                </BaseDetailItem>
                 <BaseDetailItem>
                    <span slot="label-left">域名服务器</span>
                    <span slot="text-right">{{listData.wiServerIp}}</span>
                </BaseDetailItem>
                 <BaseDetailItem>
                    <span slot="label-left">DNS</span>
                    <span slot="text-right">{{listData.wiDns}}</span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
        <Card>
            <BaseDetailCard title="解析记录" >
                <template slot="clickIcon" v-if="isIcon" >
                    <Icon @click="showAll()" class="icon-img" type="md-eye" size="27"></Icon>
                </template>
                <BaseDetailItem>
                    <span slot="label-left">域解析记录</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.dnsParseRecord}}</span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
        <Card>
            <BaseDetailCard title="域名注册详情">
                <!-- <template slot="clickIcon"  v-if="isIcon">
                    <Icon @click="showAll()" class="icon-img" type="md-eye" size="27"></Icon>
                </template> -->
                <BaseDetailItem>
                    <span slot="label-left">域名持有者名称</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.owner}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">所属区域</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.position}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">通讯地址</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.mailAddress}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">联系电话</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.contactPhone}}</span>
                </BaseDetailItem>
                <BaseDetailItem>
                    <span slot="label-left">电子邮件</span>
                    <span v-if="isCode" slot="text-right">**********</span>
                    <span v-if="!isCode" slot="text-right">{{listData.email}}</span>
                </BaseDetailItem>
            </BaseDetailCard>
        </Card>
        <!-- <Card>
            <DetailListTable
                title="DNSDB数据"
                :listData="listData"
                :page="listData.length>10?true:false"
                :total="total">
                <div slot="xc-table">
                    <table slot="table" class="box" cellspacing="0" >
                        <thead>
                            <tr>
                                <th width="20%">最近一次查询</th>
                                <th width="15%">第一次查询</th>
                                <th width="10%">次数</th>
                                <th width="15%">bailiwick</th>
                                <th width="15%">RRname</th>
                                <th width="10%">RRtype</th>
                                <th width="15%">Rdata</th>
                            </tr>
                        </thead>
                        <tbody v-if="listData.length>0">
                            <tr v-for="(item,index) in listData" :key="index">
                                <td>{{item.id}}</td>
                                <td>{{item.created_at}}</td>
                                <td>{{item.amount}}</td>
                                <td>{{item.amount}}</td>
                                <td>{{item.third_recharge_no}}</td>
                                <td>{{item.amount}}</td>
                                <td>{{item.amount}}</td>
                            </tr>
                            <tr v-if="isIcon">
                                <td>*******</td>
                                <td>*******</td>
                                <td>*******</td>
                                <td>*******</td>
                                <td>*******</td>
                                <td>*******</td>
                                <td>*******</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="isCode" v-if="isCode">
                        <p @click="showAll()">申请查看其他N条DNSDB数据</p>
                    </div>
                </div>
            </DetailListTable>
        </Card> -->
        <!-- <XcSpin slot="xc-spin" :SpinStatus="SpinStatus" ></XcSpin>         -->
    </div>
</template>

<script>
import { Card,BaseDetailItem,BaseDetailCard,DetailListTable,XcSpin,NoData} from '@/components/index.js';
import { loadingMixin } from '@/mixins/index';
import utils from '@/utils'
import { exchangeApi } from '@/api/index.js';

export default {
    name:"list-detail-list",
    mixins:[loadingMixin],
    components:{
        Card,
        BaseDetailItem,
        BaseDetailCard,
        DetailListTable,
        XcSpin,
        NoData
    },
    data(){
        return{
            total:0,
            page:true,
            isCode:true,
            isIcon:true,
            listData:{},
            isPermission:false,
            author:''
        }
    },
    mounted(){
        let detailId = this.$route.query.id;
        this.showNoPermissions(detailId)  
    },
    methods:{
        showNoPermissions(id){
            exchangeApi.exchangeNoDetail(utils.handleInterface({sourceId:id})).then(res=>{
                if(res.code == 0){
                    this.listData = JSON.parse(res.data)
                    this.author = JSON.parse(res.data).mobile;
                    this.isPermission = JSON.parse(res.data).hasBought
                }
            }).catch(err=>{
                console.log(err)
            })
        },
        showList(id){
            exchangeApi.exchangeDetail(utils.handleInterface({sourceId:id})).then(res=>{
                if(res.code == 0){
                    this.listData = JSON.parse(res.data);
                    this.isIcon = false
                    this.isCode = false;
                    if(res.message == 'payed'){
                        this.$Message.success('积分支付成功');
                    }else{
                        this.$Message.success('您已经支付过，本次查看不消耗积分');
                    }
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
        //展示全部数据
        showAll(){
            if(this.isPermission){
                this.showList(this.$route.query.id)
            }else{
                this.$Modal.confirm({
                    title: '提示',
                    content: '查看更多关于此域名的信息需向数据提供者支付5个积分，是否继续查看？',
                    onOk: () => {
                        this.showList(this.$route.query.id)
                    }
                });
            } 
        }
    }
}
</script>
<style lang="less" scoped>

.isCode{
    height: 80px;
    line-height: 80px;
    font-size: 14px;
    font-weight: 400;
    color: #000000;
    margin-top: 20px;
    text-align: center;
    p{
        cursor: pointer;
    }
}
</style>