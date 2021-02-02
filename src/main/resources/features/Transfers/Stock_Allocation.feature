Feature: Transfers > Stock Allocation

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Stock Allocation
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Stock/frmStockAllocationNew.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate" as "07-02-2019"
    #When Im waiting for 3 sec
    #And I click on the checkBox forElement "input#ContentPlaceHolder1_rbnSalesBaseGRNAll"
    #When Im waiting for 3 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtGidNo" as "HQ0400003110"
      Then I need to click on DropDown forElement "select#ContentPlaceHolder1_ddlStkAllMethod"
    When Im waiting for 3 sec
   # Then I need to click DropDown value "SalesBase"
    Then I need to click on DropDown value forElement "li#ContentPlaceHolder1_lstLocation_chzn_o_1"
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkFetch.button-blue"
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkTransfer.button-blue"
