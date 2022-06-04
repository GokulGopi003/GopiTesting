Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Transfer/frmTransferIn.aspx?id=TransferIn"
    Then I load the testdatas form excel to table
    Then I load the TransferIn sheet data to map
    Then I load the rowise TransferIn data for "<TestcaseRowName>" rowname
    Then I update value to the TransferIn page global Variables
    Then I fill new TransferIn data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAccept"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for TransferIn
    Then I read the values from TransferIn table "LocalTransferInventoryDetail" in DB
    Then I read the values from TransferIn table "LocalTransferInventoryHEADER" in DB
    Then I close connection  DB for TransferIn
    
    
     Examples: 
      | TestcaseRowName |
      |TransferIn1|