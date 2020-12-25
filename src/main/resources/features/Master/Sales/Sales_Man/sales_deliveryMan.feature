Feature: PoS Master > Sales > Sales man >Delivery man 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for SalesMan Master 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmDeliveryMan.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManId" as "5" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManName" as "Prabhu" 
	Then I click on the Active button 
	Then I click on the save button 
	
	