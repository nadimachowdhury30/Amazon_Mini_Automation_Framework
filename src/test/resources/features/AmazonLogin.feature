Feature: Login functionality
  As a registered user
  I want to log into the application
  So that I can access my account securely

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should see a welcome message
    
    

