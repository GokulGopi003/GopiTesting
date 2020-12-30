Feature: master > Purchase >  terms   #its not support delete and edit fn

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: check the terms
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmTerms.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtTermsCode" as "987"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "karappakam,chennai"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
    Given I need to click on the "Save" button
