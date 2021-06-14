package com.amberlion.selenium;

        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"com.amberlion"},
        tags = "@Browser"
)
public class RunSeleniumTest {

}

