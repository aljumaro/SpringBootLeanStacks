package com.aljumaro.techtest.domain.greeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Date 12/11/2016
 * @Time 13:20
 * @Author Juanma
 */
@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
