<template>
  <div class="router-view">
      <router-view/>
  </div>
</template>

<script>
export default {
    data(){
      return{
        
      }
    },
      created(){
        if(document.getElementById('layout-content')){
            document.getElementById('layout-content').style.overflowY = 'auto'
        }
    }
}
</script>

<style lang="less" scoped>
.router-view{
  height: 100%;
  min-height:600px;
}
</style>

