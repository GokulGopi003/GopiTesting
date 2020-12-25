Feature: Master > Customer > Loyalty Item
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Loyalty Item
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmLoyaltyTerm.aspx"
	Then I enter the value forElement "#ContentPlaceHolder1_txtBaseAmount" as "343" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtBasePoint" as "2" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVouchervalue" as "4" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherpoints" as "23" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPeriods" as "345" 
	Then I click on the save button