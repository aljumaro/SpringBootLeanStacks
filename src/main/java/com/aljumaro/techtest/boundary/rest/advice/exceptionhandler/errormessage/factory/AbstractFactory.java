package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ErrorMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:51
 * @Author Juanma
 */
public abstract class AbstractFactory<T extends Exception> {

    protected ErrorMessage setErrorMessageBase(T exception, HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setPath(request.getServletPath());
        errorMessage.setException(exception.getClass().getSimpleName());
        return errorMessage;
    }

    public abstract ErrorMessage getErrorMessage(T exception, HttpServletRequest request);
}
