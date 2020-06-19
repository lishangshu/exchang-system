<template>
    <div class="wrapper">
        <HeaderTop></HeaderTop>
        <div class="login-wrapper">
            <div class="login-box">
                <!-- <ReginerProcess></ReginerProcess> -->
                <div class="login-content">
                    <p class="login-title">注册账号</p>
                        <Form
                            ref="RegisterForm"
                            :model="form"
                            :rules="loginRule">
                            <FormItem prop="telephone" class="login-phone">
                                <Input
                                    prefix="logo-usd"
                                    @on-enter="handleNext"
                                    class="login-input login-input-tel"
                                    v-model="form.telephone" placeholder="输入手机号"/>
                            </FormItem>
                            <FormItem prop="code">
                                <Row class="login-code-box">
                                    <Col>
                                        <Input
                                            search 
                                            ref="codeInput"
                                            @on-enter="handleNext"
                                            class="login-input login-input-code"
                                            v-model="form.code"
                                            style="width:'232px'"
                                            placeholder="输入验证码"/>
                                        <span @click.stop="getCode" class="count-down" :class="[!code.btnStatus === true ? 'form-Onlyread':'']"> {{code.btnTemplate}}</span> 
                                    </Col>
                                </Row>
                            </FormItem>
                            <div class="login-reg">
                                <span class="login-have">已有账号，</span>
                                <router-link :to="{name:'login'}">
                                     <span>立即登录</span>
                                </router-link>
                            </div>
                            <Button class="login-button login-button-sign" @click="handleNext()" :loading="loginBtnStatus"  type="primary">注册</Button>
                    </Form>
                </div>
            </div>
        </div>
  </div>
</template>
<script>
import { HeaderTop,ReginerProcess } from '@/components/index.js';
import { loginApi } from '@/api/index.js'; 
import utils from "@/utils"
export default {
    name:"register",
    components:{
        HeaderTop,
        ReginerProcess,
    },
    data(){
         //手机号验证规则
        const telephoneValidate = (rule, value, callback)=>{
            if (value === '') {
                callback(new Error('请输入手机号'));
            }else if(value.length !=11){
                callback(new Error('请输入正确的手机号'));
            }
            callback();
        };
        return{
            code:{
                btnStatus:true,
                btnTemplate:'获取短信验证码',
                downTime:60
            },
            form:{
                telephone:'',
                code:''
            },
            loginRule: {
                telephone: [
                    { validator: telephoneValidate, trigger: 'blur' },
                ],
                code: [
                    { required: true, message: '请输入验证码', trigger: 'blur' }
                ]
            },
            loginBtnStatus:false,
            token:'',
        }
    },
    methods:{
        //获取验证码
        getCode(){
            this.$refs['RegisterForm'].validateField('telephone',(res)=>{
                if(res ==''){
                    this.code.btnStatus = false
                    this.timeDown();
                    loginApi.getCode(this.form.telephone)
                    .then(res=>{
                        if(res.code == 0){
                            // this.$refs.codeInput.focus();
                        }else{
                            this.$Message.success(res.message);
                            this.code.btnStatus = true
                        }
                    }).catch(error=>{
                        this.code.btnStatus = true
                    })
                }
			})
        },
        /**
        *倒计时
        */
        timeDown(){
            let template = this.code.btnTemplate
            var authTimetimer =  setInterval(()=>{
                this.code.downTime--;
                let tempTemplate = '倒计时 '+this.code.downTime+' S'
                this.code.btnTemplate = tempTemplate
                if(this.code.downTime<=0){
                    this.token = '';
                    this.code.btnStatus = true;
                    this.code.btnTemplate = template;
                    clearInterval(authTimetimer);
                    this.code.downTime = 60;
                }
            }, 1000);
        },
        /**
         * 处理注册
         */
        handleNext(){
            this.$refs['RegisterForm'].validate((valid) => {
                 if (valid) {
                     this.loginBtnStatus= true;
                     loginApi.register(utils.handleInterface({phone:this.form.telephone,checkCode:this.form.code})).then(res=>{
                         if(res.code == 0){
                            // this.$Message.success(res.message);
                            // window.sessionStorage.setItem('level',0);
                            // this.$router.push({name:'real_name'}) 
                            utils.saveLogin(res.data.token);
                            window.sessionStorage.setItem('customerId',res.data.customerId);
                            window.sessionStorage.setItem('loginName',res.data.loginName);
                            window.sessionStorage.setItem('username',res.data.username);
                            //window.sessionStorage.setItem('level',res.data.level);
                            this.$router.push({name:'exchange'}) 
                            this.$Message.success('注册成功');
                         }else if(res.code == 500){
                            this.$Message.error(res.message)
                            this.loginBtnStatus= false;
                         }else{
                            this.$Message.error(res.message) 
                         }
			 		}).catch(err=>{
			 			this.loginBtnStatus= false;
                     })

                 }
             })
        }
    }
}
</script>
<style lang="less" scoped>
    .form-Onlyread{
        pointer-events: none;
    }
    .login-have{
        color:rgba(149,149,149,1);
    }
    .login-reg{
        width: 162px;
    }
    .register-finish{
        width:165px;
        height:33px;
        font-size:16px;
        font-weight:400;
        color:rgba(51,51,51,1);
        line-height:33px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
    }
    /deep/ .ivu-icon-ios-search:before{
        content: '';
    } 
</style>