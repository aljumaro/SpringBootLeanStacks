package com.aljumaro.techtest.boundary.email;

import com.aljumaro.techtest.domain.greeting.Greeting;

import java.util.concurrent.Future;

/**
 * @Date 12/11/2016
 * @Time 17:02
 * @Author Juanma
 */
public interface EmailProvider {

    Boolean send(Greeting greeting);

    void sendAsync(Greeting greeting);

    Future<Boolean> sendAsyncWithResult(Greeting greeting);

}
