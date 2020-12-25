Feature: PoS Master > Sales >Price Type
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Price Type
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmPricetype.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPricetypeCode" as "654" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai" 
	Then I click on the Active button 
	Then I click on the save button 