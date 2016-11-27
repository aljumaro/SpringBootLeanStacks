package com.aljumaro.techtest.infrastructure.security;

import com.aljumaro.techtest.domain.account.Account;
import com.aljumaro.techtest.domain.account.AccountUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;

/**
 * @Date 13/11/2016
 * @Time 10:23
 * @Author Juanma
 */
@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private AccountUserDetailService accountUserDetailService;
    private PasswordEncoder passwordEncoder;
    private static final Account UNAUTHORIZED = new Account("Unauthorized", "");

    @Autowired
    public void setAccountUserDetailService(
            AccountUserDetailService accountUserDetailService) {
        this.accountUserDetailService = accountUserDetailService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {

        if (token.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }

        if (!passwordEncoder.matches((String)token.getCredentials(), userDetails.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username,
                                       UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        UserDetails userDetails = accountUserDetailService.loadUserByUsername(username);
        if (userDetails == null) {
            return UNAUTHORIZED.toUser();
        }
        return userDetails;
    }
}
