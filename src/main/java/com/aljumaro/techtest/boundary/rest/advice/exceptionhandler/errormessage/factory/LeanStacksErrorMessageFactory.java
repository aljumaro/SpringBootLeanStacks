package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ErrorMessage;
import com.aljumaro.techtest.domain.exception.LeanStacksException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:44
 * @Author Juanma
 */
public class LeanStacksErrorMessageFactory extends AbstractFactory<LeanStacksException> {

    @Override
    public ErrorMessage getErrorMessage(LeanStacksException exception, HttpServletRequest request) {
        ErrorMessage errorMessage = super.setErrorMessageBase(exception, request);

        errorMessage.setCode(exception.getCode());
        errorMessage.setDescription(exception.getMessage());
        return errorMessage;
    }
}
