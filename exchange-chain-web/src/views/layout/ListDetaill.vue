<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
        <ListDetaillist></ListDetaillist>
    </div>
    
</template>

<script>
import { HeaderTopUser } from '@/components/index.js';
import ListDetaillist from './business/ListDetaillist'
export default {
    name:"list-detail",
    components:{
        HeaderTopUser,
        ListDetaillist
    },
    data(){
        return{

        }
    },
    created(){
   
    },
    methods:{
        handleSearch(){
           
        }
    }
}
</script>
<style lang="less" scoped>

</style>