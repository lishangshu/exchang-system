package com.fuxi.exception;

import com.fuxi.dto.MessageResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhang Jinwei
 * @date 2017年12月23日
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * IllegalArgumentException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public MessageResult myErrorHandler(IllegalArgumentException e) {
        MessageResult result = MessageResult.error(e.getMessage());
        return result;
    }

    /**
     * ServletRequestBindingException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ServletRequestBindingException.class)
    public MessageResult myErrorHandler(ServletRequestBindingException e) {
        MessageResult result = MessageResult.error(3000, "参数绑定错误(如:必须参数没传递)!");
        return result;
    }


    /**
     * myErrorHandler
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public MessageResult myErrorHandler(Exception ex) {
        ex.printStackTrace();
        MessageResult result = MessageResult.error("'未知错误");
        return result;
    }

    /**
     * @param
     * @return
     * @author rongyu
     * @description   HttpRequestMethodNotSupportedException
     * @date 2018/2/28 17:32
     */
    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public MessageResult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        String methods = "";
        //支持的请求方式
        String[] supportedMethods = ex.getSupportedMethods();
        for (String method : supportedMethods) {
            methods += method;
        }
        MessageResult result = MessageResult.error("Request method " + ex.getMethod() + "  not supported !" +
                " supported method : " + methods + "!");
        return result;
    }
}
