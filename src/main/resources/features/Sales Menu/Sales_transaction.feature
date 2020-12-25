Feature: Sales >Sales_transaction
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for  Sales_transaction
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Sales/frmSalesTransaction.aspx"