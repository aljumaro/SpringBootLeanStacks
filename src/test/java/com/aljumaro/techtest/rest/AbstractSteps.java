package com.aljumaro.techtest.rest;

import com.aljumaro.techtest.boundary.rest.advice.exceptionhandler.errormessage.ExceptionMessage;
import com.aljumaro.techtest.helper.StepHelper;
import com.aljumaro.techtest.helper.TestLogger;
import cucumber.api.java.en.Then;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.nio.charset.Charset;

/**
 * @Date 20/11/2016
 * @Time 16:59
 * @Author Juanma
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@TestPropertySource(locations = {"classpath:application.yml"})
@ActiveProfiles("dev")
public class AbstractSteps {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    protected StepHelper stepHelper;

    protected ParameterizedTypeReference<ExceptionMessage> exceptionMessageTypeReference =  new ParameterizedTypeReference<ExceptionMessage>() {
    };

    protected HttpHeaders createAuthenticationHeaders(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("UTF-8")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
