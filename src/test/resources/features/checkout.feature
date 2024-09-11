Feature: Checkout process

  Background:
    Given I am on the Sauce Demo login page
    And I log in with username "<username>" and password "<password>"

    Scenario Outline: Add products to cart and complete checkout
      When I add my product to the cart and proceed to checkout
      Then I should see the checkout confirmation page


    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
