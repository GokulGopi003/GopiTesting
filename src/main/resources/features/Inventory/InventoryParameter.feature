Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory
  Scenario: Verifying Inventory Parameter Functionality
    Given I want to launch the "Inventory/frmInventoryParameter.aspx"
    Then I need to click on td forElement ""
    Then I need to click on the "Delete" button
    Then I need to click alert ok
    
    
  #Scenario: Home > Master > Inventory > Department Master
    #Given I want to launch the "Inventory/frmDepartmentMaster.aspx"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptCode.form-control-res" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptName.form-control-res" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg.form-control-res" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "1548780"
