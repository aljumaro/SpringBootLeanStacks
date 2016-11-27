package com.aljumaro.techtest.batch;

import com.aljumaro.techtest.domain.greeting.Greeting;
import com.aljumaro.techtest.domain.greeting.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Date 12/11/2016
 * @Time 16:44
 * @Author Juanma
 */
@Component
public class GreetingBatchService {

    private static final Logger _log = LoggerFactory.getLogger(GreetingBatchService.class);

    private GreetingService greetingService;

    public GreetingBatchService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //@Scheduled(cron = "${batch.greeting.cron}")
    public void cronJob(){
        Collection<Greeting> greetings = greetingService.findAll();
        _log.info("There are {} greetings in the data store", greetings.size());

        _log.info("< cronJob");
    }

    //@Scheduled(initialDelayString = "${batch.greeting.initialdelay}", fixedRateString = "${batch.greeting.fixeddelay}")
    public void fixedRateJobWithInitialDelay(){
        _log.info("> fixedRateJobWithInitialDelay");

        long pause = pause();
        _log.info("Processing time was {} seconds.", pause / 1000);

        _log.info("< fixedRateJobWithInitialDelay");
    }

    //@Scheduled(initialDelayString = "${batch.greeting.initialdelay}", fixedDelayString = "${batch.greeting.fixeddelay}")
    public void fixedDelayJobWithInitialDelay(){
        _log.info("> fixedDelayJobWithInitialDelay");

        long pause = pause();
        _log.info("Processing time was {} seconds.", pause / 1000);

        _log.info("< fixedDelayJobWithInitialDelay");
    }

    private long pause() {
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()){
                break;
            }
        }while (true);
        return pause;
    }
}
