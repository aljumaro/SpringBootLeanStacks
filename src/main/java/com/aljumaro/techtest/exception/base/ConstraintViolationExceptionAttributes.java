package com.aljumaro.techtest.exception.base;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Map;

import static com.aljumaro.techtest.exception.base.ExceptionResponseBuilder.MESSAGE;

/**
 * @Date 13/11/2016
 * @Time 12:28
 * @Author Juanma
 */
public class ConstraintViolationExceptionAttributes implements ExceptionAttributes{

    public ConstraintViolationExceptionAttributes() {
        super();
    }

    public static Map<String, Object> of(ConstraintViolationException exception, HttpServletRequest httpServletRequest,
                                         HttpStatus httpStatus) {
        Map<String, Object> result = new ConstraintViolationExceptionAttributes().getExceptionAttributes(exception, httpServletRequest, httpStatus);

        result.put(MESSAGE, buildMessage(exception));

        return result;
    }

    private static Object buildMessage(ConstraintViolationException exception) {

        StringBuilder builder = new StringBuilder("There was a exception with the entity [");

        exception.getConstraintViolations().forEach(cv -> {
            builder.append(String.format("Property %s %s", cv.getPropertyPath(), cv.getMessage()));
        });

        builder.append("]");
        return builder.toString();
    }

    @Override
    public Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpServletRequest,
                                                      HttpStatus httpStatus) {
        return ExceptionResponseBuilder.createResponse(exception, httpServletRequest, httpStatus);
    }
}
