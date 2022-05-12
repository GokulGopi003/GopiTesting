Feature: Home>Master>Inventory>Picker Master
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for Picker master 
	Given I want to launch the "Masters/frmPickerMaster.aspx" 
	Then I load the testdata form excel to table
	Then I load the PickerMasterNew sheet data to map
  Then I load the PickerMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the PickerMasterNew page global Variables
  Then I fill new PickerMasterNew data page using excel data
  Then I need to click on the "Save" button
  Then I establish connection to PickerMasterNew
  Then I read the values from table "tblPickerMaster" in PickerMasterNew
  Then I close connection to PickerMasterNew
  
    Examples: 
      |TestcaseRowName|
      |PickerMasterNew|
    
