package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 15/11/2016
 * @Time 18:31
 * @Author Juanma
 */
public class ErrorMessageBuilder {

    private String code;
    private String description;
    private String path;
    private String exception;
    private List<ConstraintError> constraintErrors = new ArrayList<>();

    public ErrorMessageBuilder(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ErrorMessage build() {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(code);
        errorMessage.setDescription(description);
        errorMessage.setPath(path);
        errorMessage.setException(exception);
        errorMessage.setConstraintErrors(constraintErrors);
        return errorMessage;
    }

    public ErrorMessageBuilder withRequest(HttpServletRequest request) {
        withPath(request.getServletPath());
        return this;
    }

    public ErrorMessageBuilder withException(Throwable throwable) {
        withException(throwable.getClass().getSimpleName());
        if (throwable instanceof ConstraintViolationException) {
            withConstraintErrors(((ConstraintViolationException) throwable));
        }
        return this;
    }

    public ErrorMessageBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public ErrorMessageBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ErrorMessageBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public ErrorMessageBuilder withException(String exception) {
        this.exception = exception;
        return this;
    }

    private ErrorMessageBuilder withConstraintErrors(ConstraintViolationException exception) {

        this.constraintErrors = exception
                .getConstraintViolations()
                .stream()
                .map(v -> new ConstraintError(v.getPropertyPath().toString(), v.getMessage()))
                .collect(Collectors.toList());

        return this;

    }
}
