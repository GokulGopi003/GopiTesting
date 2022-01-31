Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPriceChangeNonBatch.aspx"
    Then I load the testdatas form excel to table
    Then I load the PriceChangeNonBatchItem sheet data to map
    Then I load the rowise PriceChangeNonBatchItem data for "<TestcaseRowName>" rowname
    Then I update value to the PriceChangeNonBatchItem page global Variables
    Then I fill new PriceChangeNonBatchItem data page using excel data
    Then I need to click on the blue "Update" button
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkBulkBatch"
    Then I establish connection  DB for PriceChangeNonBatchItem
    Then I read the values from PriceChangeNonBatchItem table "tblOutletPricingControl" in DB
    Then I read the values from PriceChangeNonBatchItem table "tblinventory" in DB
    Then I read the values from PriceChangeNonBatchItem table "tblinventorypricing" in DB
    Then I close connection  DB for PriceChangeNonBatchItem
    
     Examples: 
      | TestcaseRowName |
      |PriceChangeNonBatchItem2|
      
  
