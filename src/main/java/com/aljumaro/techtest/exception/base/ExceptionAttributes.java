package com.aljumaro.techtest.exception.base;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Date 13/11/2016
 * @Time 11:59
 * @Author Juanma
 */
public interface ExceptionAttributes {

    Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpServletRequest, HttpStatus httpStatus);
}
