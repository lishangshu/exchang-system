<template>
    <div class="table table-list">
          <ListTable 
            v-if="searchList.total>0"
            :total="searchList.total"
            @select-change="handleChange"
            :searchData="searchData"
            :isShowBottomBar="searchList.total>10?true:false"
          >
            <table slot="table" class="box" cellspacing="0">
                <thead>
                    <tr>
                        <th width="10%">#</th>
                        <th width="20%">域名</th>
                        <!-- <th width="20%">数据项</th> -->
                        <th width="20%">发布者</th>
                        <th width="30%">发布时间</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item,index) in searchList.list" :key="index">
                        <td>{{formatter(index)}}</td>
                        <td class="link-to" @click="checkDetail(item.id,item.loginName)">{{item.domain}}</td>
                        <!-- <td>{{item.contentItems}}</td> -->
                        <td>{{item.mobile}}</td>
                        <td>{{item.time}}</td>
                    </tr>
                </tbody>
            </table>
            <div slot="spin">
                <slot name='xc-spin'></slot>
            </div>
        </ListTable>
        <NoData slot="no-data" v-if="searchList.total<=0"></NoData>
    </div>
</template>

<script>
import { ListTable,NoData } from "@/components/index.js";
import { mapGetters,mapActions } from 'vuex'
export default {
    name:"search-data-table",
    components: {
        ListTable,
        NoData
    },
    data(){
        return{

        }
    },
    props:{
        searchList:{
            type:Object,
            default:()=>{return {}}
        },
        searchData:{
            type:Object,
            default:()=>{return {}}
        },
    },
    mounted(){
  
    },
    methods:{
        //分页序号
        formatter(index) {
            return 10 * (this.searchData.page - 1) + index + 1
        },
        checkDetail(id,name){
            let isLogin = window.sessionStorage.getItem('customerId')
            if(isLogin){
                this.$router.push({name:'list_detail',query:{'id':id}})
            }else{
                this.$Message.warning('请先登录');
                this.$router.push({name:'login',query:{'id':id}})
            }
        },
        //分页
        handleChange(page){
            if(!page)return;
            this.searchData.page = page;
            this.$emit('select-page',page)
        }
    }
}
</script>
<style lang="less" scoped>

</style>