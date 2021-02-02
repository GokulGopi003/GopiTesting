Feature: PoS Master > Location #pending

  Background: As a unixpro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    And I want to maxmize the browser

  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Purchase/frmSerialNumberEntry.aspx"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtGIDNo" as "HQ0400003141"
    And I click on the selected Item by text "HQ0400049221" for findElements"tr.pshro_GridDgnStyle_Alternative.tbl_left"
    When Im waiting for 8 sec
    And I doubleclick on the selected Item by text "004655	MOP REFILL JK B CUP BANIYAN 3IN1" for findElements"tr.pshro_GridDgnStyle_Alternative.tbl_left"
