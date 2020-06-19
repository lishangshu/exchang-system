<template>
    <div class="xc-spin">
        <Spin fix size="large" v-if="SpinStatus">
            <Icon type="ios-loading" size=30 class="demo-spin-icon-load"></Icon>
            <div style="margin-left:10px;">加载中...</div>
        </Spin>
    </div>
</template>

<script>
export default {
    name:'xc-spin',
    props:{
        SpinStatus:{
            type:Boolean,
            default:true
        }
    },
    mounted(){
        let clientHeight = document.documentElement.clientHeight;
        if(document.getElementById('layout-content')){
            document.getElementById('layout-content').style.overflowY = 'hidden';
        }
        if(document.getElementsByClassName('content-box')[0]){
            document.getElementsByClassName('content-box')[0].style.height = clientHeight-64-37-16-16-39+'px';
            document.getElementsByClassName('content-box')[0].style.overflow = 'hidden';
        }
    },
    watch:{
        SpinStatus(newVal){
            if(!newVal){
                if(document.getElementsByClassName('content-box')[0]){
                    document.getElementsByClassName('content-box')[0].style.height = '100%';
                    document.getElementsByClassName('content-box')[0].style.overflow = 'visible';
                }
                if(document.getElementById('layout-content')){

                    document.getElementById('layout-content').style.overflowY = 'auto'
                }
            }
        }
    }
}
</script>

<style lang="less" scoped>

</style>
