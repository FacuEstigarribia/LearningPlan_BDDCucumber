Feature: Saucedemo Tests with Cucumber
  Check Saucedemo web suite login functionality demo

  @demo
  Scenario: Saucedemo open page - original
    Given I am login into application using "standard_user"
    When I add orders from the database for the user
    And I proceed to checkout
    Then I verify the order was successful