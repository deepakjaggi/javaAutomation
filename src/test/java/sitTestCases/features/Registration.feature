Feature: Customer Enrollement 
Scenario: verify Customer Enrollement 
	Given Customer Enrollement Data 
		| tC     | userName | passWord | confirmPassword | expectedResult          | 
		| 001_TC | deepak   | abc      | abc             | abc -- has been created |		
	When user will perform registration flow	
	