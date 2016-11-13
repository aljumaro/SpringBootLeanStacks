package com.aljumaro.techtest.boundary.rest;

import com.aljumaro.techtest.boundary.email.EmailProvider;
import com.aljumaro.techtest.boundary.rest.base.BaseController;
import com.aljumaro.techtest.domain.greeting.Greeting;
import com.aljumaro.techtest.domain.greeting.GreetingService;
import com.aljumaro.techtest.infrastructure.ProfilePropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.Future;

/**
 * @Date 12/11/2016
 * @Time 11:48
 * @Author Juanma
 */
@RestController
public class GreetingController extends BaseController{

    private GreetingService greetingService;
    private EmailProvider emailProvider;

    public GreetingController(GreetingService greetingService, EmailProvider emailProvider) {
        this.greetingService = greetingService;
        this.emailProvider = emailProvider;
    }

    @GetMapping(
            value = "/api/greetings",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> getGreetings() {
        return ResponseEntity.ok(greetingService.findAll());
    }

    @PostMapping(
            value = "/api/greetings",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGreeting(@RequestBody Greeting greeting) {
        Greeting created = greetingService.create(greeting);
        return new ResponseEntity<Greeting>(created, HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/api/greetings/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGreeting(@PathVariable("id") Long id) {
        Greeting greeting = greetingService.findOne(id);
        return ResponseEntity.ok(greeting);
    }

    @RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateGreeting(@PathVariable("id") Long id, @RequestBody Greeting greeting) {
        greeting.setId(id);
        Greeting updated = greetingService.update(greeting);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @RequestMapping(
            value = "/api/greetings/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteGreeting(@PathVariable("id") Long id) {
        greetingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            value = "/api/greetings/{id}/send",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendGreeting(@PathVariable("id") Long id,
                                          @RequestParam(value = "wait", defaultValue = "false") boolean waitForAsync) {
        _log.info("> GreetingController.sendGreeting");

        Greeting greeting = null;

        try {
            greeting = greetingService.findOne(id);
            if (greeting == null) {
                _log.info("< GreetingController.sendGreeting");
                return ResponseEntity.notFound().build();
            }

            if (waitForAsync) {
                Future<Boolean> asyncResponse = emailProvider.sendAsyncWithResult(greeting);
                boolean emailSent = asyncResponse.get();
                _log.info("- greeting email sent? {}", emailSent);
            } else {
                emailProvider.sendAsync(greeting);
            }
        } catch (Throwable t) {
            _log.error("GreetingController.sendGreeting Exception: ", t);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        _log.info("< GreetingController.sendGreeting");
        return ResponseEntity.ok(greeting);
    }
}
