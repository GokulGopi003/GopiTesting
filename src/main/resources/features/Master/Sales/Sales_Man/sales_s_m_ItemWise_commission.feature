Feature: PoS Master > Sales > Sales man >ItemWise commission
Background: 
	As a unixpro user i want to launch the valid URL
	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Itemwise Commission 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManCommissionItemWise.aspx" 
	