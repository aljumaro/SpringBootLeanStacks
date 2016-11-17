package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessageBuilder;
import com.aljumaro.techtest.domain.exception.LeanStacksException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:09
 * @Author Juanma
 */
@ControllerAdvice
public class LeanStackExceptionHandler {

    @ExceptionHandler(LeanStacksException.class)
    public ResponseEntity<ErrorMessage> handleException(LeanStacksException exception, HttpServletRequest request) {

        ErrorMessageBuilder builder = new ErrorMessageBuilder(exception.getCode(), exception.getMessage())
                .withRequest(request)
                .withException(exception);

        return new ResponseEntity<ErrorMessage>(builder.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
