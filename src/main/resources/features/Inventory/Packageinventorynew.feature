
@27062022
Feature:
 
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmPackageInventory.aspx"
    Then I load the testdatas form excel to table
    Then I load the Packageinventory sheet data to map
    Then I load the rowise Packageinventory data for "<TestcaseRowName>" rowname
    Then I update value to the Packageinventory page global Variables
    Then I fill new Packageinventory data page using excel data
    Then I need to click on the blue "AddToList" button
    Then I need to click on the "Update" button
    Then I establish connection  DB for Packageinventory
    Then I read the values from Packageinventory table "tblPackageHeader" in DB
    Then I read the values from Packageinventory table "tblPackageDetail" in DB
    Then I close connection  DB for Packageinventory
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |PackageInventory2|
      
      
      
   
   
