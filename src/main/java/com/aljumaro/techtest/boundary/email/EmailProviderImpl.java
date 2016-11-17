package com.aljumaro.techtest.boundary.email;

import com.aljumaro.techtest.domain.greeting.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.AccessType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @Date 12/11/2016
 * @Time 17:09
 * @Author Juanma
 */
@Service
public class EmailProviderImpl implements EmailProvider {

    private static final Logger _log = LoggerFactory.getLogger(EmailProviderImpl.class);

    @Override
    public Boolean send(Greeting greeting) {
        _log.info("> send");

        Boolean success = Boolean.FALSE;

        long pause = 5000;
        try {
            Thread.sleep(pause);
        } catch (Throwable t){
            _log.error("Thread.sleep errormessage: ", t);
        }

        _log.info("Processing time was {} seconds.", pause / 1000);

        success = Boolean.TRUE;

        _log.info("< send");

        return success;
    }

    @Async
    @Override
    public void sendAsync(Greeting greeting) {
        _log.info("> sendAsync");

        send(greeting);

        _log.info("< sendAsync");
    }

    @Async
    @Override
    public Future<Boolean> sendAsyncWithResult(Greeting greeting) {
        _log.info("> sendAsyncWithResult");

        CompletableFuture<Boolean> result = new CompletableFuture<>();

        try {
            Boolean success = send(greeting);
            result.complete(success);
        } catch (Throwable t) {
            _log.error("sendAsyncWithResultException: ", t);
            result.completeExceptionally(t);
        }

        _log.info("< sendAsyncWithResult");

        return result;
    }
}
