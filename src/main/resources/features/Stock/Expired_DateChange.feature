Feature: Stock > Stock Adjustment #pending for double click problem

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory
  Scenario: Verifying for Stock Adjustment
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Stock/frmExpiredDateChange.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "760872"
    When I press downArrow from element "input#ContentPlaceHolder1_txtItemCode"  and click enter key
    When Im waiting for 4 sec
    And I doubleclick on the selected Item by text "MEDBATCH" for findElements"td#tdBatchNo_0"
    