
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost

   Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I establish connection  DB for PR
    Then I read the values from PR table "tblPurchaseReturnHeader" in DB
    Then I read the values from PR table "tblAPtransaction" in DB
    Then I read the values from PR table "tblVendorBalance" in DB
    Then I read the values from PR table "tblPurchaseReturnDetail" in DB
    Then I close connection  DB for PR
    
     Examples: 
      | TestcaseRowName |
      |PR1|
