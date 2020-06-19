import utils from '@/utils';

export default {
    /**
     * 获取账户信息
     */
    accountInformation(formData) {
        const url = '/customer/acquire/myAccount'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 获取账户详情
     */
    accountDetail(formData) {
        const url = '/customer/acquire/transactions'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 获取账户发布记录
     */
    accountRecord(formData) {
        const url = '/customer/check/publish/record'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 账户发布记录详情
     */
    accountRecordDetail(formData) {
        const url = '/customer/check/publish/record'
        return utils.getServerData('POST',formData,url);
    },

}