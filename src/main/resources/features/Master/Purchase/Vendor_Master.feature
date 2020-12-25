Feature: PoS Master > Vendor master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Vendor master 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmVendorView.aspx" 
	Then I click on the new button 
	#Then I enter the  value "A" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVendorName" as "A" 
	Then I click on a dropdown value  "A.A.AGENCIES" 
	
	
	