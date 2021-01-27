Feature: Sales >Gift Voucher Book Creation

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @Gift_Voucher_Book_Creation
  Scenario:   Gift Voucher Book Creation
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmVoucherCreation.Aspx"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClear"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBookNo " as "200"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDenomination" as "500"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPrefix " as "kalai"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtStartNo " as "5"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtQty " as "6"
    
    Then I enter the value forElement "input#ContentPlaceHolder1_txtValidity " as "15"
 @Gift_Voucher_Transfer
  Scenario:  Book voucher transfer
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmVoucherCreation.Aspx"