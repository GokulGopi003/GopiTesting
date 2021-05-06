Feature: Inventory Negative Case Scenarios

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  Scenario: Verifying Inventory negative case scenarios
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtMRP" value as "100" using Javascript
    Then I need to type the textvalue forElement "input#ContentPlaceHolder1_txtBasicCost" value as "110" using Javascript
    Then I need to click on IGST DropDown forElement "div#ContentPlaceHolder1_ddlInputIGST_chzn.chzn-container.chzn-container-single"
    Then I need to click on IGST search forElement "div.chzn-search"
    Then I need to click on IGST value forElement "li#ContentPlaceHolder1_ddlInputIGST_chzn_o_3.active-result"
    Then I click on button tag with value "Back"
    Then I verify mrp and selling price
