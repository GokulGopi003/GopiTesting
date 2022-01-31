
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost

    Then I load the testdatas form excel to table
    Then I load the FreeItem sheet data to map
    Then I load the rowise FreeItem data for "<TestcaseRowName>" rowname
    Then I update value to the FreeItem page global Variables
    Then I establish connection  DB for FreeItem
    Then I read the values from FreeItem table "tblFreeItemGroup" in DB
    Then I read the values from FreeItem table "tblQualifyingItemsForFree" in DB
    Then I read the values from FreeItem table "tblfreeitemslist" in DB
    Then I close connection  DB for FreeItem
    
     Examples: 
      | TestcaseRowName |
      |FreeItem|