
Feature: Home>Master>Company Master 

  Background: 
    As a unixpro user i want to launch the valid URL

   Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @tag2
  Scenario Outline: Home > Master > ReasonMaster
  Given I want to launch the "Managements/frmSalesPerformance.aspx" 
	Then I load the testdata form excel to table
	Then I load the SalesPerformance sheet data to map
  Then I load the SalesPerformance rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the SalesPerformance page global Variables
  Then I fill new SalesPerformance data page using excel data
  #Then I fill new Filteration data page using excel data
  Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData"
	
    Examples: 
      |TestcaseRowName  |
      |SalesPerformance4|
      
