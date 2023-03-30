@smoke
Feature: F05_hoverCategories | user could select from hover category

  Scenario: guest user could search using product name
    Given user go to login page
    When user enter valid data
    And user press on login button
    And user select from computer hover category and choose desktop
    Then user should direct to desktop page