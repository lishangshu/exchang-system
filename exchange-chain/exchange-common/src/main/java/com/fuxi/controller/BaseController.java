package com.fuxi.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fuxi.annotation.NotNull;
import com.fuxi.dto.MessageResult;
import com.fuxi.exception.VacancyParameterException;
import com.fuxi.utils.RequestUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class BaseController {
    private static Log log = LogFactory.getLog(BaseController.class);

    protected MessageResult success() {
        return new MessageResult(0, "SUCCESS");
    }

    protected MessageResult success(String msg) {
        return new MessageResult(0, msg);
    }

    protected MessageResult success(String msg, Object obj) {
        MessageResult mr = new MessageResult(0, msg);
        mr.setData(obj);
        return mr;
    }

    protected MessageResult success(Object obj) {
        MessageResult mr = new MessageResult(0, "SUCCESS");
        mr.setData(obj);
        return mr;
    }

    protected MessageResult error(String msg) {
        return new MessageResult(500, msg);
    }

    protected MessageResult error(int code, String msg) {
        return new MessageResult(code, msg);
    }


    /**
     * 获取request请求参数
     *
     * @param name 参数名称
     * @return
     */
    protected String request(HttpServletRequest request, String name) {
        return StringUtils.trimToEmpty(request.getParameter(name));
    }

    public String getRemoteIp(HttpServletRequest request) {
        return RequestUtil.remoteIp(request);
    }

    /**
     * 判断是否是手机浏览器
     *
     * @return
     */
    public boolean isMobile(HttpServletRequest request) {
        boolean isMobile = false;
        String[] mobileAgents = {"iphone", "android", "phone", "ipad", "mobile", "wap", "netfront", "java",
                "opera mobi", "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry",
                "dopod", "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola",
                "foma", "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad",
                "webos", "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips",
                "sagem", "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tsm-", "upg1", "upsi", "vk-v", "voda",
                "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile"};
        // 根据cookie选择模板，暂时未用
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().toUpperCase().equals("SPARK_THEME")) {
                    log.info("SPAKR_THEME:" + cookie.getValue());
                    isMobile = cookie.getValue().equals("WAP");
                    break;
                }
            }
        }
        // 根据userAgent自动选择
        String userAgent = request.getHeader("User-Agent").toLowerCase();
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (userAgent.indexOf(mobileAgent) >= 0) {
                    log.info("User-Agent HIT:" + mobileAgent);
                    isMobile = true;
                    break;
                }
            }
        }
        return isMobile;
    }


    protected JSONObject optParamBody(String params) {
        log.info(params);
        JSONObject str = JSONObject.parseObject(params);
        return JSON.parseObject(str.getString("body"));
    }

    protected JSONObject optParamHead(String params) {
        log.info(params);
        JSONObject str = JSONObject.parseObject(params);
        return JSON.parseObject(str.getString("head"));
    }

    protected JSONObject optParam(String params) {
        log.info(params);
        return JSONObject.parseObject(params);
    }

    protected boolean validateParams(JSONObject bodyStr, String className) throws Exception {
        Field[] fields = Class.forName(className).getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (containsAnnotation(annotations, NotNull.class.getTypeName())) {
                NotNull declaredAnnotation = field.getDeclaredAnnotation(NotNull.class);
                Object paramValue = bodyStr.get(field.getName());
                if (null == paramValue || org.apache.commons.lang3.StringUtils.isEmpty(String.valueOf(paramValue))) {
                    throw new VacancyParameterException(declaredAnnotation.value());
                }
            }
        }
        return true;
    }

    protected boolean containsAnnotation(Annotation[] annotations, String canonicalName) {
        for (Annotation anno : annotations) {
            if (anno.annotationType().getTypeName().equals(canonicalName))
                return true;
        }
        return false;
    }
}
