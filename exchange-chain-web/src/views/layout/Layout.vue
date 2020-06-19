<template>
    <div class="all-content">
        <HeaderTopUser v-if="realHeader"></HeaderTopUser>
        <HeaderTop v-if="!realHeader"></HeaderTop>
        <SearchHeader :searchTextVal="searchTextVal" @search-text="handleSearch"></SearchHeader>
        <SearchDataTable :searchList="searchList" :searchData="searchData" @select-page="selectPage"></SearchDataTable>
    </div>
    
</template>

<script>
import { HeaderTopUser,HeaderTop } from '@/components/index.js';
import SearchDataTable from './business/SearchDataTable';
import SearchHeader from './business/SearchHeader';
import { exchangeApi } from '@/api/index.js';
import utils from "@/utils";

export default {
    name:"layout",
    components:{
        HeaderTopUser,
        HeaderTop,
        SearchHeader,
        SearchDataTable
    },
    data(){
        return{
            searchTextVal:'',
            searchList:{},
            realHeader:false,
            searchData:{
                page:1,
            },
        }
    },
    created(){
        //根据customerId判断是否是登录状态，如果是显示登录成功的header
        this.$nextTick(()=>{
            let isLogin = window.sessionStorage.getItem('customerId')
            // let level = window.sessionStorage.getItem('level')
            if(isLogin){
                this.realHeader = true;
            }
        })
        this.searchTextVal = sessionStorage.getItem('search_text');
        this.handleSearch(this.searchTextVal)
    },
    mounted(){
        
    },
    methods:{
        handleSearch(val){
            console.log(0)
          if(val == ''){
            this.$Message.warning('请先输入域名再搜索');
          }else{
            exchangeApi.exchangeSearchList(utils.handleInterface({domain:val,pageNum:1,pageSize:10})).then(res=>{
                if(res.code == 0){
                    this.searchList = res.data;
                    this.searchData.page = res.data.pageNum;
                }
                }).catch(err=>{
                    console.log(err)
                })
          }
        },
        handleSearchPage(val){
            console.log('page')
            exchangeApi.exchangeSearchList(utils.handleInterface({domain:val,pageNum:this.searchData.page,pageSize:10})).then(res=>{
                if(res.code == 0){
                    this.searchList = res.data
                }
                }).catch(err=>{
                    console.log(err)
                })
        },
        selectPage(page){
            this.searchTextVal = sessionStorage.getItem('search_text');
            this.handleSearchPage(this.searchTextVal)
        }
    },
}
</script>
<style lang="less" scoped>

</style>