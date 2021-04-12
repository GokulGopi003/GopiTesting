Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Inventory Barcode Functionality
    Given I want to launch the "Inventory/Barcode.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInventoryCode" as "205"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtQty" as "20"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBefore" as "189"
    Then I need to click on IGST DropDown forElement "div#ContentPlaceHolder1_ddlTemplate_chzn.chzn-container.chzn-container-single"
    Then I need to click on IGST value forElement "li#ContentPlaceHolder1_ddlTemplate_chzn_o_2.active-result"
    Then I click dynamically on "btnPrint" button   
    
  	