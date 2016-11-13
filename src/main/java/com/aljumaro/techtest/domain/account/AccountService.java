package com.aljumaro.techtest.domain.account;

/**
 * @Date 13/11/2016
 * @Time 10:06
 * @Author Juanma
 */
public interface AccountService {

    Account findByUsername(String username);
}
