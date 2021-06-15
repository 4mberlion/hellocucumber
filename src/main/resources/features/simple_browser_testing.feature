Feature: Utilise chromedriver
  Webdriver should interact with the browser

  @Single
  Scenario: Webdriver opens the browser
    Given running chrome browser
    When navigate to "www.google.com"
    Then A certain element should appear
