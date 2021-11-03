@capital_search
Feature: capital search feature

  Scenario Outline: capital search scenario
    Given user is on the google page
    And user search for "<world_capital>"
    Then verify the result has "<world_capital>"
    Then close the application

    Examples: Test Data
      | world_capital |
      | London        |
      | Paris         |
      | Vienna        |
      | Madrid        |
