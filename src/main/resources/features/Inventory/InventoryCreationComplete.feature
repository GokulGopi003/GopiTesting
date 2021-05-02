Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
   	Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Examples: 
      | TestcaseRowName |
      | cost1           |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    
    Examples: 
      | TestcaseRowName |
      | MRP1            |
      
  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP2
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
		Then I click dynamically on "NewItemNo" button
		
    Examples: 
      | TestcaseRowName |
      | MRP2           |
   
   
  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP3
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button

    Examples: 
      | TestcaseRowName |
      | MRP3           |
      
  @may2    
  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP4
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
		Then I click dynamically on "NewItemNo" button
		
    Examples: 
      | TestcaseRowName |
      | MRP4           |            
