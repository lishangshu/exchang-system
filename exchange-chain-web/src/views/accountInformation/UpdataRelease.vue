<template>
    <div class="all-content">
        <HeaderTopUser></HeaderTopUser>
         <Form ref="formValidate" class="add-message" span="5" :model="formValidate" :rules=" formAddRule" :label-width="160">
            <div class="add-wrapper">
                <!-- 域名信息 -->
                <div class="add-box">
                    <div class="add-title">
                        <span>域名信息</span>
                    </div>
                    <div class="add-box-form">
                         <Row>
                            <Col span="15">
                                <FormItem label="域名：" prop="domain" class="add-form-content">
                                    <Input type="text" size="large" v-model="formValidate.domain" placeholder="请输入域名" ></Input>
                                </FormItem>
                            </Col> 
                        </Row>
                     
                        <Row>
                            <Col span="15">
                                <FormItem prop="dnsParseRecord" class="add-form-content">
                                    <span slot="label">解析记录
                                        <Poptip trigger="hover" word-wrap style=" display: inline-block;">
                                            <p slot="content" style="text-algin:'center'">1.A记录，12.12.12.12</br>2.CNAME，http://www.baidu.com</p>
                                            <Icon type="md-information-circle" size="20" />
                                        </Poptip>
                                    </span>
                                    <Input :rows="4" size="large" type="textarea" v-model="formValidate.dnsParseRecord" placeholder="请输入解析记录"></Input>
                                </FormItem>
                            </Col>
                            <!-- <Col span="17">
                                <FormItem label="解析记录：" class="add-form-content">
                                    <FormItem   
                                    class="city-form"
                                        style="margin-bottom:10px;"
                                        v-for="(item,index) in formValidate.dnsParseRecord" :key="index"
                                        :prop="'dnsParseRecord.' + index + '.value'"
                                        :rules="{required: true, message: '不能为空', trigger: 'blur'}"
                                        >
                                        <Row class="for-item" size="large">
                                            <Col span="19">
                                                <Input size="large" type="text" v-model="item.value" placeholder="请输入解析记录"></Input>
                                            </Col>
                                            <Col span="3" offset="1" v-if="formValidate.dnsParseRecord.length != 1">
                                                <Button size="large" @click="handleRemove(index)">删除</Button>
                                            </Col>
                                        </Row>
                                    </FormItem>
                                   
                                     <Row class="add-form-content">
                                        <Col span="9">
                                            <Button size="large" type="dashed" long @click="handleAdd" icon="md-add">新增</Button>
                                        </Col>
                                    </Row>
                                </FormItem>
                            </Col> -->
                        </Row>
                    </div>
                </div>
                <!-- 域名注册信息 -->
                <div class="add-box">
                    <div class="add-title">
                        <span>域名注册信息</span>
                    </div>
                    <div class="add-box-form">
                         <Row>
                            <Col span="15">
                                <FormItem label="域名持有者名称：" class="add-form-content">
                                    <Input type="text" size="large" v-model="formValidate.owner" placeholder="请输入域名持有者名称" ></Input>
                                </FormItem>
                            </Col> 
                        </Row>
                        <Row>
                            <Col span="15" class="place-holder">
                               <FormItem label="所属区域：" class="add-form-content city-form">
                                    <Cascader @on-change="handleCity" :placeholder="this.formValidate.position"  :transfer="transferPosition" v-model="areaArr" :data="areaData" size="large"></Cascader>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                <FormItem label="通讯地址：" class="add-form-content"> 
                                    <Input type="text" size="large" v-model="formValidate.mailAddress" placeholder="请输入通讯地址"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                <FormItem label="邮编：" class="add-form-content">
                                    <Input type="text" size="large" v-model="formValidate.maillNo" placeholder="请输入邮编"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                 <FormItem label="联系电话：" class="add-form-content">
                                    <Input type="number" size="large" v-model="formValidate.contactPhone" placeholder="请输入固定电话或手机号码:"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                <FormItem label="电子邮箱" class="add-form-content">
                                    <Input type="text" size="large" v-model="formValidate.email" placeholder="电子邮箱"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                    </div>
                </div>

                <!-- 域名注册信息 -->
                <div class="add-box">
                    <div class="add-title">
                        <span>域名信息</span>
                    </div>
                    <div class="add-box-form">
                         <Row>
                            <Col span="15">
                                <FormItem label="注册商：" class="add-form-content">
                                    <Input type="text" size="large" v-model="formValidate.wiSupport" placeholder="请输入注册商" ></Input>
                                </FormItem>
                            </Col> 
                        </Row>
                        <Row>
                            <Col span="8">
                                <FormItem 
                                    class="add-form-content city-form"
                                    label="创建时间：" 
                                   >
                                    <DatePicker 
                                        :transfer="transferPosition"
                                        :value="formValidate.wiCreateTime"
                                        @on-change="handleCreatedTime"
                                        editable 
                                        size="large"
                                        style="width: 300px"
                                        type="date" 
                                        placeholder="创建时间：">
                                    </DatePicker>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="5">
                                <FormItem 
                                    class="add-form-content city-form"
                                    label="过期时间：" 
                                   >
                                    <DatePicker 
                                        size="large"
                                        :transfer="transferPosition"
                                        :value="formValidate.wiExpirationTime"
                                        @on-change="handleMissTime"
                                        editable 
                                        style="width: 300px"
                                        type="date" 
                                        placeholder="过期时间：">
                                    </DatePicker>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                <FormItem class="add-form-content" label="域名服务器：">
                                    <Input type="number" size="large" v-model="formValidate.wiServerIp" placeholder="请输入域名服务器："></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="15">
                                <FormItem class="add-form-content" label="DNS：">
                                    <Input type="textarea" :rows="4" size="large" v-model="formValidate.wiDns" placeholder="请输入DNS："></Input>
                                </FormItem>
                            </Col>
                        </Row>
                    </div>
                </div>
            </div>
         </Form>
        <div class="bottom-btn">
            <Button style="margin-right:20px" size="large" class="login-button data-btn" @click="handleCancel()">取消</Button>
            <Button type="primary" size="large" class="login-button data-btn" @click="handleSubmit()">保存</Button>
        </div>
    </div>
