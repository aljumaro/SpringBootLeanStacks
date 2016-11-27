@wip
Feature: Greetings endpoint

  As a consumer of the greetings resource
  I should be able to get a list of current greetings

  Scenario: Get greetings
    Given I have authenticated as an user
    When I request a list of greetings
    Then I should get a response with status code 200
    And the response should contain message entities

  Scenario Outline: Save greeting as user
    Given I have authenticated as an user
    When I save a greeting with "<inputText>" text attribute
    Then I should get a response with status code 201
    And the response should contain a message with "<inputText>" text attribute
    Examples:
    | inputText |
    | hello there! |
    | yo! |
    | Lets Hi |