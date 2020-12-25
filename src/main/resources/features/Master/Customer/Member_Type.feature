Feature: Master > Customer > member type 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for  member type 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMemberType.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCardType" as "wew" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "rwre" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtValidityPeriod" as "34" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCardPrice" as "32" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtRewardPoints" as "343" 
	
	Then I click on the Active button 
	Then I click on the save button