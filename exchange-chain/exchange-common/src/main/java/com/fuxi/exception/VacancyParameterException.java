package com.fuxi.exception;

/**
 *  VacancyParameterException
 */
public class VacancyParameterException extends Exception {
    public VacancyParameterException() {
    }

    public VacancyParameterException(String message) {
        super(message);
    }

    public VacancyParameterException(Throwable cause) {
        super(cause);
    }

    public VacancyParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
