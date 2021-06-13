package com.amberlion.runbyreports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reports/cucumber-html-report.html",
                "json:cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"com.amberlion.stepdefinition"}
)
public class RunCucumberPrettyTestReport {

}
