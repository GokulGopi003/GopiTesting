
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
  Then I load the testdatas form excel to table
    Then I load the Packageinventory sheet data to map
    Then I load the rowise Packageinventory data for "<TestcaseRowName>" rowname
    Then I update value to the Packageinventory page global Variables
    Then I establish connection  DB for Packageinventory
    Then I read the values from Packageinventory table "tblPackageHeader" in DB
    Then I read the values from Packageinventory table "tblPackageDetail" in DB
    Then I close connection  DB for Packageinventory
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |PackageInventory|