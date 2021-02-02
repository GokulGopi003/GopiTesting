Feature: Master > Customer > Loyalty Item

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master @Done
  Scenario: checking for Loyalty Item
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmLoyaltyTerm.aspx"
    Then I enter the value forElement "#ContentPlaceHolder1_txtBaseAmount" as "343"
    Then I enter the value forElement "#ContentPlaceHolder1_txtBasePoint" as "2"
    Then I enter the value forElement "#ContentPlaceHolder1_txtVouchervalue" as "4"
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherpoints" as "23"
    Then I enter the value forElement "#ContentPlaceHolder1_txtPeriods" as "345"
    Then I click on the save button
    When Im waiting for 2 sec
    Then I click on the "a#ContentPlaceHolder1_imgbtnDelete.button-red" of "delete" icon
    When Im waiting for 2 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
