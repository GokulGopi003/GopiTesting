Feature: Management > Purchase analysis #some defect for 

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Purchase analysis
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmPurchaseAnalysis.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDept" as "CLEANING"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCategory" as "CLEANING"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrand" as "BABY SAFFRON"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSubCategory" as "ANKLET"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFloor" as "FOURTH FLOOR"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSection" as "ADSF"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtShelf" as "SJJDFFJSD"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "115 TEA & COFFEE"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemName" as "FAIRNESS CREAM"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "2019-12-30"
    Given I need to click on the  element "a.ui-state-default.ui-state-active"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkPurchaseMargin"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMarginRange" as "10"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkFilterOption"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkFilterOption"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkPrint"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClose"
