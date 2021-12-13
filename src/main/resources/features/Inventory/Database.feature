
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I establish connection to DB
    Then I read the values from table MRP1 "tblinventory" in DB
    Then I read the values from table MRP1 "tblinventorypricing" in DB
    Then I read the values from table MRP1 "tblinventorystock" in DB
    Then I read the values from table MRP1 "tblbarcode" in DB
    Then I read the values from table MRP1 "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP1 "tblInventoryShelfQty" in DB
    Then I close connection to DB
       Examples: 
      | TestcaseRowName |
      | MRP4           |