@Tweet
Feature: Composing a Tweet.
  User Story: When logged in user should be able to compose a tweet and publish.

  @Tweet1
  Scenario: User successfully composes a tweet.


    Given User is logged in and the user is on the home page
    And User types in their tweet
    And User clicks on post button
    Then User should see their tweet on the page



