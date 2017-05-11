Feature: Calculate Fibonacci Numbers
  As a millennial
  I want a fibonacci calculator
  In order to avoid having to do math

  Scenario: Calculate first fibonacci number
    Given I want fibonacci number 1
    When I use the calculator
    Then I should get the number 1

  Scenario: Calculate second fibonacci number
    Given I want fibonacci number 2
    When I use the calculator
    Then I should get the number 1

  Scenario: Calculate third fibonacci number
    Given I want fibonacci number 3
    When I use the calculator
    Then I should get the number 2

  Scenario: Calculate fourth fibonacci number
    Given I want fibonacci number 4
    When I use the calculator
    Then I should get the number 3

  Scenario: Calculate fifth fibonacci number
    Given I want fibonacci number 5
    When I use the calculator
    Then I should get the number 5
    