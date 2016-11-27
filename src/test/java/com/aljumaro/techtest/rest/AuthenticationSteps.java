package com.aljumaro.techtest.rest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

/**
 * @Date 27/11/2016
 * @Time 18:55
 * @Author Juanma
 */
public class AuthenticationSteps extends AbstractSteps {

    @Given("^I have authenticated as an user$")
    public void i_have_authenticated_as_an_user() throws Throwable {
        stepHelper.setRequest(new HttpEntity(createAuthenticationHeaders("user", "userpassword")));
    }

    @Given("^I have authenticated as an admin$")
    public void i_have_authenticated_as_an_admin() throws Throwable {
        stepHelper.setRequest(new HttpEntity(createAuthenticationHeaders("admin", "adminpassword")));
    }

    @Given("^I provide credentials with user \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_provide_credentials_with_user_and(String user, String password) throws Throwable {
        stepHelper.setRequest(new HttpEntity(createAuthenticationHeaders(user, password)));
    }

    @When("^I access the \"([^\"]*)\"$")
    public void i_access_the(String apiUrl) throws Throwable {
        stepHelper.setResponse(testRestTemplate
                                   .exchange(apiUrl, HttpMethod.GET, stepHelper.getRequest(), Object.class));
    }

}
