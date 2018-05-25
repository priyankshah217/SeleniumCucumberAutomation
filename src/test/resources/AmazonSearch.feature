@search
Feature: Search feature on amazon.in
  As a User, I want functionality to search any product from any category
  so, I can purchase it

  Scenario Outline: Search product
    Given I open amazon site
    When I search product name as "<SearchProducts>"
    Then It should show me listed relevant product only

    Examples:
      | SearchProducts |
      | computers      |