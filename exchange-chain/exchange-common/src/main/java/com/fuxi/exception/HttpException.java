package com.fuxi.exception;

/**
 *  HttpException framework
 */
public class HttpException extends ServiceException {

    /**
     * http status
     */
    private int httpStatus = 500;

    @Deprecated
    public HttpException(String errorCode, String... args) {
        super(errorCode, args);
    }

    public HttpException(int httpStatus) {
        super("K-000004");
        this.httpStatus = isHttpStatusValid(httpStatus) ? httpStatus : this.httpStatus;
    }

    public HttpException(int httpStatus, String errorCode) {
        super(errorCode);
        this.httpStatus = isHttpStatusValid(httpStatus) ? httpStatus : this.httpStatus;
    }

    public HttpException(int httpStatus, String errorCode, String... args) {
        super(errorCode, args);
        this.httpStatus = isHttpStatusValid(httpStatus) ? httpStatus : this.httpStatus;
    }

    private boolean isHttpStatusValid(int httpStatus) {
        return httpStatus >= 400 && httpStatus < 600;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
