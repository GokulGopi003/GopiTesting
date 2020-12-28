Feature: Master > Reason Master

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@master
  #Scenario: checking for Reason Master
  #	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmReasonMaster.aspx"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtReasonCode" as "56"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtReasonDescription" as "hbhghj"
  #
  #	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  #	Then I need to select the dropdown "REPRINT" value forLabel "TranType" using Javascript
  #
  #	Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
  #	Then I need to select the dropdown "A" value forLabel "additiondeduction" using Javascript
  #
  #	Then I click on the save button
  @master
  Scenario: checking for Reason Master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmReasonMaster.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtReasonCode" as "56"
    Then I enter the value forElement "#ContentPlaceHolder1_txtReasonDescription" as "hbhghj"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "REPRINT" value forLabel "TranType" using Javascript
    #Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    #Then I need to select the dropdown "A" value forLabel "additiondeduction" using Javascript
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvReason_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "#ContentPlaceHolder1_txtReasonDescription" as "hbhghj etidded"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I click on the "input#ContentPlaceHolder1_gvReason_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
