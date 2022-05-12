Feature: Home>Master>Sales>Sales Man>ItemWise Sale Man Commission>Sales Man Commission By Item List
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for SalesMan Commission 
	Given I want to launch the "Masters/frmSalesManCommissionItemsView.aspx" 
	
	Then I load the testdata form excel to table
	Then I load the SalesManComission sheet data to map
  Then I load the SalesManComission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the SalesManComission page global Variables
  Then I fill new SalesManComission data page using excel data
	Then I need to click on the "Button11" button3
  Then I establish connection to SalesManComission
  Then I read the values from table "tblSalesManCommissionItem" in SalesManComission
  Then I close connection to SalesManComission 
	
	
    Examples: 
      |TestcaseRowName|
      |SalesManComission|
      
