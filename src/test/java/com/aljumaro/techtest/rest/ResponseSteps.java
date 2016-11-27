package com.aljumaro.techtest.rest;

import com.aljumaro.techtest.helper.TestLogger;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.http.HttpStatus;

/**
 * @Date 27/11/2016
 * @Time 18:56
 * @Author Juanma
 */
public class ResponseSteps extends AbstractSteps {

    @Then("^I should get a response with status code (\\d+)$")
    public void i_should_get_a_response_with_status_code(int code) throws Throwable {
        TestLogger.debug("Status code --> Expected = {}; Received = {}", code, stepHelper.getResponse().getStatusCode());
        Assert.assertTrue(stepHelper.getResponse().getStatusCode().equals(HttpStatus.valueOf(code)));
    }

}
