Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Inventory Distribution Functionality
    Given I want to launch the "Inventory/frmDistributionlist.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate.form-control-res.hasDatepicker" as "07-01-2020"
    Then I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtToDate.form-control-res.hasDatepicker" as "04-01-2021"
    Then I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    Then I click dynamically on "Load" button
    #Then I need to click on td forElement "Distribution"
    Then I need to click on table forelement "View"
    Then I need to click on table forelement "Delete"
    Then I need to click alert ok
    
    #parent weight invalid message
    
    
 
    
  	