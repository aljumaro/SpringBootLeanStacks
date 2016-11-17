package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ConstraintError;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ErrorMessage;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @Date 17/11/2016
 * @Time 23:41
 * @Author Juanma
 */
public class ConstraintViolationErrorMessageFactory extends AbstractFactory<ConstraintViolationException> {

    public static final String EMPTY_STRING = "";

    @Override
    public ErrorMessage getErrorMessage(ConstraintViolationException exception, HttpServletRequest request) {
        ErrorMessage errorMessage = super.setErrorMessageBase(exception, request);
        errorMessage.setCode(EMPTY_STRING);
        errorMessage.setDescription("The request contains invalid data!");
        errorMessage.setConstraintErrors(exception
                                                 .getConstraintViolations()
                                                 .stream()
                                                 .map(v -> new ConstraintError(v.getPropertyPath().toString(), v.getMessage()))
                                                 .collect(Collectors.toList()));
        return errorMessage;
    }
}
