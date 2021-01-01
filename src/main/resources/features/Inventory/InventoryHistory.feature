Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Inventory History Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMasterView.aspx"
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "BISCUITS BRITANIA12"
    Then I click dynamically on "SearchGrid" button
    Then I click on the "input#ContentPlaceHolder1_grdInventoryList_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemName" as "BISCUITS BRITANIA12 Edited"
    Then I need to click on the "Save" button
    Then I click on button tag with value "Ok"
    When Im waiting for 2 sec
    Then I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMasterView.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "BISCUITS BRITANIA12"
    Then I click dynamically on "SearchGrid" button
    When Im waiting for 2 sec