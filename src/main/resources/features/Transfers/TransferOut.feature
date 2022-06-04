Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Transfer/frmTransferOut.aspx?id=TransferOut"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I load the testdatas form excel to table
    Then I load the TransferOut sheet data to map
    Then I load the rowise TransferOut data for "<TestcaseRowName>" rowname
    Then I update value to the TransferOut page global Variables
    Then I fill new TransferOut data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkTransfer"
    Then I establish connection  DB for TransferOut
    Then I read the values from TransferOut table "tblBatchInventoryControl" in DB
    Then I read the values from TransferOut table "tblTransferInventoryDetail" in DB
    Then I read the values from TransferOut table "tblinventorystock" in DB
    Then I close connection  DB for TransferOut
    
    
     Examples: 
      | TestcaseRowName |
      |TransferOut|