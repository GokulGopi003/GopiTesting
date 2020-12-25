Feature: PoS Master > Sales > Sales man > SalesMan Master 

Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for SalesMan Master 
	Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManMaster.aspx" 
	Then I enter the SalesMan ID "53" 
	Then I need enter the Employee Code "01" 
	Then I enter the value forElement "input#ContentPlaceHolder1_txtSalesManName" as "Prabhu" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCommission" as "45" 
	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "rrr" value forLabel "Location" using Javascript
	Then I click on the Active button 
	Then I click on the save button 
	