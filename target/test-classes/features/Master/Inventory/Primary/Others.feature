Feature: PoS Master > Inventory  @pending_edit_delete

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory @Department
  Scenario: Home > Master > Inventory > Section
  	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSection.aspx"
  	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  	Then I need to select the dropdown "AA" value forLabel "FloorCode" using Javascript
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtSectionCode" as "1548780"
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  
  @inventory @Department
  Scenario: Home > Master > Inventory > Bin
  	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBin.aspx"
  	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  	Then I need to select the dropdown "ASDF" value forLabel "sectionCode" using Javascript
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtBinCode" as "1548780"
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  
  @inventory @Department
  Scenario: Home > Master > Inventory > Shelf
  	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmshelf.aspx"
  	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  	Then I need to select the dropdown "FDJBDAF" value forLabel "BinCode" using Javascript
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtShelfCode" as "1548780"
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
  
  @inventory @Department
  Scenario: Home > Master > Inventory > Ware House
  Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmWarehouse.aspx"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtWareHouseCode" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtWareHouseName" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress1" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress2" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtaddress3" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtpincode" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtphone" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtFax" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtItemTypeCode" as "1548780"
  Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  Then I need to select the dropdown "NETCOST" value forLabel "NetCost" using Javascript
  Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
  Then I need to select the dropdown "A" value forLabel "Type" using Javascript
  
  @inventory @Department
  Scenario: Home > Master > Inventory > Section
  Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSize.aspx"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtSizeCode" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
    @inventory @Department
  Scenario: Home > Master > Inventory > Style
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmstyle.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtStyleCode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPackage" as "1548780"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CLEANING" value forLabel "Department" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "BABY OIL" value forLabel "Category" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "777" value forLabel "Brand" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "Prabhu" value forLabel "Vendor" using Javascript
    Then I need to invoke the DropDown by Index 4 if text matching "-- Select --"
    Then I need to select the dropdown "baby toys" value forLabel "ItemType" using Javascript
    Then I need to invoke the DropDown by Index 5 if text matching "-- Select --"
    Then I need to select the dropdown "HQ" value forLabel "WareHouse" using Javascript
    Then I need to invoke the DropDown by Index 6 if text matching "-- Select --"
    Then I need to select the dropdown "AGRO" value forLabel "Manufauture" using Javascript
    Then I need to invoke the DropDown by Index 7 if text matching "-- Select --"
    Then I need to select the dropdown "DELETE" value forLabel "Merchandise" using Javascript
    Then I need to invoke the DropDown by Index 8 if text matching "-- Select --"
    Then I need to select the dropdown "India" value forLabel "Origin" using Javascript
    Then I need to invoke the DropDown by Index 9 if text matching "-- Select --"
    Then I need to select the dropdown "SRI" value forLabel "ccode" using Javascript
    Then I need to invoke the DropDown by Index 10 if text matching "-- Select --"
    Then I need to select the dropdown "C" value forLabel "Vat" using Javascript
    Then I need to invoke the DropDown by Index 11 if text matching "-- Select --"
    Then I need to select the dropdown "FOURTH FLOOR" value forLabel "Floor" using Javascript
    Then I need to invoke the DropDown by Index 12 if text matching "-- Select --"
    Then I need to select the dropdown "ADSF" value forLabel "Section" using Javascript
    Then I need to invoke the DropDown by Index 13 if text matching "-- Select --"
    Then I need to select the dropdown "KJFDS" value forLabel "Bin" using Javascript
    Then I need to invoke the DropDown by Index 14 if text matching "-- Select --"
    Then I need to select the dropdown "JDFJG" value forLabel "Shelf" using Javascript
    Then I need to invoke the DropDown by Index 15 if text matching "-- Select --"
    Then I need to select the dropdown "KGS" value forLabel "uompurchase" using Javascript
    Then I need to invoke the DropDown by Index 16 if text matching "-- Select --"
    Then I need to select the dropdown "KGS" value forLabel "Sales" using Javascript
    Then I need to invoke the DropDown by Index 17 if text matching "-- Select --"
    Then I need to select the dropdown "Stock" value forLabel "stocktype" using Javascript
