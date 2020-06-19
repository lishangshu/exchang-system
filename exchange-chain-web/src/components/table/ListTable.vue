<template>
	<div class="list">
		<slot name="spin"></slot>
		<div class="list-table ">
			<div class="xc-list" :style="scroll?'overflow-x: scroll':''">
				<slot name="table"></slot>
			</div>
            <slot name="statistics-amount"></slot>
			<div class="list-bottom-bar" v-if="isShowBottomBar">
				<div class="list-bottom-box">
					<div class="list-bottom-right">
						<Page 
							@on-change="handleChange"
							:current="searchData.page"
							:page-size="searchData.limit"
							:total="total"
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
        total:{
            type:Number,
            default:0
        },
        listData:{
            type:Array,
            default:()=>{return []}
        },
        searchData:{
            type:Object,
            default:()=>{return {
				age:1,
            	limit:15
			}}
		},
		page:{
            type:Boolean,
            default:true
		},
		scroll:{
			type:Boolean,
			default:false
        },
        isShowBottomBar:{
            type:Boolean,
            default:true
		},
    },
    data() {
        return {

        };
    },
    methods:{
        /**
         * 页码改变的事件派发
         * 
         * @param {Number} page 页码
         */
        handleChange(page){
            this.$emit('select-change',page);
        }
    }
};
</script>
<style scoped lang="less">
.list {
    margin: 0 6%;
	position: relative;
	margin-top: 55px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 8px 0px rgba(0, 0, 0, 0.06);
	.list-table{
        width: 100%;
		display: inline-block;
		margin-bottom: -5px;
		.list-bottom-bar{
			padding: 24px;
            overflow: hidden;
            display: flex;
            justify-content: center;
			.list-bottom-right{
				float: right;
			}
		}
	}
}
</style>
