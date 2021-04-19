Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title


  Scenario Outline: Verifying Add Inventory Functionality
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Image"
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "/Users/prabhu/Desktop/se.jpeg"
    Then I need to click on the "Save" button

    Examples: 
      | TestcaseRowName |
      | cost1           |
