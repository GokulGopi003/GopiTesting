Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Add Inventory Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BABY OIL"
    Then I need to click on link with text matching "BABY OIL"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrand.form-control-res" as "JOHNSON"
    Then I need to click on Brand with text matching "JOHNSON"
    Then I need to click on Short Name forElement "input#ContentPlaceHolder1_txtShortName.form-control-res"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemType.form-control-res" as " "
    Then I need to click on Item Type with text matching "BULK"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor.form-control-res" as "ALLWIN AGENCIES"
    Then I need to click on Vendor with text matching "ALLWIN AGENCIES"
    Then I need to click on Open Selling Detail forElement "input#ContentPlaceHolder1_imgPriceChange"
    Then I need to click on IGST DropDown forElement "div#ContentPlaceHolder1_ddlInputIGST_chzn.chzn-container.chzn-container-single"
    Then I need to click on IGST search forElement "div.chzn-search"
    Then I need to click on IGST value forElement "li#ContentPlaceHolder1_ddlInputIGST_chzn_o_2.active-result"
    Then I enter the HSN code forElement "input#ContentPlaceHolder1_txtHSNCode.form-control-res" as "4321"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMRP" as "120"
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtMRP" value as "120" using Javascript
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtBasicCost" value as "65" using Javascript
    Then I need to click on set price detail forElement "div.dialog-inv-container-set-price-detail"
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "/Users/prabhu/Downloads/imageupload.jpeg"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemYes" button
    #Check edit option
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMasterView.aspx"
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "JOHNSON BRUSH BABY OIL"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_grdInventoryList_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemName" as "JOHNSON BABY OIL Edited"
    Then I need to click on the "Save" button
    Then I click on button tag with value "Ok"
    When Im waiting for 2 sec
    Then I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMasterView.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "JOHNSON BABY OIL Edited"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    
  
    