package com.aljumaro.techtest.boundary.rest.base;

import com.aljumaro.techtest.exception.base.ConstraintViolationExceptionAttributes;
import com.aljumaro.techtest.exception.base.DefaultExceptionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Map;

/**
 * @Date 13/11/2016
 * @Time 11:57
 * @Author Juanma
 */
public class BaseController {

    protected final Logger _log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception exception,
                                                               HttpServletRequest httpServletRequest) {

        _log.error("BaseExceptionHandler");
        _log.error("Exception: ", exception);

        return new ResponseEntity<Map<String, Object>>(
                DefaultExceptionAttributes.of(exception, httpServletRequest, HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Map<String, Object>> handleNoResultException(Exception exception,
                                                               HttpServletRequest httpServletRequest) {

        _log.error("NoResultExceptionHandler");

        return new ResponseEntity<Map<String, Object>>(
                DefaultExceptionAttributes.of(exception, httpServletRequest, HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException exception,
                                                                       HttpServletRequest httpServletRequest) {

        _log.error("handleConstraintViolationException");

        return new ResponseEntity<Map<String, Object>>(
                ConstraintViolationExceptionAttributes.of(exception, httpServletRequest, HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
