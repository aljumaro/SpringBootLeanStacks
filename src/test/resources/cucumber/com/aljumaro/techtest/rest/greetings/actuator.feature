Feature: Actuator endpoint feature

  As an admin i can access all actuator endpoints

    Scenario: Metrics actuator
    Given I have authenticated as an admin
    When I request the app-console metrics
    Then The response should contain free memory available