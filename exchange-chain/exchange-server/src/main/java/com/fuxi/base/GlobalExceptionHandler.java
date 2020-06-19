package com.fuxi.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.multipart.MultipartException;
//import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public BaseResponse signatureExceptionHandler(HttpServletRequest request, SignatureException ex) {
//        logger.error("do [{}] on [{}] failed. exMsg:{}", request.getMethod(), request.getRequestURL(),
//                ex.getLocalizedMessage());
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//
//        return new BaseResponse(ResultCode.FAILED, ex.getLocalizedMessage());
//    }
//
//    @ExceptionHandler(value = MultipartException.class)
//    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
//    @ResponseBody
//    public BaseResponse serviceExceptionHandler(HttpServletRequest request, MultipartException ex) throws Exception{
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//        return new BaseResponse("K-010201", "文件大小超过4M");
//    }
//
//    @ExceptionHandler(value = ServiceException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public BaseResponse serviceExceptionHandler(HttpServletRequest request, ServiceException ex) throws Exception {
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
//            throw ex;
//
//        logger.error("do [{}] on [{}] failed. exMsg:{}", request.getMethod(), request.getRequestURL(),
//                ex.getLocalizedMessage());
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//
//        return new BaseResponse(ex.getErrorCode(), ex.getLocalizedMessage());
//    }
//
//    @ExceptionHandler(value = ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public BaseResponse serviceExceptionHandler(HttpServletRequest request, ResourceNotFoundException ex) throws
//            Exception {
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
//            throw ex;
//
//        logger.error("do [{}] on [{}] failed. exMsg:{}", request.getMethod(), request.getRequestURL(),
//                ex.getLocalizedMessage());
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//
//        return new BaseResponse(ex.getErrorCode(), ex.getLocalizedMessage());
//    }
//
//    @ExceptionHandler(value = HttpException.class)
//    public ResponseEntity<BaseResponse> generalHttpExceptionHandler(HttpServletRequest request, HttpException ex)
//            throws Exception {
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
//            throw ex;
//
//        logger.error("do [{}] on [{}] failed. exMsg:{}", request.getMethod(), request.getRequestURL(),
//                ex.getLocalizedMessage());
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//
//        return ResponseEntity.status(HttpStatus.valueOf(ex.getHttpStatus())).body(new BaseResponse(ResultCode.FAILED,
//                ex.getLocalizedMessage()));
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public BaseResponse defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
//        // If the exception is annotated with @ResponseStatus rethrow it and let
//        // the framework handle it - like the OrderNotFoundException example
//        // at the start of this post.
//        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
//            throw ex;
//
//        logger.error("do [{}] on [{}] failed. exMsg:{}", request.getMethod(), request.getRequestURL(),
//                ex.getLocalizedMessage());
//        if (logger.isDebugEnabled()) {
//            logger.error("queryString:{}, parameterMap: {}", request.getQueryString(), Utils.getRequestParameterMapAsString(request), ex);
//        }
//
//        return new BaseResponse(ResultCode.FAILED, ex.getLocalizedMessage());
//    }



}
