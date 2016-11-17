package com.aljumaro.techtest.domain.exception;

/**
 * @Date 15/11/2016
 * @Time 18:46
 * @Author Juanma
 */
public enum ErrorCodes {
    GENERIC("100"),

    GREETING_VALIDATION_NOT_FOUND("201"),
    GREETING_VALIDATION_ID_FOUND("202");

    private String code;

    ErrorCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
