Feature: PoS Master > Sales > POS Payment 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario: checking for POS Payment 
	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmPosPayment.aspx" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPaymentCode" as "52" 
	Then I enter the value forElement "#ContentPlaceHolder1_txtPaymentDesc" as "kalai" 
	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --" 
	Then I need to select the dropdown "EXPN" value forLabel "TranType" using Javascript 
	Then I click on the save button 