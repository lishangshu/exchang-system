<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <div class="list-box" style="margin-bottom: -30px;">
            <p>发布记录</p>
        </div>
         <div class="table table-list">
            <ListTable
                @select-change="handleChange"
                v-if="listData.length>0"
                 :isShowBottomBar="total>10?true:false"
                :searchData="searchData"
                :total="total">
                <table slot="table" class="box" cellspacing="0">
                    <thead>
                        <tr>
                            <th>域名</th>
                            <th>解析记录</th>
                            <th>域名持有者</th>
                            <th>所属区域</th>
                            <th>发布时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item,index) in listData" :key="index">
                            <td>{{item.domain}}</td>
                            <td>
                                 <Poptip size="large" trigger="hover" word-wrap :content="item.dnsParseRecord" placement="top-start">
                                 <div class="inlineEllipsis">{{item.dnsParseRecord}}</div>
                                 </Poptip>
                                
                            </td>
                            <td>{{item.owner}}</td>
                            <td>{{item.position}}</td>
                            <td>{{getShowTime(item.createTime)}}</td>
                            <td class="link-to">
                                <div @click="handleUpdata(item)" class="detail_btn">修改</div>
                                <div @click="handleDetail(item)" class="detail_btn">详情</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </ListTable>
            <NoData slot="no-data" v-if="listData.length<=0"></NoData>
         </div>
    </div>
</template>

<script>
import { HeaderTopUser,Card,BaseDetailItem,BaseDetailCard,ListTable,NoData} from '@/components/index.js';
import utils from '@/utils'
import { accountApi } from '@/api/index.js';

export default {
    name:"release-record",
    components:{
        HeaderTopUser,
        Card,
        BaseDetailItem,
        BaseDetailCard,
        ListTable,
        NoData
    },
    data(){
        return{
            total:0,
            page:true,
            listData:[],
            searchData:{
                page:1,
            },
        }
    },
    mounted(){
        this.getRelease();
    },
    methods:{
        getRelease(){
            accountApi.accountRecord(utils.handleInterface({pageNum:this.searchData.page,pageSize:10})).then(res=>{
                if(res.code == 0){
                    this.listData = res.data.list;
                    this.total = res.data.total;
                }
                }).catch(err=>{
                    console.log(err)
            })
        },
        //下一页
        handleChange(page){
            if(!page)return;
            this.searchData.page = page;
            this.getRelease()
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
            sessionStorage.setItem('record_detail',JSON.stringify(item));
            this.$router.push({path:'release_detail'})
        },
        /**
         * 修改
         */
        handleUpdata(item){
            sessionStorage.setItem('record_updata',JSON.stringify(item));
            this.$router.push({path:'updata_release'})
        }
    }
}
</script>
<style lang="less" scoped>
    .detail_btn{
        display: inline-block;
    }
    .detail_btn:first-child{
        margin-right: 10px;
    }
    .inlineEllipsis{
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient:vertical;
        -webkit-line-clamp: 2;
        word-break: break-all;  /* 内容自动换行 */
    }
</style>