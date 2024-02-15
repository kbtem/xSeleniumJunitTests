@Login
Feature: User should be able to login to Twitter with correct credentials

  Background:
    Given User is on the Twitter login page

  @Login1
  Scenario: User successfully logs in with valid credentials
    When User enters valid username
    And User clicks on the next button
    And User enters valid password
    And User clicks on the login button
    Then User should see URl contains "https://twitter.com/home"

  @Login2
  Scenario Outline: User receives error message with invalid credentials
    When User enters "<invalid_username>" invalid username.
    And User clicks on the next button
    Then User should see an error message "Sorry, we could not find your account."

    Examples:
      | invalid_username  |
      | invalid_userrax   |
      | valid_usernamezzz |
      | invalid_user1a2b  |

  @login3
  Scenario Outline: User receives error message with valid username but invalid password.
    When User enters valid username
    And User clicks on the next button
    And User enters "<invalid_password>" invalid password.
    And User clicks on the login button
    Then User should see an error message "Wrong password!"

    Examples:
      | invalid_password   |
      | invalid_passd      |
      | valid_passwordqw   |
      | invalid_pasword123 |




