Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying RePack Scheduling Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmRepackingList.aspx"
    Then I need to click on the link "Add" button
    #Then I need to click on the link "View" button
    #Then I need to click on the link "Delete" button
    #Then I need to click on the link "Refresh" button
    
    When I select radio button forElement "input#ContentPlaceHolder1_rbnBulk"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #search bulk item and click
    
    When I select radio button forElement "input#ContentPlaceHolder1_rbnGeneral"
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor" as "205"
    When Im waiting for 2 sec
    Then I need to click on Vendor with text matching "205"
    Then I need to click on the filter "Filter" button
    
    Then I click dynamically on "Update" button
    Then I click dynamically on "Delete" button
    #select all button
    Then I click dynamically on "Check" button
    
    
    
    
    
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dr	opdown "AMARJYOT" value forLabel "PackageInv" using Javascript
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
    
    
    
    
    
  	