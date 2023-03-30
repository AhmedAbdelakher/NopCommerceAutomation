@smoke
Feature: F02_Login | users could login with authorised accounts
  Scenario: guest user could login with valid data successfully
    Given user go to login page
    When user enter valid data
    And user press on login button
    Then user login to the system successfully

  Scenario: guest user couldn't login with invalid data
    Given user go to login page
    When user enter invalid data
    And user press on login button
    Then user could not login to the system