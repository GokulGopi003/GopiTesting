Feature: Management > Dashboard > and WebDashboard

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @Dashboard
  Scenario: checking for Dashboard
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMain.aspx"
    When Im waiting for 3 sec

  @WebDashboard
  Scenario: checking for Web Dashboard
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/MISDashboard/frmMisDashBoard.aspx"
