@parameterized_google_search
Feature: Google_Search_Functionality

  Scenario: TC01_iPhone_search
    Given user is on the google page
    And user search for "iPhone"
    Then verify the result has "iPhone"
    Then close the application

  Scenario: TC02_teapot_search
    Given user is on the google page
    And user search for "tea pot"
    Then verify the result has "tea pot"
    Then close the application
