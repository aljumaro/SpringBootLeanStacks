package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ConstraintExceptionProperty;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.AbstractFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @Date 17/11/2016
 * @Time 23:41
 * @Author Juanma
 */
public class ConstraintViolationExceptionMessageFactory extends AbstractFactory<ConstraintViolationException> {

    public static final String EMPTY_STRING = "";

    @Override
    public ExceptionMessage getErrorMessage(ConstraintViolationException exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = super.setErrorMessageBase(exception, request);
        exceptionMessage.setCode(EMPTY_STRING);
        exceptionMessage.setDescription("The request contains invalid data!");
        exceptionMessage.setConstraintExceptionProperties(exception
                                                 .getConstraintViolations()
                                                 .stream()
                                                 .map(v -> new ConstraintExceptionProperty(v.getPropertyPath().toString(), v.getMessage()))
                                                 .collect(Collectors.toList()));
        return exceptionMessage;
    }
}
