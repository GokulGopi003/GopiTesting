Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPurchaseReturnList.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdPurchaseReturnList_btnVendorChange_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdPurchaseReturnList > tbody > tr > td:nth-child(1) > input[type=button]"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the  element "div#ContentPlaceHolder1_ReturnTypeDropDown_chzn"
    #Then I need to select the Vendor "RETURN" value forLabel "ReturnType" using Javascript  
    Then I load the testdatas form excel to table
    Then I load the PRR sheet data to map
    Then I load the rowise PRR data for "<TestcaseRowName>" rowname
    Then I update value to the PRR page global Variables
    Then I fill new PRR data page using excel data       
    When Im waiting for 2 sec
    Then I need to click on the "Add" button
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    Then I establish connection  DB for PRR
    Then I read the values from PRR table "tblPurchaseReturnReqDetail" in DB
    Then I read the values from PRR table "tblPurchaseReturnReqHeader" in DB
    Then I close connection  DB for PRR
    
    
    
     Examples: 
      | TestcaseRowName |
      |PRR           |