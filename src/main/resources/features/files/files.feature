Feature: Java handles files
  This suite expose the power of the io File library

  Scenario: Java creates a file
    Given A new directory is created
    When A file is created
    Then The file should exist
