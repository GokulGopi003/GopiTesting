Feature: PoS Master > Vendor master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for Vendor master 
	Given I want to launch the "Masters/frmVendorView.aspx" 
	Then I need to click on the "Back" button1
	Then I load the testdata form excel to table
	Then I load the VendorMaster sheet data to map
  Then I load the VendorMaster rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the VendorMaster page global Variables
  Then I fill new VendorMaster data page using excel data
  Then I need to click on the "Save" button
	Then I establish connection to VendorMaster
  Then I read the values from table "tblvendor" in VendorMaster
  Then I close connection to VendorMaster 
	
	
	
	 Examples: 
      | TestcaseRowName|
      |VendorMaster|
      |VendorMaster1|
      |VendorMaster2|
      |VendorMaster3|
      |VendorMaster4|
      |VendorMaster5|
      |VendorMaster6|
      |VendorMaster7|
      |VendorMaster8|
      |VendorMaster9|
      |VendorMaster10|
      
	
	
	