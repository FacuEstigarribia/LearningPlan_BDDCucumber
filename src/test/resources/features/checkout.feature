Feature: Checkout process on SauceDemo

  Scenario Outline: Successful checkout for a valid user
    Given the user is logged in with valid "<username>" and "<password>"
    When the user adds items to the cart
    And the user click on cart button
    And the user proceeds to checkout
    And the user provides valid shipping information
    And the user click on continue button
    And the user confirms the order
    Then the user should see the order confirmation page
    And the order should be saved in the database

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |