Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Package Inventory Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmPackageInventory.aspx"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "AMARJYOT" value forLabel "PackageInv" using Javascript
    Then I click on the checkBox forElement "input#ContentPlaceHolder1_chkFestival"
    Then I need to click on table forelement ""
    Then I need to click alert ok
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInventory.form-control-res" as "BISCUITS BRITANIA1"
    When Im waiting for 3 sec
    Then I need to click on link with text matching "BISCUITS BRITANIA1"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtQty.form-control-res" as "10"
    Then I need to click on the  element "table#ContentPlaceHolder1_gvBatchDetails.pshro_GridDgn.grdLoad"
    Then I click dynamically on "AddToList" button
    Then I click dynamically on "Update" button
    #Then I click dynamically on "Delete" button
    #Then I click dynamically on "Clear" button
    
    #handle null table - element not traceable exception
    
    
    
    
    
  	