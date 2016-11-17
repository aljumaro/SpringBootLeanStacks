package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.AbstractFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:38
 * @Author Juanma
 */
public class ExceptionMessageFactory extends AbstractFactory<Exception> {

    @Override
    public ExceptionMessage getErrorMessage(Exception exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = super.setErrorMessageBase(exception, request);

        exceptionMessage.setCode("-1");
        exceptionMessage.setDescription(exception.getLocalizedMessage());
        return exceptionMessage;
    }
}
