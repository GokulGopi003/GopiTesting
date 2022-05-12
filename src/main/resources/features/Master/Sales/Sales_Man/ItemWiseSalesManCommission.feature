Feature: Home>Master>Sales>Sales Man>ItemWise Sale Man Commission
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmSalesManCommissionItemWise.aspx"
  Then I load the testdata form excel to table
	Then I load the ItemWiseSalesManCommission sheet data to map
  Then I load the ItemWiseSalesManCommission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ItemWiseSalesManCommission page global Variables
  Then I fill new ItemWiseSalesManCommission data page using excel data
  Then I need to click on the "Button11" button3
  Then I fill Add the Item
	Then I need to click on the "Add" button4
	When Im waiting for 2 sec
	Then I need to click on the "Update" button5
	Then I need to click on the "Button3" button6
	Then I need to click on the "Button2" button7
	Then I establish connection to ItemWiseSalesManCommission
  Then I read the values from table "tblSalesManCommissionItem" in ItemWiseSalesManCommission
  Then I close connection to ItemWiseSalesManCommission
  # Given I want to launch the "Masters/frmSalesManCommissionItemsView.aspx"


    Examples: 
      |TestcaseRowName|
      |ItemWiseSalesManCommission|
      
