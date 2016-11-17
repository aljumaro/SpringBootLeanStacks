package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.error;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Date 15/11/2016
 * @Time 18:31
 * @Author Juanma
 */
public class ErrorMessage {

    private String code;
    private String description;
    private String path;
    private String exception;
    private Date timestamp;
    private List<ConstraintError> constraintErrors;

    protected ErrorMessage() {
        this.timestamp = Calendar.getInstance().getTime();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<ConstraintError> getConstraintErrors() {
        return constraintErrors;
    }

    public void setConstraintErrors(
            List<ConstraintError> constraintErrors) {
        this.constraintErrors = constraintErrors;
    }
}
