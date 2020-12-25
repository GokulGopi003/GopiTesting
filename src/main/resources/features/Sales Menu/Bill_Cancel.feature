Feature: Sales > Bill Cancel 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for  Bill Cancel 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBillCancel.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCardType" as "wew" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "rwre" 