package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.ExceptionMessageAbstractFactory;
import com.aljumaro.techtest.domain.exception.LeanStacksException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:44
 * @Author Juanma
 */
public class LeanStacksExceptionMessageFactoryExceptionMessage extends ExceptionMessageAbstractFactory<LeanStacksException> {

    @Override
    public ExceptionMessage getErrorMessage(LeanStacksException exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = super.setErrorMessageBase(exception, request);

        exceptionMessage.setCode(exception.getCode());
        exceptionMessage.setDescription(exception.getMessage());
        return exceptionMessage;
    }
}
