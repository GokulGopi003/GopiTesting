Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryStockReset.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockReset sheet data to map
    Then I load the rowise StockReset data for "<TestcaseRowName>" rowname
    Then I update value to the StockReset page global Variables
    Then I fill new StockReset data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I establish connection  DB for StockReset
    Then I read the values from StockReset table "tblBatchInventoryControl" in DB
    Then I read the values from StockReset table "tblinventorystock" in DB
    Then I read the values from StockReset table "tblInventoryStockReset" in DB
    Then I close connection  DB for StockReset
    
    
     Examples: 
      | TestcaseRowName |
      |StockReset|
      |StockReset1|
      |StockReset2|
      |StockReset3|
      |StockReset4|
      |StockReset5|
      |StockReset6|
      |StockReset7|
      |StockReset8|
      |StockReset9|
      |StockReset10|