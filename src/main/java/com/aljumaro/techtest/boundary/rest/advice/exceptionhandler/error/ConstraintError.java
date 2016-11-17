package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error;

public class ConstraintError {
    private String propertyPath;
    private String message;

    public ConstraintError(String propertyPath, String message) {
        this.propertyPath = propertyPath;
        this.message = message;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}