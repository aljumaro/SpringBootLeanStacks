package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessageBuilder;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Date 17/11/2016
 * @Time 23:12
 * @Author Juanma
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private static final String DEFAULT_ERROR_CODE = "-1";
    protected final Logger _log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception, HttpServletRequest request) {

        _log.error("Handling exception {} with default exception handler", exception.getClass().getName());

        ErrorMessageBuilder builder = new ErrorMessageBuilder(DEFAULT_ERROR_CODE, exception.getLocalizedMessage())
                .withRequest(request)
                .withException(exception);

        return new ResponseEntity<ErrorMessage>(builder.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
