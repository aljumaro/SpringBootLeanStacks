package com.aljumaro.techtest.rest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;

/**
 * @Date 20/11/2016
 * @Time 17:18
 * @Author Juanma
 */
public class ActuatorSteps extends AbstractSteps {

    @When("^I request the app-console metrics$")
    public void i_request_the_app_console_metrics() throws Throwable {
        stepHelper.setResponse(testRestTemplate
                                   .exchange("/app-console/metrics", HttpMethod.GET, stepHelper.getRequest(), LinkedHashMap.class));
    }

    @Then("^The response should contain free memory available$")
    public void the_response_should_contain_free_memory_available() throws Throwable {
        LinkedHashMap<String, Integer> metricsInfo = (LinkedHashMap<String, Integer>) stepHelper.getResponse().getBody();

        Assert.assertTrue(metricsInfo.get("mem.free")>0);
    }
}
