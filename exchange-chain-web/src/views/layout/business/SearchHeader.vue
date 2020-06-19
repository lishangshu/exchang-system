<template>
<div class="wrapper">
    <div class="home-wrapper">
        <Row class="home-input">
            <Col :span="13" style="height:44px">
                <Input class="obj-input" placeholder="请输入域名进行查询" v-model="searchValue">
                    <Button @click="handleSearch(searchValue)" slot="append" icon="ios-search"></Button>
                </Input>
            </Col>
        </Row>
    </div>
</div>
</template>
<script>
export default {
  name:'search-header',
  data() {
    return {
        searchValue:''
    }
  },
  props:{
    searchTextVal:{
        type:String,
        default:''
    },
  },
  created(){
      this.searchValue  =  this.searchTextVal
  },
  methods:{
      handleSearch(val){
        sessionStorage.setItem('search_text',val);
        this.$emit('search-text',val);
      }
  }
}
</script>
<style lang="less" scoped>
    .home-wrapper{
        background: url(../../../assets/images/search-bg.png) no-repeat;
        background-size:100% 100%;  
        width: 100%;
        height: 170px;
        .home-input{
            display: flex;
            justify-content: center;
            padding-top: 85px;
        }
    }
    .ivu-input-group /deep/ .ivu-input, .ivu-input-group .ivu-input-inner-container {
        height: 44px;
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