package com.amberlion.selenium.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

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
        driver.getWindowHandles().stream()
                .map(handle -> driver.switchTo().window(handle))
                .filter(x->!driver.findElements(By.id(id)).isEmpty())
                .findFirst();
        driver.close();
//        for(String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//            if(!driver.findElements(By.id(id)).isEmpty()) {
//                driver.close();
//            }
//        }
    }

    @When("Window with disappearing button appears")
    public void windowWithDisappearingButtonAppears() {
        String path = Paths.get("src","main", "resources", "htmls").toAbsolutePath().toString();
        driver.navigate().to(String.valueOf(Paths.get(path, "toggling_visibility.html")));
    }

    @And("Waits until button appears")
    public void waitsUntilButtonAppears() {
        class MyTask implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.findElement(By.id("visible")).click();
            }
        }
        Thread sleepingThread = new Thread(new MyTask());
        sleepingThread.start();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.id("intangible")));
        driver.findElement(By.id("intangible")).click();
    }
}
