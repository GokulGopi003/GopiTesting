Feature: master > Purchase > Display and Contact

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@master
  #Scenario: check the Display and Contact
  #	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmDisplayandContract.aspx"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtDisplaycode" as "987"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtDisplayName" as "karappakam,chennai"
  #
  #	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  #	Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
  #	Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
  #	Then I need to select the dropdown "rrr" value forLabel "Department" using Javascript
  #	Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
  #	Then I need to select the dropdown "fifth floor" value forLabel "Floor" using Javascript
  #	Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
  #	Then I need to select the dropdown "SJJDFFJSD" value forLabel "Shelf" using Javascript
  #
  #	Then I click on the save button
  @master
  Scenario: check the Display and Contact
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmDisplayandContract.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtDisplaycode" as "7"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDisplayName" as "karappakam,chennai"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "rrr" value forLabel "Department" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "fifth floor" value forLabel "Floor" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "SJJDFFJSD" value forLabel "Shelf" using Javascript
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    #When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvDisplay_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDisplayName" as "karappakam,trichy"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Trichy"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvDisplay_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
