Feature: PoS Master > Sales >home delivery tray 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for home delivery tray 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmHomeDeliveryTrayMaster.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtBagCode" as "654" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai" 
	Then I click on the save button