Feature: Sales >Sales_transaction

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
