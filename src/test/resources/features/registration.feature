Feature: Registration on the shopping portal
  In order to shop on the online shopping portal
  As a new user
  I want to be able to register an account

  Scenario: Successful registration with valid details
    Given I am on the registration page
    When I enter valid registration details
    And I submit the registration form
    Then I should be registered successfully
    And I should see a confirmation message

  Scenario: Registration with invalid email
    Given I am on the registration page
    When I enter an invalid email address
    And I submit the registration form
    Then I should see an error message for invalid email

  Scenario: Registration with missing mandatory fields
    Given I am on the registration page
    When I submit the form without entering mandatory fields
    Then I should see an error message for missing mandatory fields
