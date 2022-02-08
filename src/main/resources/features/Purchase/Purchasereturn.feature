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
    Given I want to launch the "Purchase/frmPurchaseReturnView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I update value to the PR page global Variables
    Then I fill new PR data page using excel data
    When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorItem_txtLQty_0" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_1" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_2" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_3" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_4" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_5" as "1"
    #Then I enter the send Keys "input#ContentPlaceHolder1_txtItemCodeAdd" as "F3"
    #When Im waiting for 2 sec
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    Then I establish connection  DB for PR
    Then I read the values from PR table "tblPurchaseReturnHeader" in DB
    Then I read the values from PR table "tblAPtransaction" in DB
    Then I read the values from PR table "tblVendorBalance" in DB
    Then I read the values from PR table "tblPurchaseReturnDetail" in DB
    Then I close connection  DB for PR
    
    
     Examples: 
      | TestcaseRowName |
      |PR1           |