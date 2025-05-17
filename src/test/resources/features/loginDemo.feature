
@auth @smoke
Feature: User Authentication
  As a registered user
  I want to log in to the system
  So that I can access my dashboard

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user logs in with username "user1" and password "password123"
    Then the system should display the dashboard

  Scenario: Login with incorrect password
    Given the user is on the login page
    When the user logs in with username "user1" and password "wrongpass"
    Then the system should show a "Invalid credentials" message

  Scenario: Login with empty fields
    Given the user is on the login page
    When the user submits the login form with empty username and password
    Then the system should display a validation error
