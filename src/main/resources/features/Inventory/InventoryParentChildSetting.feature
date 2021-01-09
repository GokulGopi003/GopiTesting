Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Inventory Parent Child Setting Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryParentChildSettings.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch.form-control-res" as "bulk brand category test"
    When Im waiting for 2 sec
    Then I need to click on td forElement ""
    Then I enter the value forElement "input#ContentPlaceHolder1_txtChildCode.form-control-res.ui-autocomplete-input" as "23"
    When Im waiting for 2 sec
    When I press downArrow from element "input#ContentPlaceHolder1_txtChildCode"  and click enter key
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCweight.form-control-res" as "99"
    Then I click dynamically on "Add" button
    When Im waiting for 2 sec
  	Then I click dynamically on "Save" button
  	When Im waiting for 3 sec
  	#delete
  	Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch.form-control-res" as "bulk brand category test"
    When Im waiting for 2 sec
    Then I need to click on td forElement ""
    When Im waiting for 2 sec
    Then I need to click on td forElement "Child"
    Then I click dynamically on "Delet" button
    
  	