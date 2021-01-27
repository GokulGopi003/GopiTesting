Feature: Management > Branch  Stock Movement Report

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Branch_StockMovement_Report
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
    #
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkSelfApproval"
    #
    Given I need to click on the "Save" button
    #
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
   # Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div >"
#
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUSERID " as "20"
    When Im waiting for 3 sec
        When I select radio button forElement "input#ContentPlaceHolder1_rbtBatch"
    
     #Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon