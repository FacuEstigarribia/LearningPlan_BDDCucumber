Feature: Saucedemo Test Login functionality

  Scenario: Test login Successfully
    Given I am on LoginPage of Saucedemo website
    When User type username and password
    And User click on Login button
    Then HomePage must be open