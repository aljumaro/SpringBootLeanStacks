package com.aljumaro.techtest.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date 13/11/2016
 * @Time 10:06
 * @Author Juanma
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
