package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:51
 * @Author Juanma
 */
public abstract class AbstractFactory<T extends Exception> {

    protected ExceptionMessage setErrorMessageBase(T exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setPath(request.getServletPath());
        exceptionMessage.setException(exception.getClass().getSimpleName());
        return exceptionMessage;
    }

    public abstract ExceptionMessage getErrorMessage(T exception, HttpServletRequest request);
}
