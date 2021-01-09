Feature: PoS Master > Location

  Background: As a unixpro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    And I want to maxmize the browser

  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmPromotion.aspx"
    When I click dynamically on "New" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPromoDescription" as "Testing Promotion"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cblLocation_1"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrand" as "3 ROSESS"
      When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
