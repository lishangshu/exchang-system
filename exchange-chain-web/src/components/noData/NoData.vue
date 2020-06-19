<template>
    <div class="no-data">
        <div class="no-data-warning">
            <img :src="bacData" alt="">
            <div class="no-data-text">暂无数据</div>
        </div>
    </div>
</template>
<script>
    import bacData from '@/assets/images/no-data@2x.png';
    export default {
        name:'',
        data(){
            return{
                bacData
            }
    },

    }
</script>
<style lang="less" scoped>
@import './noData.less';
</style>
