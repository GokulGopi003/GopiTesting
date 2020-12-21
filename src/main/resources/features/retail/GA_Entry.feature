Feature: As a GRN User validating the Shortcuts flows are configured as per the reuirement 

Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@unixpro 
Scenario: Check GRN_FOC,Wholeqty and bulkinventory 
	Then I click on Add "Purchase" 
	Then I click on a dropdown value "GA/GRN" 
	Then I need to click on a Addbutton