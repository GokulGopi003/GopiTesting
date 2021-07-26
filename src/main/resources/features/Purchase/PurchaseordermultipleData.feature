Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

  

  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmPurchaseOrderView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPO_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnDelete_0"
    #Then I need to click on the blue "Yes" button
    Then I load the testdatas form excel to table
    Then I load the PO sheet data to map
    Then I load the rowise PO data for "<TestcaseRowName>" rowname
    Then I update value to the PO page global Variables
    Then I fill new PO data page using excel data
    When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_0" as "1"
    #Then I enter the send Keys "input#ContentPlaceHolder1_txtItemCodeAdd" as "F3"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    When Im waiting for 2 sec
    Then I need to click on the blue "AddInv" button
    #Then I need to click on the page
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAddInv"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    #Then I need to click on the  Xpath "/html/body/div[5]/div[3]/div/button"
    #SThen I need to search vendor
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoad"
    #Then I need to click on the  element "a#ContentPlaceHolder1_gvPO_lnkApporve_0"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    
    
    
     Examples: 
      | TestcaseRowName |
      |PO           |
      
      
   Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost     
      
    Then I load the testdatas form excel to table
    Then I load the PO sheet data to map
    Then I load the rowise PO data for "<TestcaseRowName>" rowname
    Then I update value to the PO page global Variables
    Then I fill new PO data page using excel data
    Then I need to click on the blue "AddInv" button
    Then I need to click on the blue "Save" button
     Examples: 
      | TestcaseRowName |
      |PO2           |
      