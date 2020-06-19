<template>
  <div class="process">
      <div class="step">
        <span class="step-num">1</span>
        <span class="step-text">设置账号</span>
      </div>
      <div class="step-border-box">
        <p class="step-border">
         
        </p>
      </div>
      <div class="step">
        <span class="step-num">2</span>
        <span class="step-text">实名认证</span>
      </div>
      <div class="step-border-box">
        <span class="step-border"></span>
      </div>
      <div class="step">
        <span class="step-num">3</span>
        <span class="step-text1">注册完成</span>
      </div>
  </div>
</template>

<script>
export default {
  name:'reginer-process',
  data() {
    return {
      
    }
  },
  components: {

  }
}
</script>

<style scoped lang="less">
.process{
  padding-top: 61px;
  padding-left: 59px;
  padding-right: 59px;
  // text-align: center;
  box-sizing: border-box;
  width: 100%;
  display: flex;
  justify-content: space-between;
  .step{
      display: flex;
      align-items: center;
    span{
      display: inline-block;
    }
    .step-num{
      width:15px;
      height:15px;
      font-size: 9px;
      color: white;
      text-align: center;
      line-height: 15px;
      background:rgba(0,124,250,1);
      border-radius:13px;
      margin-right: 8px;
    }
    .step-text{
      font-size:13px;
      line-height:18px;
      font-weight:400;
      color:rgba(0,0,0,1);
    }
    .step-text1{
      font-size:13px;
      line-height:18px;
      font-weight:400;
      color:rgba(0,0,0,1);
    }
  }
}
.step-border{
    width: 100%; 
    height: 1px;
    border-top: dotted #000 1.5px; /* 可设置大小，查属性参数dotted可换其他样式 */
    margin: 4px 10px; /* 用来控制文字与填充线的间隔大小 */
    display: inline-block;
}
.step-border-box{
  margin-left: -20px;
}
</style>
