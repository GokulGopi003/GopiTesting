Feature: PoS Master > Sales > Sales man >commission brand
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Commission Brand
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManCommissionBrand.aspx" 
	
	
	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forLabel "BrandCode" using Javascript
	Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "5" 
	Then I enter the value forElement "input#ContentPlaceHolder1_txtCommission" as "23" 
	Then I click on the save button 