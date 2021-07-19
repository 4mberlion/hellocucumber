package com.amberlion.selenium.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class StepDefinitions {

    private WebDriver driver;

    @Given("running chrome browser")
    public void running_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("console.log('lololo')");
    }

    @When("navigate to {string}")
    public void navigate_to_link(String link) {
        driver.navigate().to("https://"+link);
    }

    @Then("A certain element should appear")
    public void a_certain_element_should_appear() {
        driver.findElement(By.xpath("//form[@action=\"/search\"]"));
        driver.close();
    }

    @When("Many window instances are open")
    public void many_window_instances_are_open() {
        String path = Paths.get("src","main", "resources", "htmls").toAbsolutePath().toString();
        driver.navigate().to(String.valueOf(Paths.get(path, "apple.html")));
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", String.valueOf(Paths.get(path, "onion.html")));
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", String.valueOf(Paths.get(path, "horse.html")));
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    }

    @Then("Close the instance with id {string}")
    public void close_the_instance_with_id(String id) {
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if(!driver.findElements(By.id(id)).isEmpty()) {
                driver.close();
            }
        }
    }
}
