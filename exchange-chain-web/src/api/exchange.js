import utils from '@/utils';

export default {
    /**
     * 发布数据
     */
    exchangeAdd(formData) {
        const url = 'auth/code'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 搜索列表
     */
    exchangeSearchList(formData) {
        const url = 'exchange/search/domains'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 已购买积分详情
     */
    exchangeDetail(formData) {
        const url = 'exchange/view/domain/details'
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 没购买积分详情
     */
    exchangeNoDetail(formData) {
        const url = `/exchange/get/sketchById`
        return utils.getServerData('POST',formData,url);
    },
    /**
     * 数据上传
     */
    exchangeAdd(formData) {
        const url = 'exchange/data/up2/chain'
        return utils.getServerData('POST',formData,url);
    }, 
}