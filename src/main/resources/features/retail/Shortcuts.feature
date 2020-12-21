Feature: As a GRN User validating the Shortcuts flows are configured as per the reuirement

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @shortcuts
  Scenario: Verifying F2 shortcut key for Invoking Item history Screen
    Then Im launching Url "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on a GoButton
