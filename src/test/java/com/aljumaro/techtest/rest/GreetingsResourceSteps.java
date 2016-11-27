package com.aljumaro.techtest.rest;

import com.aljumaro.techtest.domain.greeting.Greeting;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * @Date 19/11/2016
 * @Time 9:26
 * @Author Juanma
 */

public class GreetingsResourceSteps extends AbstractSteps {

    ParameterizedTypeReference<Collection<Greeting>> typeRef = new ParameterizedTypeReference<Collection<Greeting>>() {
    };

    @When("^I request a list of greetings$")
    public void i_request_a_list_of_greetings() throws Throwable {
        stepHelper.setResponse(testRestTemplate
                                       .exchange("/api/greetings", HttpMethod.GET, stepHelper.getRequest(), typeRef));
    }

    @Then("^the response should contain message entities$")
    public void the_response_should_contain_message_entities() throws Throwable {
        ResponseEntity<?> responseEntity = stepHelper.getResponse();
        Collection<Greeting> responseBody = (Collection<Greeting>) responseEntity.getBody();
        assert responseBody.size() > 0;
    }

    @When("^I save a greeting with \"([^\"]*)\" text attribute$")
    public void i_save_a_greeting_with_text_attribute(String arg1) throws Throwable {
        Greeting g = new Greeting();
        g.setText(arg1);

        HttpEntity<?> httpEntity = new HttpEntity<Greeting>(g, stepHelper.getRequest().getHeaders());

        stepHelper.setResponse(testRestTemplate
                                       .exchange("/api/greetings", HttpMethod.POST, httpEntity, Greeting.class));
    }

    @Then("^the response should contain a message with \"([^\"]*)\" text attribute$")
    public void the_response_should_contain_a_message_with_text_attribute(String arg1) throws Throwable {
        ResponseEntity<?> responseEntity = stepHelper.getResponse();
        Greeting greeting = (Greeting) responseEntity.getBody();

        assert greeting.getText().equalsIgnoreCase(arg1);
    }
}
