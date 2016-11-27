package com.aljumaro.techtest.helper;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @Date 20/11/2016
 * @Time 16:45
 * @Author Juanma
 */
@Component
public class StepHelper {

    private ResponseEntity<?> response;
    private HttpEntity<?> request;

    public ResponseEntity<?> getResponse() {
        return response;
    }

    public void setResponse(ResponseEntity<?> response) {
        this.response = response;
    }

    public HttpEntity<?> getRequest() {
        return request;
    }

    public void setRequest(HttpEntity<?> request) {
        this.request = request;
    }
}
