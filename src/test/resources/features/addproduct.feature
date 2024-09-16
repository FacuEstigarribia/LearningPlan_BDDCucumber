Feature: Check add product to cart functionality
  Scenario Outline: Verify adding product to cart
    Given I am on main page
    When I log in as <user_id> user
    Then Product page is opened
    When I add product to cart
    Then I have an product in my cart

    Examples:
    | user_id |
    |6        |