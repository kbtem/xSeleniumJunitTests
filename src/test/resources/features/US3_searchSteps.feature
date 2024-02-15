@Search
Feature: Search Functionality

  @Search1
  Scenario: Search for Users
    Given User is logged in and the user is on the home page
    When the user enters a search query for another user
    And clicks on the search button
    Then relevant user profiles should be displayed