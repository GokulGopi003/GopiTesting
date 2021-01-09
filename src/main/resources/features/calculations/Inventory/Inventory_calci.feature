Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory
  Scenario: Verifying Add Inventory Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryMaster.aspx"
    Given I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    When Im waiting for 2 sec
    Then I verify default values of selling price calcualtion page for "1200.49" as BasicCost
    When I enter the discout as "" percent and i verify the GrossCost value is updated as expected
    Then I verify the total discount offerd percentage
