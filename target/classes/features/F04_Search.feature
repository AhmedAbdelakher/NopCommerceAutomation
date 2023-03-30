@smoke
Feature: F04_Search | user could search using product name

  Scenario Outline: guest user could search using product name
    Given user go to login page
    When user enter valid data
    And user press on login button
    And user search using product name "<productName>"
    Then user could search successfully "<productName>"
    Examples:
    |productName|
    |book       |
    |laptop     |
    |nike       |

  Scenario Outline: guest user could search for product using sku
    Given user go to login page
    When user enter valid data
    And user press on login button
    And user search using sku name "<skuName>"
    Then user could search with sku successfully "<skuName>"
    Examples:
    |skuName|
    |SCI_FAITH|
    |APPLE_CAM|
    |SF_PRO_11|