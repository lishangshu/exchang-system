import utils from '@/utils';

export default {
    /**
     * 获取短信验证码
     */
    getCode(formData) {
        const url = `mobile/send/code?phone=${formData}`
        return utils.getServerData('POST',{},url);
    },
    /**
     * 登陆
     */
    login(formData) {
        const url = 'customer/login/phone'
        return utils.getServerData('POST',formData,url);
    },
    /*
    注册
    */
    register(formData){
        const url = 'customer/register/phone'
        return utils.getServerData('POST',formData,url);
    },
    /*
    注册
    */
   realName(formData){
    const url = 'customer/realname/auth'
    return utils.getServerData('POST',formData,url);
}


    
}