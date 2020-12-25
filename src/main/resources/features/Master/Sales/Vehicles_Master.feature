Feature: PoS Master > Sales >Vehicles master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Vehicles master 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmVehicleMaster.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVehicleMasterCode" as "654" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDriverName" as "kalai" 
	Then I click on the save button 