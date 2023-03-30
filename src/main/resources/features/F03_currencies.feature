@smoke
Feature: F03_currencies | users could change the currency
  Scenario: guest user could change the currency
    Given user go to login page
    When user enter valid data
    And user press on login button
    And user choose Euro currency from dropdown list
    Then user change the currency successfully