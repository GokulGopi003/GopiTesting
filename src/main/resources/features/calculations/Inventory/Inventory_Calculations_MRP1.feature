Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory @done @rework @error
  Scenario Outline: Verifying Add Inventory Functionality
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Given I need to click on the  element "input#ContentPlaceHolder1_rbtMRP"
    Given I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    When Im waiting for 4 sec
    Then I fill inventory calculations page for MRP using excel data
    Then I fill the GST values in the inventory page
    When Im waiting for 4 sec
    Then I verify the actual ui values with expected Excel values

    Examples: 
      | TestcaseRowName |
      | MRP1            |
