Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @ic
  Scenario: Verifying Add Inventory Functionality1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BISCUITS"
    When Im waiting for 5 sec
    Then i clear and retype the vlaue "BISCUITS" for the field "input#txtSearch"
    Then I need to click on link with text matching "BISCUITS"

    
      @ic
  Scenario: Verifying Add Inventory Functionality2
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BISCUITS"
    When Im waiting for 5 sec
    Then i clear and retype the vlaue "BISCUITS" for the field "input#txtSearch"
    Then I need to click on link with text matching "BISCUITS"
    
    
      @ic
  Scenario: Verifying Add Inventory Functionality3
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtInvcategory.form-control-res" as "BISCUITS"
    When Im waiting for 5 sec
    Then i clear and retype the vlaue "BISCUITS" for the field "input#txtSearch"
    Then I need to click on link with text matching "BISCUITS"
    