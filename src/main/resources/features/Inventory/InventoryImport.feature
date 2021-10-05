Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    
    Scenario: Verifying Inventory Import Functionality
     Given I want to launch the "Masters/frmInventoryUpload.aspx"
    Then I Browse the Excelsheetdata
    Then I need to click on the  element "a#ContentPlaceHolder1_btnUpload" 
 
    
     