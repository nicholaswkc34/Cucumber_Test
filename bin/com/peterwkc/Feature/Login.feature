@Login_Valid
Feature: Login to PHP Travel
Description:  As a user, I want login to PHP Travel 

  Scenario: Valid Login
    Given PHP Travel Home Page opens in browser
    When I login to PHP Travel with Username and Password
    Then Page navigate to PHP Travel Home Page

