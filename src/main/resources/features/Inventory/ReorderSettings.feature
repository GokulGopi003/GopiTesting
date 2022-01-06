Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
  
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryChange.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_hypReorder"
    When Im waiting for 2 sec
    Then I load the testdata form excel to table
    Then I load the ReorderSettings sheet data to map
    Then I load the rowise ReorderSettings data for "<TestcaseRowName>" rowname
    Then I update value to the ReorderSettings page global Variables
    Then I fill new ReorderSettings data page using excel data
    Then I fill min and maxqty
    Then I need to click on the blue "Update" button
    Then I establish connection  DB for Reordersettings
    Then I read the values from Reordersettings table "tblinventory" in DB
    Then I close connection  DB for Reordersettings

    Examples: 
      | TestcaseRowName |
      |ReorderSettings  |
