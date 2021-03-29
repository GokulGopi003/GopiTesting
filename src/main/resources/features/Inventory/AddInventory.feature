Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory @addInventoryTest
    Scenario: Verifying Add Inventory Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BISCUITS"
    When Im waiting for 3 sec
    Then I need to click on link with text matching "BISCUITS"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrand.form-control-res" as "BELLA"
    When Im waiting for 3 sec
    Then I need to click on Brand with text matching "BRITANIA"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemName.form-control-res.ui-autocomplete-input" as "BISCUITS BRITANIA30"
    Then I need to click on Short Name forElement "input#ContentPlaceHolder1_txtShortName.form-control-res"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemType.form-control-res" as "BULK"
    When Im waiting for 3 sec
    Then I need to click on Item Type with text matching "BULK"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor.form-control-res" as "AKBAR AGENCIES"
    When Im waiting for 3 sec
    Then I need to click on Vendor with text matching "AKBAR AGENCIES"
    Then I need to click on Open Selling Detail forElement "input#ContentPlaceHolder1_imgPriceChange"
    Then I need to click on IGST DropDown forElement "div#ContentPlaceHolder1_ddlInputIGST_chzn.chzn-container.chzn-container-single"
    Then I need to click on IGST search forElement "div.chzn-search"
    Then I need to click on IGST value forElement "li#ContentPlaceHolder1_ddlInputIGST_chzn_o_2.active-result"
    Then I enter the HSN code forElement "input#ContentPlaceHolder1_txtHSNCode.form-control-res" as "4321"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMRP" as "120"
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtMRP" value as "120" using Javascript
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtBasicCost" value as "65" using Javascript
    Then I need to click to autopopulate forElement "div.dialog-inv-container-set-price-detail"
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "/Users/prabhu/Downloads/imageupload.jpeg"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemYes" button
    When Im waiting for 2 sec
    Then I need to click on the "ItemHistory" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "BISCUITS BRITANIA30"
    When Im waiting for 2 sec
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_grdInventoryList_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMinimumQty" as "10"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMaxQty" as "100"
    Then I need to click to autopopulate forElement "input#ContentPlaceHolder1_txtReOrderQty"
    Then I need to click on sub menu with text matching "Activation Settings"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkSelectAll"
    Then I need to click on sub menu with text matching "Stock & Purchase"
    Then I need to click on the blue "TransferDet" button
    When Im waiting for 3 sec
    Then I click on button tag with value "Close"
    Then I need to click on the blue "InvMovement" button
    When Im waiting for 3 sec
    Then I click on button tag with value "Close"
    When Im waiting for 5 sec
    Then I need to click on the blue "PRReq" button
    When Im waiting for 3 sec
    Then I click on button tag with value "Close"
    When Im waiting for 5 sec
    Then I need to click on the blue "Batch" button
    When Im waiting for 5 sec
    Then I click on button tag with value "Close"
    When Im waiting for 3 sec
    #Then I need to click on sub menu with text matching "Sales"
    #Then I select radio button forElement "input#ContentPlaceHolder1_rbnSalesWeek"
    #Then I select radio button forElement "input#ContentPlaceHolder1_rbnSalesDay"
    Then I need to click on sub menu with text matching "Child Inventory"
    Then I need to click on sub menu with text matching "Promotion"
    Then I need to click on the blue "LiveDetail" button
    Then I need to click on the "Save" button
    Then I click on button tag with value "Close"
    
    

    
  
    