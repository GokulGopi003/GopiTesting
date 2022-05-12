Feature: Home>Master>Customer>Customer Master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for Customer master 
	Given I want to launch the "Masters/frmCustomerMasterView.aspx" 
	Then I need to click on the "New" button2
	Then I load the testdata form excel to table
	Then I load the CustomerNew sheet data to map
  Then I load the CustomerNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the CustomerNew page global Variables
  Then I fill new CustomerNew data page using excel data
  Then I need to click on sub menu with text matching "Other Details"
  Then I fill Other Details
  Then I need to click on the "Save" button
  Then I establish connection to CustomerNew
  Then I read the values from table "TBL_CUSTOMER_MASTER" in CustomerNew
  Then I close connection to CustomerNew
	
    Examples: 
      |TestcaseRowName |
      |CustomerNew|
     
