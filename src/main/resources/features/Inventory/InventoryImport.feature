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
    Then I enter the value forElement "input#ContentPlaceHolder1_btnBrowse" as "/Users/macpc/Documents/GitHub/GopiTesting/testdata/Unipro_Master_Excel_web.xlsx"
    Then I need to click on the  element "input#ContentPlaceHolder1_btnUpload" 
 
    
     