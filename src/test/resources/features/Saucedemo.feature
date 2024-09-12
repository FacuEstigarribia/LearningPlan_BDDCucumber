Feature: Ordering products from SauceDemo

  Scenario: Place an order successfully
    Given the user is logged in with credentials from the database
    When the user adds orders stored in the database for the mentioned user
    And proceeds to checkout
    Then the order should be successful
