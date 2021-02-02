Feature: PoS Master > Location @done

  Background: As a unixpro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    And I want to maxmize the browser

  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Purchase/frmPurchaseOrderView.aspx"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.B MARKETING"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 3 sec
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAddInv"
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCodeAdd" as "021212 "
    When Im waiting for 3 sec
    #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkVendorItems"
    #When Im waiting for 3 sec
    Given I need to click on the  element "input#ContentPlaceHolder1_chkVendorItems"
    When Im waiting for 5 sec
    Then I need to press the Enter key at "input#ContentPlaceHolder1_txtItemCodeAdd"
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLQty" as "2222"
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAddInv"
