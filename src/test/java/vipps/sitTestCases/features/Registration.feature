Feature: Customer Enrollement 
Scenario: verify Customer Enrollement 
	Given Customer Enrollement Data 
		| tC     | userName | passWord | confirmPassword | expectedResult          | 
		| 001_TC | deepak   | abc      | abc             | deepak -- has been created |
	When OpenBrowser
	When user will perform registration flow
	Then CloseBrowser	
	
	
	
Scenario: verify Customer Enrollement 
	Given Customer Enrollement Data 
		| tC     | userName | passWord | confirmPassword | expectedResult          | 
		| 002_TC | deepak2   | abc      | abc             | deepak2 -- has been created |
	When OpenBrowser		
	When user will perform registration flow
	Then CloseBrowser	 
		
		
Scenario: Shutdown system
	Then CloseSystem 