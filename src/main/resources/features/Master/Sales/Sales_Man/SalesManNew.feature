Feature: Master > Sales > Sales man > SalesMan Master   #just referance scenario for SalesMan Master1

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: checking for SalesMan Master
  Given I want to launch the "Masters/frmSalesManMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the SalesManNew sheet data to map
  Then I load the SalesManNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the SalesManNew page global Variables
  Then I fill new SalesManNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to SalesManNew
  Then I read the values from table "tblSalesMan" in SalesManNew
  Then I close connection to SalesManNew

    Examples: 
      |TestcaseRowName  |
      |SalesManNew |
      |SalesManNew1 |
      |SalesManNew2 |
      |SalesManNew3 |
      |SalesManNew4 |
      |SalesManNew5 |
      |SalesManNew6 |
      |SalesManNew7 |
      |SalesManNew8 |
      |SalesManNew9 |
      |SalesManNew10 |
     
