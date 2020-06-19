package com.fuxi.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.i18n.LocaleContextHolder;
import com.fuxi.utils.MessageSourceUtil;

import java.io.Serializable;

/**
 *  Response
 */
@Data
@AllArgsConstructor
public class BaseResponse implements Serializable {

    public static BaseResponse SUCCESSFUL() {
        return new BaseResponse(ResultCode.SUCCESSFUL);
    }

    public static BaseResponse FAILED() {
        return new BaseResponse(ResultCode.FAILED);
    }

    public BaseResponse(String code){
        this.code = code;
        this.message = MessageSourceUtil.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     * 结果码
     */
    private String code;

    /**
     * 消息内容
     */
    private String message;
}
