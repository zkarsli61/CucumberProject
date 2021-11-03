@scenario_outline_google_search
Feature: Google_Search_Functionality

  Scenario Outline: google_search
#shift + < puts data in <>
    Given user is on the google page
    And user search for <item>
    Then verify the result has <item>
    Then close the application

    Examples: Test Data
      | item    |
      | iPhone  |
      | tea pot |
      | flower  |
      | tesla   |
      | bmw     |
      | buick   |

#When user search for the following capitals: London, Paris, Vienna, Berlin, Madrid
#Then verify the the result includes the the searched values
