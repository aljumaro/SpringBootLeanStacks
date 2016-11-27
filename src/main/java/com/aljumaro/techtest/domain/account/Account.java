package com.aljumaro.techtest.domain.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @Date 13/11/2016
 * @Time 9:39
 * @Author Juanma
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean enabled = true;

    @NotNull
    private boolean credentialsExpired = false;

    @NotNull
    private boolean expired = false;

    @NotNull
    private boolean locked = false;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name="ACCOUNT_ROLE",
            joinColumns = @JoinColumn(
                    name="ACCOUNT_ID",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="ROLE_ID",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = Collections.emptySet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User toUser(){

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode())));

        return new User(getUsername(),
                        getPassword(),
                        isEnabled(),
                        !isExpired(),
                        !isCredentialsExpired(),
                        !isLocked(),
                        grantedAuthorities);

    }
}
