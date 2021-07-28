Feature: Utilise chromedriver
  Webdriver should interact with the browser

  @Single
  Scenario: Webdriver opens the browser
    Given running chrome browser
    When navigate to "www.google.com"
    Then A certain element should appear

  Scenario: Webdriver Operates on multiple windows
    Given running chrome browser
    When Many window instances are open
    Then Close the instance with id "onion"
    Then Close the instance with id "horse"

  Scenario: Wait test
    Given running chrome browser
    When Window with disappearing button appears
    And Waits until button appears
