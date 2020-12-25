Feature: PoS Master > Sales >Cashier Master
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Cashier Master
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmCashier.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCashierID" as "654" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCashierName" as "kalai" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPassword" as "kalai455" 
	Then I click on the Active button 
	Then I click on the save button 