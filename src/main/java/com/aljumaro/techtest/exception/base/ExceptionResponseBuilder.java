package com.aljumaro.techtest.exception.base;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date 13/11/2016
 * @Time 12:38
 * @Author Juanma
 */
public class ExceptionResponseBuilder {

    public static final String TIMESTAMP = "timestamp";
    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String EXCEPTION = "exception";
    public static final String MESSAGE = "message";
    public static final String PATH = "path";

    public static Map<String, Object> createResponse(Exception exception, HttpServletRequest httpServletRequest,
                                                     HttpStatus httpStatus) {

        Map<String, Object> result = new LinkedHashMap<>();

        result.put(TIMESTAMP, new Date());

        addHttpStatus(result, httpStatus);
        addExceptionDetail(result, exception);
        addPath(result, httpServletRequest);

        return result;
    }

    private static void addHttpStatus(Map<String, Object> exceptionAttributes, HttpStatus httpStatus) {
        exceptionAttributes.put(STATUS, httpStatus.value());
        exceptionAttributes.put(ERROR, httpStatus.getReasonPhrase());
    }

    private static void addExceptionDetail(Map<String, Object> exceptionAttributes, Exception exception) {
        exceptionAttributes.put(EXCEPTION, exception.getClass().getName());
        exceptionAttributes.put(MESSAGE, exception.getMessage());
    }

    private static void addPath(Map<String, Object> exceptionAttributes, HttpServletRequest httpServletRequest) {
        exceptionAttributes.put(PATH, httpServletRequest.getServletPath());
    }
}
