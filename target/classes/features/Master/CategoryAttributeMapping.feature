Feature: PoS Master > Inventory > Category Attribute Mapping @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmCategoryAttributeMapping.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I Need to clear the default values if any
    Then I need to select the dropdown value as "BABY OIL" for poduct name
    And I need to enter the product cost as "66"
    And I need to enter the Miscelenious cost as"1"
    Then I need to enter the margin as "3"
    And I select the  required attributes"SIZE-COLOR-DESIGN"
    Given I need to click on the "Save" button
    