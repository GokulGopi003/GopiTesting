Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPriceChangeBatch.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkBulkBatch"
    Then I load the testdatas form excel to table
    Then I load the PriceChangeBatchItem sheet data to map
    Then I load the rowise PriceChangeBatchItem data for "<TestcaseRowName>" rowname
    Then I update value to the PriceChangeBatchItem page global Variables
    Then I fill new PriceChangeBatchItem data page using excel data
    Then I need to click on the blue "Update" button
    Then I establish connection  DB for PriceChangeBatchItem
    Then I read the values from PriceChangeBatchItem table "tblinventory" in DB
    Then I read the values from PriceChangeBatchItem table "tblinventorypricing" in DB
     Then I read the values from PriceChangeBatchItem table "tblinventorystock" in DB
    Then I read the values from PriceChangeBatchItem table "TBLBATCHINVENTORYCONTROL" in DB
    Then I close connection  DB for PriceChangeBatchItem
    
     Examples: 
      | TestcaseRowName |
      |PriceChangeBatchItem2|
      
  
