Feature: Master > Reason Master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Reason Master 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmReasonMaster.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtReasonCode" as "56" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtReasonDescription" as "hbhghj" 
	
	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --" 
	Then I need to select the dropdown "REPRINT" value forLabel "TranType" using Javascript 
	
	Then I need to invoke the DropDown by Index 1 if text matching "-- Select --" 
	Then I need to select the dropdown "A" value forLabel "additiondeduction" using Javascript 
	
	Then I click on the save button