Feature: master > Purchase > Agent Master   #some defects in this scenario

Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: check the  Agent Master 
	Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmAgent.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtAgentName" as "kalai00" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtAddress1" as "karappakam,chennai" 
	Then I click on the save button 
	Then I click on the view button 
	
	
	