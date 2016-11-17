package com.aljumaro.techtest.domain.greeting;

import com.aljumaro.techtest.domain.exception.ErrorCodes;
import com.aljumaro.techtest.domain.exception.greeting.GreetingValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @Date 12/11/2016
 * @Time 13:05
 * @Author Juanma
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GreetingServiceImpl implements GreetingService {

    private static final Logger _log = LoggerFactory.getLogger(GreetingServiceImpl.class);

    private GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<Greeting> findAll() {
        return greetingRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Greeting findOne(Long id) {
        return greetingRepository.findOne(id);
    }

    @Override
    public Greeting create(Greeting greeting) {
        validateGreetingIdIsNull(greeting);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting update(Greeting greeting) {
        validateGreetingExists(greeting.getId());
        return greetingRepository.save(greeting);
    }

    @Override
    public void delete(Long id) {
        validateGreetingExists(id);
        greetingRepository.delete(id);
    }

    private void validateGreetingExists(Long id) {
        if (findOne(id) == null){
            throw new GreetingValidationException(
                    ErrorCodes.GREETING_VALIDATION_NOT_FOUND.getCode(),
                    "The greeting does not exist.");
        }
    }

    private void validateGreetingIdIsNull(Greeting greeting) {
        if (greeting.getId() != null) {
            throw new GreetingValidationException(
                    ErrorCodes.GREETING_VALIDATION_ID_FOUND.getCode(),
                    "Attempted to create a Greeting, but id attribute was not null.");
        }
    }
}
