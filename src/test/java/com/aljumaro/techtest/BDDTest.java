package com.aljumaro.techtest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @Date 20/11/2016
 * @Time 9:04
 * @Author Juanma
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber/html", "json:target/cucumber/json" },
        features = "classpath:cucumber/com/aljumaro/techtest/rest",
        glue = "classpath:com.aljumaro.techtest.rest",
        tags = "@wip"
)
public class BDDTest {

}
