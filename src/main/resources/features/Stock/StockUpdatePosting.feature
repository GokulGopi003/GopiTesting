Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmStockUpdatePosting.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockUpdatePosting sheet data to map
    Then I load the rowise StockUpdatePosting data for "<TestcaseRowName>" rowname
    Then I update value to the StockUpdatePosting page global Variables
    Then I fill new StockUpdatePosting data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for StockUpdatePosting
    Then I read the values from StockUpdatePosting table "tblStockTakeAdjustment" in DB
    Then I read the values from StockUpdatePosting table "vwInventoryStockLoc" in DB
    Then I close connection  DB for StockUpdatePosting
    
    
     Examples: 
      | TestcaseRowName |
      |StockUpdatePosting|