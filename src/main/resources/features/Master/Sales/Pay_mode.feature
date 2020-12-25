Feature: PoS Master > Sales >pay mode 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for Pay mode 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmPayMode.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPosition" as "654" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPayMode" as "kalai" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtCommission" as "65" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtServiceCharge" as "90" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtGLAccountCode" as "88" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtDiscount" as "11" 
	Then I click on the Active button 
	Then I click on the save button 