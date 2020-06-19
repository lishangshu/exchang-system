<template>
    <div class="xc-base-detail-item">
        <Row class="base-detail-content">
            <Col class="base-detail-left" span="24">
                <span class="base-detail-content-label" >
                    <slot name="label-left"></slot>
                </span>
                <span class="base-detail-content-text">
                    <slot name="text-right"></slot>
                </span>
            </Col>
        </Row>
    </div>
</template>

<script>

export default {
    name:'xc-base-detail-item',
    data(){
        return{
        }
    },
    props:{
        span:{
            type:Number,
            default:2
        }
    },
    mounted(){
        let w_max_left = 0; 
        let w_max_right = 0; 
        const elLeftList = document.querySelectorAll('.content-label-left');
        const elRightList = document.querySelectorAll('.content-label-right');
        this.$nextTick(()=>{
            for(let i=0;i<elLeftList.length;i++){
                let w = elLeftList[i].clientWidth;
                w_max_left = w > w_max_left ? w : w_max_left;
                this.$nextTick(()=>{
                     document.getElementsByClassName('content-label-left')[i].style.cssText = `min-width:${w_max_left}px`;
                 })
            }
         
            for(let j=0;j<elRightList.length;j++){
                let wRight = elRightList[j].clientWidth;
                 w_max_right = wRight > w_max_right ? wRight : w_max_right;
                 this.$nextTick(()=>{
                     document.getElementsByClassName('content-label-right')[j].style.cssText =`min-width:${w_max_right}px`;
                 })
            }
        })
    }
}
</script>

<style lang="less" scoped>
.xc-base-detail-item{
    &:last-child{
        border-bottom:none;  
    }
    margin: 0 8%;
    border-bottom: 1px solid rgba(223,224,230,1);
    .base-detail-content{
        .base-detail-left{
            display: flex;
            justify-content: space-between;
            .base-detail-content-label{
                height:68px;
                font-size:16px;
                font-weight:400;
                color:#666666;
                line-height:68px;
            }
            .base-detail-content-text{
                font-size:16px;
                font-weight:400;
                color:#000000;
                line-height:68px;
                max-width: 76%;
                text-align: right;
            }
        }
    }
}
</style>
