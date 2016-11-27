Feature:
  Different user profiles should have access to different api

  Scenario Outline: Access as different users
    Given I provide credentials with user "<login>" and "<password>"
    When I access the "<api>"
    Then I should get a response with status code <statusCode>
    Examples:
      | login | password | api | statusCode |
      | user | userpassword | /api/greetings | 200 |
      | user | userpassword | /app-console/metrics | 403 |
      | admin | adminpassword | /app-console/metrics | 200 |
      | admin | adminpassword | /api/greetings | 403 |
      | other | otherpassword | /api/greetings | 401 |
      | other | otherpassword | /app-console/metrics | 401 |