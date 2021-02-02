Feature: Transfers >Transfers_Out_Add

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @managementSt
  Scenario: checking for Transfers Out Add
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Transfer/frmTransferOut.aspx?id=TransferOut"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate" as "07-02-2019"
        Given I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    