import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fuxi.dto.MessageResult;
import com.fuxi.utils.HashUtils;
import com.fuxi.utils.Sha256Util;
import com.fuxi.utils.ValidateUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 10:16
 * @Description:
 */
@Slf4j
public class MessageTest {

    public String gateway = "http://smssh1.253.com/msg/send/json";
    public String username = "YZM0233434";
    public String password = "Rhg1E7Wcxa2793";
    public String sign = "互联网数据交换平台";

    public String mobile = "18612414128";

    public String content = String.format("您的短信验证码：%s，请在5分钟之内完成操作，如非本人操作，请忽略", "23545");

    @Test
    public void sendMsg() throws UnirestException {

        //请求地址
        String url = this.gateway;
        //API账号，50位以内。必填
        String account = this.username;
        //API账号对应密钥，联系客服获取。必填
        String password = this.password;
        //短信内容。长度不能超过536个字符。必填
        String msg = "【" + this.sign + "】" + content;
        //组装请求参数
        JSONObject map = new JSONObject();
        map.put("account", account);
        map.put("password", password);
        map.put("msg", msg);
        map.put("phone", mobile);
        String params = map.toString();
        log.info("请求参数为:" + params);
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(params)
                .asString();
        log.info("返回参数为:" + response);
        JSONObject jsonObject = JSON.parseObject(response.getBody());
        String code = jsonObject.get("code").toString();
        String msgid = jsonObject.get("msgId").toString();
        String error = jsonObject.get("errorMsg").toString();
        log.info("状态码:" + code + ",状态码说明:" + error + ",消息id:" + msgid);
        MessageResult messageResult = parseResult(jsonObject);
        System.out.println(messageResult);
    }

    private MessageResult parseResult(JSONObject jsonObject) {
        MessageResult mr = new MessageResult(500, "系统错误");
        mr.setCode(Integer.parseInt(jsonObject.getString("code")));
        if (mr.getCode() == 0) {
            mr.setMessage("操作成功");
        }
        return mr;
    }

    @Test
    public void  mapTest(){
        String phone = "18525446225";
        boolean mobilePhone = ValidateUtil.isMobilePhone(phone);
        System.out.println(mobilePhone);
    }

}
