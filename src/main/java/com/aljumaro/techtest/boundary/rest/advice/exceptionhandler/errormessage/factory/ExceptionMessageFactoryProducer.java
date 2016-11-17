package com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl.ConstraintViolationExceptionMessageFactoryExceptionMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl.ExceptionMessageFactoryExceptionMessage;
import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.factory.impl.LeanStacksExceptionMessageFactoryExceptionMessage;
import com.aljumaro.techtest.domain.exception.LeanStacksException;

import javax.validation.ConstraintViolationException;

/**
 * @Date 17/11/2016
 * @Time 23:50
 * @Author Juanma
 */
public class ExceptionMessageFactoryProducer {

    public static ExceptionMessageAbstractFactory getFactory(Exception exception){

        if (exception instanceof ConstraintViolationException) {
            return new ConstraintViolationExceptionMessageFactoryExceptionMessage();
        }

        if (exception instanceof LeanStacksException) {
            return new LeanStacksExceptionMessageFactoryExceptionMessage();
        }

        return new ExceptionMessageFactoryExceptionMessage();
    }

}
