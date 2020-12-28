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
    #Then I need to click on Inventory menu with text matching "Inventory"
    #Then I need to invoke the DropDown by Index 0 if text matching "Add Inventory"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BABY DRESS"
    Then I need to click on Category with text matching "BABY DRESS"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrand.form-control-res" as "APPLE"
    Then I need to click on Brand with text matching "APPLE"
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
    Then I enter the MRP forElement "input#ContentPlaceHolder1_txtMRP.form-control-res.text-right" as "120"
    Then I enter the Basic Cost forElement "input#ContentPlaceHolder1_txtBasicCost.form-control-res.text-right" as "65"
    Then I need to click on set price detail forElement "div.dialog-inv-container-set-price-detail"