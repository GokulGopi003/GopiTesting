Feature: Master > Customer >Member Gift Voucher
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for  Member Gift Voucher
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMemberType.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherCode" as "675" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherAmt" as "098" 
	
	Then I enter the value forElement "#ContentPlaceHolder1_txtRewardUsagePoints" as "900" 
	
	Then I click on the save button