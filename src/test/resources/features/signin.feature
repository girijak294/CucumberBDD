Feature: Sign-in and Sign-out on the shopping portal
  In order to access my account
  As a registered user
  I want to be able to sign in and sign out

  Scenario: Successful sign-in with valid credentials
    Given I am on the sign-in page
    When I enter valid credentials
    And I click on the sign-in button
    Then I should be signed in successfully
    And I should see my account dashboard

  Scenario: Sign-in with invalid credentials
    Given I am on the sign-in page
    When I enter invalid credentials
    And I click on the sign-in button
    Then I should see an error message for invalid credentials

  Scenario: Successful sign-out
    Given I am signed in
    When I click the sign-out button
    Then I should be signed out successfully
    And I should be redirected to the home page
