Feature: Login to Sauce Demo taking data from database

  Scenario Outline: Successfully log in with valid credentials
    Given I am on the Sauce Demo login page
    When I log in with username "<username>" and password "<password>"
    Then I should see the Sauce Labs products page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
#      | problem_user            | secret_sauce |
#      | performance_glitch_user | secret_sauce |
