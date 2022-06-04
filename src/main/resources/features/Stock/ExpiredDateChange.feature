Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmExpiredDateChange.aspx"
    Then I load the testdatas form excel to table
    Then I load the ExpiredDateChange sheet data to map
    Then I load the rowise ExpiredDateChange data for "<TestcaseRowName>" rowname
    Then I update value to the ExpiredDateChange page global Variables
    Then I fill new ExpiredDateChange data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for ExpiredDateChange
    Then I read the values from ExpiredDateChange table "tblBatchInventoryControl" in DB
    Then I read the values from ExpiredDateChange table "tblExpireDate_Modification" in DB
    Then I close connection  DB for ExpiredDateChange
    
    
     Examples: 
      | TestcaseRowName |
      |ExpiredDateChange|