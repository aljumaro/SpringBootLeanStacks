package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ErrorMessage;

import javax.servlet.http.HttpServletRequest;

import static javafx.scene.input.KeyCode.T;

/**
 * @Date 17/11/2016
 * @Time 23:38
 * @Author Juanma
 */
public class ErrorMessageFactory extends AbstractFactory<Exception> {

    @Override
    public ErrorMessage getErrorMessage(Exception exception, HttpServletRequest request) {
        ErrorMessage errorMessage = super.setErrorMessageBase(exception, request);

        errorMessage.setCode("-1");
        errorMessage.setDescription(exception.getLocalizedMessage());
        return errorMessage;
    }
}
