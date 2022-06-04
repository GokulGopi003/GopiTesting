Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Merchandising/frmAccountStatement.aspx"
    Then I load the testdatas form excel to table
    Then I load the AccountSettlement sheet data to map
    Then I load the rowise AccountSettlement data for "<TestcaseRowName>" rowname
    Then I update value to the AccountSettlement page global Variables
    Then I fill new AccountSettlement data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
   
    
    
     Examples: 
      | TestcaseRowName |
		  |AccountSettlement|