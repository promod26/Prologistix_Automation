Feature: prologistix Functional Test


  Background:
    Given verify app is up and running

  Scenario: Complete user registration
    Given I want to create my profile with prologistix
    When I fill registration form
    Then I should be registered successfully 

