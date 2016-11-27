package com.aljumaro.techtest.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestComponent;

/**
 * @Date 27/11/2016
 * @Time 19:03
 * @Author Juanma
 */
@TestComponent
public class TestLogger {

    private static final Logger _log = LoggerFactory.getLogger(TestLogger.class);

    public static void debug(String message, Object... args) {
        _log.debug(message, args);
    }
}
