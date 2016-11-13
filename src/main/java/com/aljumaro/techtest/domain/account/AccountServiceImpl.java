package com.aljumaro.techtest.domain.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date 13/11/2016
 * @Time 10:07
 * @Author Juanma
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
