package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 17/11/2016
 * @Time 23:51
 * @Author Juanma
 */
public abstract class ExceptionMessageAbstractFactory<T extends Exception> {

    protected ExceptionMessage setErrorMessageBase(T exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setPath(request.getRequestURL().toString());
        exceptionMessage.setException(exception.getClass().getSimpleName());
        exceptionMessage.setDocumentation(generateDocLink(request));
        return exceptionMessage;
    }

    private String generateDocLink(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        return new StringBuilder()
                .append(scheme)
                .append("://")
                .append(serverName)
                .append(":")
                .append(serverPort)
                .append("/api/docs")
                .toString();
    }

    public abstract ExceptionMessage getErrorMessage(T exception, HttpServletRequest request);
}
