Feature: Browser Automation
  
Scenario: I want to do Browser Automation 

	Given I open Chrome Browser 
	When I navigate to google.com 
	And search for "string" 
	Then first search result should be "string"