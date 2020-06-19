package com.fuxi.interceptor;
import com.alibaba.fastjson.JSON;
import com.fuxi.annotation.LoginRequired;
import com.fuxi.constant.CodeConst;
import com.fuxi.constant.CommonConst;
import com.fuxi.dto.DataTransferObject;
import com.fuxi.dto.DtoUtil;
import com.fuxi.dto.MessageResult;
import com.fuxi.dto.ResultDto;
import com.fuxi.enums.Prefix;
import com.fuxi.utils.CookieUtil;
import com.fuxi.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: chenghaiming
 * @Date:2018/8/11
 * @Description：
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{

    protected static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("开始执行拦截==>>>>>>>>>>>>>>>>>>>>>>>>>>");

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

         HandlerMethod handlerMethod = (HandlerMethod) handler;
        String tokenVal = CookieUtil.getAuthToken(request,"x-auth-token");
        logger.info("tokenVal:【{}】",tokenVal);
        String token = Prefix.PREFIX_USER_LOGIN.code + tokenVal;
        logger.info("token:【{}】",token);
        String returnUrl = URLDecoder.decode(getReturnUrl(request));
        logger.info("接口地址:【{}】",returnUrl);
        String ipAddress = CookieUtil.getIpAddress(request);
        logger.info("访问IP-->【{}】",ipAddress);
        LoginRequired loginRequired = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (loginRequired != null) {
            Object tokenValue = redisUtil.get(token);
            logger.info("此接口登录后方可访问");
            if (tokenValue != null) {
                logger.info("重置token【{}】有效期！",tokenValue);
                redisUtil.set(token, tokenValue, CommonConst.CUSTOMER_TOKEN_DEADLINE);
            } else {
                logger.info("登录失效......");

                print(response,MessageResult.error(Integer.valueOf(CodeConst.LOGIN_NOT_LOGIN),"未登录"));
                return false;
            }
        }
        logger.info("拦截校验结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<==");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        other ...
    }

    private String getReturnUrl(HttpServletRequest request)
            throws UnsupportedEncodingException {
        String returnUrl = "";
        if (request != null) {
            returnUrl = request.getRequestURL().toString();
            if (request.getQueryString() != null) {
                returnUrl = returnUrl + "?" + request.getQueryString();
            }
            if (returnUrl != null) {
                returnUrl = URLEncoder.encode(returnUrl, "UTF-8");
            }
        }
        return returnUrl;
    }

    private void print(HttpServletResponse response, MessageResult resultDto) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSON.toJSON(resultDto).toString());
    }


}