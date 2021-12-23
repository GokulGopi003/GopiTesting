
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I establish connection to DB
    Then I read the values from table "tblinventory" in DB
    Then I read the values from table "tblinventorypricing" in DB
    Then I read the values from table "tblinventorystock" in DB
    Then I read the values from table "tblbarcode" in DB
    Then I read the values from table "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table "tblInventoryShelfQty" in DB
    Then I close connection to DB
       Examples: 
      | TestcaseRowName |
      | cost1          |