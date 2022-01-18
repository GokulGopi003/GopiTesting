Feature: 
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmInventoryParameter.aspx"
    Then I load the testdatas form excel to table
    Then I load the InventoryParameter sheet data to map
    Then I load the rowise InventoryParameter data for "<TestcaseRowName>" rowname
    Then I update value to the InventoryParameter page global Variables
    Then I fill new InventoryParameter data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for InventoryParameter
    Then I read the values from InventoryParameter table "tblinventorybulkstock" in DB
    Then I read the values from InventoryParameter table "tblInventoryBulk" in DB
    Then I close connection  DB for InventoryParameter
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |InventoryParameter|
      
      
      
   
   
