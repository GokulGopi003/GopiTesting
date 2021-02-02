Feature: Sales > Bill Cancel #doubt_line15

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: checking for  Bill Cancel
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBillCancel.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLocation" as "CBEE"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBillNo" as "1701C1S00000033"
    When Im waiting for 5 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkBillCancel"
    When Im waiting for 5 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClear"
