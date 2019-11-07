Feature: Customer Enrollement

  Scenario: verify Customer Enrollement
    Given Customer Enrollement Data
      | tC     | userName | passWord | confirmPassword | expectedResult            |
      | 001_TC | login    | abc      | abc             | login -- has been created |
    Given StartReporting
    When OpenBrowser
    When user will perform registration flow
    When user will login into the system, verify that Login is success
    Then CloseBrowser    

  Scenario: verify Customer Enrollement
    Given Customer Enrollement Data
      | tC     | userName | passWord | confirmPassword | expectedResult             |
      | 002_TC | deepak   | abc      | abc             | deepak -- has been created |    
    When OpenBrowser
    When user will perform registration flow
    When user will login into the system, verify that Login is success
    Then CloseBrowser
    Then CloseReporting
#Scenario: Shutdown system 
	#Then CloseSystem 
