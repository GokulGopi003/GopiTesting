Feature: PoS Master > Location 

Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: check the location 
	Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmLocationMaster.aspx" 
	Given I need to enter the location code "dfd" 
	Then I text the location name "TUTICORIN" 
	Then I text the incharge name "kalaimathy" 
	Then I enter the SortCode "5" 
	Then I click on the warehouse button 
	Then I need to select the dropdown value as "1ST FLOOR" for warehouse 
	Then I click on the save button 
	
	
	