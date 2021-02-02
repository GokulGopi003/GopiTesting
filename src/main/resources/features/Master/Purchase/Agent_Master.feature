Feature: master > Purchase > Agent Master   #some defects in this scenario

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: check the  Agent Master
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmAgentView.aspx?alert=True"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkBack"
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtAgentName" as "kalai00"
    Then I enter the value forElement "#ContentPlaceHolder1_txtAddress1" as "karappakam,chennai"
    Then I click on the save button
