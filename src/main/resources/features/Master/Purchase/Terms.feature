Feature: master > Purchase >  terms 

Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: check the terms 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmTerms.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtTermsCode" as "987" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "karappakam,chennai" 
	Then I click on the Active button
	Then I click on the save button 