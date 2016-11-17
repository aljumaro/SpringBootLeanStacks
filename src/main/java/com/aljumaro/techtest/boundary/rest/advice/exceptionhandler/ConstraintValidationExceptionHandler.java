package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ConstraintError;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error.ErrorMessageBuilder;
import com.aljumaro.techtest.domain.exception.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 17/11/2016
 * @Time 23:04
 * @Author Juanma
 */
@ControllerAdvice
public class ConstraintValidationExceptionHandler {

    protected final Logger _log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleException(ConstraintViolationException exception,
                                                        HttpServletRequest request) {

        ErrorMessageBuilder builder = new ErrorMessageBuilder(ErrorCodes.GENERIC.getCode(), "The request contains invalid data!")
                .withRequest(request).withException(exception);

        return new ResponseEntity<ErrorMessage>(builder.build(), HttpStatus.BAD_REQUEST);
    }
}
