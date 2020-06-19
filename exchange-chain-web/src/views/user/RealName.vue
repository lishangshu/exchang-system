<template>
        <div class="wrapper">
        <HeaderTop></HeaderTop>
        <div class="login-wrapper">
            <div class="login-box">
                <ReginerProcess></ReginerProcess>
                <div class="login-content" v-if="!isFinishRegister">
                    <p class="login-title">实名认证</p>
                        <Form
                            ref="realNameForm"
                            :rules="realNameRule"
                            :model="realForm"
                        >
                            <FormItem class="add-form-content" prop="realName">
                                <Input type="text" size="large" v-model="realForm.realName" placeholder="请输入姓名" ></Input>
                            </FormItem>
                            <FormItem class="add-form-content" prop="IdCard">
                                <Input type="text" size="large" v-model="realForm.IdCard" placeholder="请输入身份证号" ></Input>
                            </FormItem>
                            <Button class="login-button login-button-sign" @click="handleRealName()" :loading="loginBtnStatus"  type="primary">下一步</Button>
                    </Form>
                </div>
                <div v-if="isFinishRegister" class="register-finish">
                    <span>已完成注册,请前往</span>
                    <router-link :to="{name:'login'}">
                        <span>登录</span>
                    </router-link>
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
    name:"real-name",
    components:{
        HeaderTop,
        ReginerProcess,
    },
    data(){
        //身份证号验证规则
        const IdCardValidate = (rule, value, callback)=>{
            if (value === '') {
                callback(new Error('请输入身份证号'));
            }else if(value.length !=18){
                callback(new Error('请输入正确的身份证号'));
            }
            callback();
        };
        return{
            isFinishRegister:false,
            realForm:{
                realName :'',
                IdCard :''
            },
            realNameRule: {
                realName: [
                    { required: true, message: '请输入真实姓名', trigger: 'blur' }
                ],
                IdCard: [
                    { validator: IdCardValidate, trigger: 'blur' },
                ]
            },
            loginBtnStatus:false,
        }
    },
    created(){
   
    },
    methods:{
        handleRealName(){
            this.$refs['realNameForm'].validate((valid) => {
                if (valid) {
                    loginApi.realName(utils.handleInterface({realName:this.realForm.realName,IdCard:this.realForm.IdCard})).then(res=>{
                        if(res.code == 0 && res.message == 'SUCCESS'){
                            window.sessionStorage.setItem('level',1);
                            this.$router.push({name:'exchange'}) 
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
</style>