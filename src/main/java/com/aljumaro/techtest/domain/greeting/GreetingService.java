package com.aljumaro.techtest.domain.greeting;

import org.springframework.cache.annotation.CacheEvict;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @Date 12/11/2016
 * @Time 13:04
 * @Author Juanma
 */
public interface GreetingService {

    Collection<Greeting> findAll();

    Greeting findOne(Long id);

    Greeting create(Greeting greeting);

    Greeting update(Greeting greeting);

    void delete(Long id);
}
