Feature: Management > Vendor analysis

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Vendor analysis
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmVendorAnalysis.aspx"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClear.btn.btn-danger"
    When Im waiting for 2 sec
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A AGENCIES"
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 2 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "2019-12-30"
    Given I need to click on the  element "a.ui-state-default.ui-state-active"
    When Im waiting for 2 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkFetch.btn.btn-danger"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkPrint.btn.btn-danger"
