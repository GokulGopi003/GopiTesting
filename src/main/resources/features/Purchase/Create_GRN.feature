Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnGrn_0"
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Yes" button
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    #When Im waiting for 2 sec
    #Then I want to minimize the browser
    #Then I need to click on the "Save" button
    #Then I need to click on the blue "Save" button`
    Then I establish connection GRN to DB 
    Then I read the values GRN from table "TBLGIDDETAIL" in DB
    Then I read the values GRN from table "TBLGIDHEADER" in DB
    #Then I read the values GRN from table "tblinventory" in DB
    #Then I read the values GRN from table "tblinventorypricing" in DB
    #Then I read the values GRN from table "tblinventorystock" in DB
    #Then I read the values GRN from table "tblBatchInventoryControl" in DB
    #Then I read the values GRN from table "tblInventoryShelfQty" in DB
    Then I close connection GRN to DB
    
    Examples: 
      | TestcaseRowName |
      |GRN202           |

      