package com.aljumaro.techtest.exception.base;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.aljumaro.techtest.exception.base.ExceptionResponseBuilder.TIMESTAMP;

/**
 * @Date 13/11/2016
 * @Time 12:01
 * @Author Juanma
 */
public class DefaultExceptionAttributes implements ExceptionAttributes {


    public static Map<String, Object> of(Exception exception, HttpServletRequest httpServletRequest,
                                         HttpStatus httpStatus) {
        return new DefaultExceptionAttributes().getExceptionAttributes(exception, httpServletRequest, httpStatus);
    }

    @Override
    public Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpServletRequest,
                                                      HttpStatus httpStatus) {

        return ExceptionResponseBuilder.createResponse(exception, httpServletRequest, httpStatus);
    }



}
