Feature: Master > Customer > member type

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master @Pending_line31
  Scenario: checking for  member type
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMemberType.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtCardType" as "wew"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "rwre"
    Then I enter the value forElement "#ContentPlaceHolder1_txtValidityPeriod" as "34"
    Then I enter the value forElement "#ContentPlaceHolder1_txtCardPrice" as "32"
    Then I enter the value forElement "#ContentPlaceHolder1_txtRewardPoints" as "343"
    Then I click on the Active button
    Then I click on the save button
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvMemberType_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "rwreeeee"
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvMemberType_imgbtnDelete_0" of "delete" icon
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 2 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    