<template>
    <div class="xc-list">
        <div class="xc-list-box">
          <div class="xc-list-title" v-if="title">
            {{title}}
            <slot name="add"/>
            <slot name="clickIcon"></slot>
          </div>
        </div>
		    <slot name="spin"></slot>
        <div class="xc-list-table">
            <div class="xc-list-table" :style="scroll?'overflow-x: scroll':''">
                <slot name="xc-table"></slot>
            </div>
            <slot name="no-data"></slot>
            <div class="xc-page list-bottom-bar" v-if="page">
              <div class="list-bottom-box">
					      <div class="list-bottom-right">
                  <Page 
                      @on-change="handleChange"
                      :total="total"
                      :current="searchData.page"
                      :page-size="searchData.limit"
                      show-elevator 
                      show-total>
                  </Page>
					      </div>
              </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        title: {
            type: String,
            default: ""
        },
        page: {
            type: Boolean,
            default: true
        },
        total:{
            type:Number,
            default:0
        },
        currentPage:{
            type:Number,
            default:1
        },
        limit:{
            type:Number,
            default:15
        },
        scroll:{
            type:Boolean,
            default:false
        },
        searchData:{
          type:Object,
          default:()=>{return {}}
        }
    },
    data() {
        return {
            isShowPage: true
        };
    },
    methods: {
        /**
         * 页码改变的事件派发
         * 
         * @param {Number} page 页码
         */
        handleChange(page){
            this.$emit('select-change',page);
        },
    }  
};
</script>
<style scoped lang="less">
.xc-list {
  position: relative;
  margin: 0 10%;
  margin-top: 50px;
  box-shadow: 0px 3px 34px 0px rgba(0, 5, 46, 0.07);
    border-radius: 8px;
    .xc-list-box{
      background: #f4f5fc;
      height: 80px;
      font-size: 16px;
      font-weight: 400;
      line-height: 80px;
      padding-left: 8%;
      font-size: 17px;
      color: #000000;
      font-weight: 500;
    }
    .xc-list-title {
      position: relative;
      .add{
          float: right;
          margin-right: 24px;
          cursor: pointer;
      }
      .icon-img{
            position: absolute;
            right: 8%;
            transform: translate(0,-50%);
            top: 50%;
            cursor: pointer;
        }
    }
  .xc-list-table {
      table {
       
        border-radius: 8px;
        padding: 0 6%;
        thead {
          tr {
            th {
              background: white;
              height: 104px;
              font-size:16px;
              font-weight:400;
              color:rgba(0,0,0,1);
              text-align: left;
  
            }
          }
        }
        tbody {
          tr {
            td {
              text-align: left;
            }
          }
        }
    }
  }
}
  .list-bottom-bar{
        padding: 24px;
        overflow: hidden;
        display: flex;
        justify-content: center;
  }
tr:nth-child(2n) td {
  background: none;
}
</style>
