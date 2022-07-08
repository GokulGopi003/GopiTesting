Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmStockUpdate.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockUpdate sheet data to map
    Then I load the rowise StockUpdate data for "<TestcaseRowName>" rowname
    Then I update value to the StockUpdate page global Variables
    Then I fill new StockUpdate data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I fill new Qty data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for StockUpdate
    Then I read the values from StockUpdate table "tblBatchStockTake" in DB
    #Then I read the values from StockUpdate table "tblPaymentDetail" in DB
    Then I close connection  DB for StockUpdate
    
    
     Examples: 
      | TestcaseRowName |
		  |StockUpdate|
		  |StockUpdate1|
		  |StockUpdate2|
		  |StockUpdate3|
		  |StockUpdate4|
		  |StockUpdate5|
		  |StockUpdate6|
		  |StockUpdate7|
		  |StockUpdate8|
		  |StockUpdate9|
		  |StockUpdate10|