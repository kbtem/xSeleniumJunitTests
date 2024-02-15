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

    @passwordReset1
    Scenario: User wants to reset their password.
      When User clicks Sign in button
      And User should be directed to "https://twitter.com/i/flow/login"
      And User clicks Forgot password? button
      And User should be redirected to "https://twitter.com/i/flow/password_reset?input_flow_data=%7B%22requested_variant%22%3A%22eyJwbGF0Zm9ybSI6IlJ3ZWIifQ%3D%3D%22%7D"
      And User enters valid username to reset password
      And User click next on the password reset page
      Then User should see confirmation code page
      And User clicks on confirmation page next button
      Then User should see message "We sent you a code"



