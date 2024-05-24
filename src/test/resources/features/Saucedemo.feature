Feature: Saucedemo Tests with Cucumber
  Check Saucedemo web suite login functionality demo

  @demo
  Scenario: Saucedemo open page - original
    Given I am on LoginPage
    When Type valid username and password
    When Cick Login button
    Then HomePage must be opened checked by Products title