package com.aljumaro.techtest.domain.exception;

/**
 * @Date 15/11/2016
 * @Time 18:49
 * @Author Juanma
 */
public class LeanStacksException extends RuntimeException {

    private String code;
    private String message;

    public LeanStacksException(String message) {
        this.code = ErrorCodes.GENERIC.getCode();
        this.message = message;
    }

    public LeanStacksException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
