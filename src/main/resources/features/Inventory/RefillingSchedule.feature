Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Refilling Schedule Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmRefillingSchedule.aspx"
    Then I click dynamically on "Filter" button
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControlForDialogBox_txtVendor.form-control-res" as "205"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I need to click on the dialogbox "Filter" button
    And I click on the checkBox forElement "input#ContentPlaceHolder1_gvReFillSchedule_cbSelect_0"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvReFillSchedule_txtReFillQty_0" as "10"
    Then I click dynamically on "Save" button
    Then I click dynamically on "Print" button 
    
    
    
    
  	