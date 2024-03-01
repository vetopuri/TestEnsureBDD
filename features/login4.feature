Feature: Login Functionality

  @moduleStart
  Scenario Outline: It should process a sentence
    Given Start Execution <job_id>
    
  Scenario: LOGIN_001
    Given User navigates to the website
    
  Scenario: LOGIN_002
    When User login with Username and Password

  Scenario: LOGIN_003
    Then Login must be successful

  @moduleEnd
  Scenario: It should process a sentence
    Then Stop Execution
  