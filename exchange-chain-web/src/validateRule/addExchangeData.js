const rule = {
    domain: [{
        type: 'string',
        required: true,
        message: '请输入域名',
        trigger: 'change'
    }],
    dnsParseRecord: [{
        type: 'string',
        required: true,
        message: '请输入解析记录',
        trigger: 'change'
    }],
}
  
export default rule;
  