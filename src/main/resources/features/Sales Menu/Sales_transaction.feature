Feature: Sales >Sales_transaction @pending

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: checking for  Sales_transaction
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Sales/frmSalesTransaction.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLocation" as "Alll"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
     Then I enter the value forElement "input#ContentPlaceHolder1_txtInvoiceNo" as "55"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPaymode" as "VOUCHER"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCashier" as "VAMSII"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtTerminal" as "C11"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCustomerCode" as "12"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemName" as "A ONE CHOCOLATEE"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMinimumAmt" as "100"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtMaximumAmt" as "1999"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2017"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtToDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData.button-red"
