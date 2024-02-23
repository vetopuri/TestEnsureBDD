Feature: Login Functionality

  @moduleStart
  Scenario: It should process a sentence
    Given Start Execution "65d84da8a4d0288fa07540c8"
    
  Scenario: LOGIN_001 
    Given User navigates to the website "65d84da8a4d0288fa07540c9" "65d84da8a4d0288fa07540ca" "65d84da8a4d0288fa07540cb"
    
  Scenario: LOGIN_002
    When User Enters Username "65d84da8a4d0288fa07540cc" "65d84da8a4d0288fa07540cd" "65d84da8a4d0288fa07540ce"
    When User Enters Password "65d84da8a4d0288fa07540cc" "65d84da8a4d0288fa07540cd" "65d84da8a4d0288fa07540cf"
    When User clicks on LoginButton "65d84da8a4d0288fa07540cc" "65d84da8a4d0288fa07540cd" "65d84da8a4d0288fa07540d0"

  Scenario: LOGIN_003
    Then Login must be successful "65d84da8a4d0288fa07540d1" "65d84da8a4d0288fa07540d2" "65d84da8a4d0288fa07540d3"

  @moduleEnd
  Scenario: It should process a sentence
    Then Stop Execution
  