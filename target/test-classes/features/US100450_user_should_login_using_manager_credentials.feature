@login_test
Feature: Login_Functionality_With_Right_Credentials

  Background: Navigate to the page
    Given user is on the application page

  @manager_login_test
  Scenario Outline: login_with_manager_credentials
    And enter id "<manager_id>"
    And enter password "<manager_password>"
    When user clicks on the login button
    Then verify the "<manager_id>" is displayed
    Then close the application

    Examples: manager credentials

      | manager_id | manager_password |
      | manager    | Manager1!        |
      | manager2   | Manager2!        |
      | manager3   | Manager3!        |


  @admin_login_test
  Scenario Outline: login_with_manager_credentials
    And enter id "<manager_id>"
    And enter password "<manager_password>"
    When user clicks on the login button
    Then verify the "<manager_id>" is displayed
    Then close the application

    Examples: admin data

      | manager_id | manager_password |
      | admin      | Techproed123    |
