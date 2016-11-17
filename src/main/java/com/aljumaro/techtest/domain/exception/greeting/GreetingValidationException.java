package com.aljumaro.techtest.domain.exception.greeting;

import com.aljumaro.techtest.domain.exception.LeanStacksException;

/**
 * @Date 15/11/2016
 * @Time 18:51
 * @Author Juanma
 */
public class GreetingValidationException extends LeanStacksException{

    public GreetingValidationException(String code, String message) {
        super(code, message);
    }
}
