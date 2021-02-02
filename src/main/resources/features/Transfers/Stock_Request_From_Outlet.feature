Feature: Transfers > Stock_Request_From_Outlet

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @managementSt
  Scenario: checking for Stock Request From Outlet
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Transfer/frmRequestedStockView.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLocation" as "Alll"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate" as "07-02-2019"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtWarehouse" as "1ST FLOORr"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 5 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 3 sec
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkProcessed"
    And I click on the checkBox forElement "a#ContentPlaceHolder1_lnkRefresh.button-blue"
