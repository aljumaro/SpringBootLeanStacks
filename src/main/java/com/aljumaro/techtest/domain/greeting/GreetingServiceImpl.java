package com.aljumaro.techtest.domain.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
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
        if (greeting.getId() != null) {
            _log.error(
                    "Attempted to create a Greeting, but id attribute was not null.");

            throw new EntityExistsException("The id attribute must be null to persist a new entity.");
        }

        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting update(Greeting greeting) {
        Greeting toUpdate = findOne(greeting.getId());

        if (toUpdate == null) {
            _log.error(
                    "Attempted to update a Greeting, but the entity does not exist.");

            throw new EntityExistsException("Requested entity not found.");
        }

        return greetingRepository.save(greeting);
    }

    @Override
    public void delete(Long id) {
        greetingRepository.delete(id);
    }
}
