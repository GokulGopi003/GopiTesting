Feature: PoS Master > Sales > Voucher > voucher 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for voucher 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmVoucher.aspx"
		Then I enter the value forElement "#ContentPlaceHolder1_txtGroupCode" as "5" 
		Then I enter the value forElement "#ContentPlaceHolder1_txtGroupName" as "kalai" 
		Then I enter the value forElement "#ContentPlaceHolder1_txtCommission" as "5" 
		Then I enter the value forElement "#ContentPlaceHolder1_txtServiceCharge" as "5" 
		Then I click on the save button 