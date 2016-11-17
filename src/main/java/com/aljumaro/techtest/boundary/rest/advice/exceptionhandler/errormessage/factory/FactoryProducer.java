package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.domain.exception.LeanStacksException;

import javax.validation.ConstraintViolationException;

/**
 * @Date 17/11/2016
 * @Time 23:50
 * @Author Juanma
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(Exception exception){

        if (exception instanceof ConstraintViolationException) {
            return new ConstraintViolationErrorMessageFactory();
        }

        if (exception instanceof LeanStacksException) {
            return new LeanStacksErrorMessageFactory();
        }

        return new ErrorMessageFactory();
    }

}
