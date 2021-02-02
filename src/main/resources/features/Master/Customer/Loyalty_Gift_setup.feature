Feature: Master > Customer > Loyalty Gift Setup

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master @Done
  Scenario: checking for Loyalty Gift Setup
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmLoyaltyMasterSetup.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtBaseAmount" as "343"
    Then I enter the value forElement "#ContentPlaceHolder1_txtBasePoints" as "2"
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherValue" as "4"
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherValue" as "23"
    Then I enter the value forElement "#ContentPlaceHolder1_txtPeriods" as "345"
    Then I click on the save button
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvLoyaltyMasterSetup_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherValue" as "237"
    Then I click on the save button
    When Im waiting for 3 sec
    Then I click on the "input#ContentPlaceHolder1_gvLoyaltyMasterSetup_imgbtnDelete_0" of "delete" icon
