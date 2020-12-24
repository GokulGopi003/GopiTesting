Feature: PoS Master > Inventory

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@inventory @BaseUOM
  #Scenario: Home > Master> Inventory> BaseUOM
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBaseUOM.aspx"
  #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  #Then I need to select the dropdown "TON" value forLabel "UOMCode" using Javascript
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtUOMDescription" as "1548780"
  #Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
  #Then I need to select the dropdown "CFT" value forLabel "BaseUOMCode" using Javascript
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtBaseUOMDescription" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtUnit" as "4"
  #@inventory @BaseUOM
  #Scenario: Home > Master> Inventory> BaseUOM
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmAddition_Deduction.aspx"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscountCode" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  #Then I need to select the dropdown "A" value forLabel "type" using Javascript
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkGst"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtGstPer" as "1548780"
  #
  #@inventory @BaseUOM
  #Scenario: Home > Master> Inventory> BaseUOM
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmZone.aspx"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtZoneCode" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtZoneName" as "1548780"
  #@inventory @CompanySettings
  #Scenario: Home > Master> Inventory> Company Settings
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmCompanySettings.aspx"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtCompanyCode" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtCompanyName" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txttinno" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtinvoiceno" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtremarks" as "1548780"
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_txtDate"
  #And I click on the checkBox forElement "a.ui-state-default.ui-state-highlight"
  #
  #@inventory @CompanySettings
  #Scenario: Home > Master> Inventory> Stock Adjustment
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmStockAdjustment.aspx"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtStockAdjustTypeCode" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtStockAdjustTypeName" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtSort.form-control" as "1548780"
  #When I select radio button forElement "input#ContentPlaceHolder1_rbtBatch"
  #When I select radio button forElement "input#ContentPlaceHolder1_RadDeduct"
  #
  #@inventory @CompanySettings
  #Scenario: Home > Master> Inventory> Merchandise
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMerchandise.aspx"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtMerchandise" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemark" as "1548780"
  @inventory @Manufacturer
  Scenario: Home > Master> Inventory> Manufacturer
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmManufacturer.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtManufacturerCode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtManufacturerName" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress1" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress2" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress3" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtpincode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_TxtEmail" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtphone" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFax" as "1548780"

  @inventory @Manufacturer
  Scenario: Home > Master> Inventory> Manufacturer
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmOrigin.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtOriginCode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  @inventory @Manufacturer
  Scenario: HomeMasterInventoryTransport
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmTransport.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtTransportName" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtContPerson" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAddress1" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAddress2" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPhoneNo" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMobNo" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_TxtEmail" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFax" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUrl" as "1548780"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
