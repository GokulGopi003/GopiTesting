Feature: Stock > Stock Adjustment #problem for MRP value changes

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory
  Scenario: Verifying for Stock Adjustment
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Stock/frmStockAdjustmentSummery.aspx"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    When Im waiting for 2 sec
    Then I need to select the dropdown "Production Entry" value forLabel "StkAdjType" using Javascript
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "003044"
    When I press downArrow from element "input#ContentPlaceHolder1_txtItemCode"  and click enter key
    When Im waiting for 4 sec
    #And I click on on element "tr#BatchRow_0" in "Batch Detail" alert box
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkNewBatch.button-blue"
    When Im waiting for 4 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMRP" as "50.00"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAdd.button-blue"
    When Im waiting for 4 sec
    Given I need to click on the "Save" button
