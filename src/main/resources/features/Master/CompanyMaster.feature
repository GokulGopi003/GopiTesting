
Feature: Home>Master>Company Master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for Company master 
	Given I want to launch the "Masters/frmCompanyMaster.aspx" 
	Then I load the testdata form excel to table
	Then I load the CompanyMaster sheet data to map
  Then I load the CompanyMaster rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the CompanyMaster page global Variables
  Then I fill new CompanyMaster data page using excel data
  Then I need to click on the "Save" button
	Then I establish connection to CompanyMaster
  Then I read the values from table "tblcompany" in CompanyMaster
  Then I close connection to CompanyMaster 
	

    Examples: 
      |TestcaseRowName|
      |CompanyMaster|
     
