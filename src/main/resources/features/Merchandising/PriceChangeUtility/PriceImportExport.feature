Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmExportImportPrice.aspx"
    Then I need to click on sub menu with text matching "Import Price"
    Then I enter the value forElement "input#ContentPlaceHolder1_FileUpload1" as "/Users/macpc/Downloads/Sample.xlsx"
    Then I load the testdatas form excel to table
    Then I load the PriceImportExport sheet data to map
    Then I load the rowise PriceImportExport data for "<TestcaseRowName>" rowname
    Then I update value to the PriceImportExport page global Variables
    Then I fill new PriceImportExport data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_Check"
    Then I need to click on the  element "a#ContentPlaceHolder1_InkExport"
    Then I establish connection  DB for PriceImportExport
    Then I read the values from PriceImportExport table "tblOutletPricingControl" in DB
    Then I read the values from PriceImportExport table "tblinventory" in DB
    Then I read the values from PriceImportExport table "tblinventorypricing" in DB
    Then I close connection  DB for PriceImportExport
    
     Examples: 
      | TestcaseRowName |
      |PriceImportExport2|

