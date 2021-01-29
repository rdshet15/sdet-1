
@activity1_2
Feature: Login Test
  I want to use this template for my feature file

  @Login
  Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And Close the Browser
