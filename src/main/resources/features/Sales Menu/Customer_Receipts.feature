Feature: Sales >Gift Voucher Book Creation

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: checking for  Gift Voucher Book Creation
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Sales/frmCustomerReceipts.aspx"
    #Then I need to click on table forelement "Select"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "VOUCHER" value forLabel "Paymode" using Javascript
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtReferenceNo" as "55"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "ANY BANK" value forLabel "Bank" using Javascript
    #Given I need to click on the  element "input#ContentPlaceHolder1_gvBalanceDetails_chkPay_0"
    #Given I need to click on the "Save" button
    #Given I need to click on the "Print" button
