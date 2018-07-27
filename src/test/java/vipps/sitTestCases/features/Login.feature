Feature: Customer Enrollement 
Scenario: verify Customer Enrollement 
	Given Customer Enrollement Data 
		| tC     | userName | passWord | confirmPassword | expectedResult          | 
		| 001_TC | login   | abc      | abc             | login -- has been created |
	When OpenBrowser 
	When user will perform registration flow 
	When user will login into the system, verify that Login is success 
	Then CloseBrowser 
	
#Scenario: Shutdown system 
	#Then CloseSystem 