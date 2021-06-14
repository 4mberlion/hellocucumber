package com.amberlion.selenium.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class StepDefinitions {

    private WebDriver driver;

    @Given("running chrome browser")
    public void running_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @When("navigate to www.google.com")
    public void navigate_to_www_google_com() {
        driver.navigate().to("https://www.google.pl");
    }
    @Then("A certain element should appear")
    public void a_certain_element_should_appear() {
        Assert.assertEquals(1,1);
    }
}