</template>

<script>
import { HeaderTopUser,Card} from '@/components/index.js';
import { AddExchangeData } from '@/validateRule/index.js';
import  cityData  from '@/utils/city.js';
import utils from '@/utils'
import { exchangeApi } from '@/api/index.js';

export default {
    name:"updata-release",
    components:{
        HeaderTopUser,
        Card,
    },
    props:{

    },
    data(){
        return{
            formAddRule:AddExchangeData,
            formValidate:{
                domain:'',
                dnsParseRecord:'',
                email:'',
                owner:'',
                position:'',
                mailAddress:'',
                maillNo:'',
                contactPhone:'',
                wiSupport:'',
                wiCreateTime:'',
                wiExpirationTime:'',
                wiServerIp:'',
                wiDns:''
            },
            transferPosition:true,
            areaData: [],
            areaArr:[],
        }
    },
    mounted(){
        //省市区赋值
        this.areaData = cityData.cityArr
        let value = sessionStorage.getItem('record_updata');
        this.formValidate = JSON.parse(value);

    },
    
    methods:{
        handleCancel(){
            this.$router.go(-1)
        },
        //解析记录新增
        // handleAdd () {
        //     this.formValidate.dnsParseRecord.push({
        //         value: '',
        //     });
        // },
        //解析记录移除
        // handleRemove (index) {
        //     this.formValidate.dnsParseRecord.splice(index, 1)
        //     console.log(this.formValidate)
        // },
        handleCreatedTime(time){
            this.formValidate.wiCreateTime = time;
        },
        handleMissTime(time){
            this.formValidate.wiExpirationTime = time;
        },
        //省市区下拉
        handleCity(value, selectedData){
            this.formValidate.position = ''
            if(selectedData.length != 0){
                let arr = []
                arr.push(selectedData[0].label)
                arr.push(selectedData[1].label)
                arr.push(selectedData[2].label)
                this.areaArr = arr
                this.formValidate.position = arr.join("-")
            } 
        },
        //提交
        handleSubmit(){
            this.$refs['formValidate'].validate((valid) => {
                if (valid) {
                    exchangeApi.exchangeAdd(utils.handleInterface(this.formValidate)).then(res=>{
                    if(res.code == 0){
                        this.$Message.success('修改成功');
                        this.$router.push({path:'release_record'}) 
                    }
                    }).catch(err=>{
                        console.log(err)
                    })
                }
            })
        }
    }
}
</script>
<style lang="less" scoped>

  /deep/ .ivu-form .ivu-form-item-label{
    font-size:16px!important;
    font-weight:400;
    text-align: left;
  }
  .add-wrapper{
      margin: 0 8%;
      .add-box{
            box-shadow:0px 3px 34px 0px rgba(0,5,46,0.07);
            border-radius:8px;
            overflow: hidden;
            margin: 50px 0;
        .add-title{
            height:80px;
            background:rgba(244,245,252,1);
            border-radius:8px 8px 0px 0px;
            line-height: 80px;
            padding: 0 8%;
        }
        .add-title span{
            display: inline-block;
            font-size:17px;
            font-family:PingFangSC-Medium,PingFang SC;
            font-weight:500;
            color:rgba(0,0,0,1);
        }
        .add-box-form{
            padding: 0 8%;
            padding-bottom: 20px;
            .add-form-content{
                margin: 16px 0;
            }
        }
      }
  }
    /deep/ .ivu-input-wrapper{
        min-width: 509px;
    }
    .city-form /deep/ .ivu-input-wrapper{
        min-width: 0;
    }
    .for-item{
        margin-bottom: 16px;
    }
    .place-holder /deep/ .ivu-input::-webkit-input-placeholder{
        color:#515a6e;
    }
    .place-holder /deep/ .ivu-input::-moz-placeholder{   /* Mozilla Firefox 19+ */
        color:#515a6e;
    }
    .place-holder /deep/ .ivu-input::-moz-placeholder{    /* Mozilla Firefox 4 to 18 */
        color:#515a6e;
    }
    .place-holder /deep/ .ivu-input::-ms-input-placeholder{  /* Internet Explorer 10-11 */
        color:#515a6e;
    }
    .bottom-btn{
        height: 80px;
        bottom: 0;
        text-align: right;
        position: fixed;
        line-height: 80px;
        padding-right: 8%;
        width: 100%;
        background: white;
        z-index: 999;
    }
    .add-message{
        margin-bottom: 100px;
    }
</style>