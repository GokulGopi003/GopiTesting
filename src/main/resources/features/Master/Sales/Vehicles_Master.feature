Feature: PoS Master > Sales >Vehicles master @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #
  #@master
  #Scenario: checking for Vehicles master
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmVehicleMaster.aspx"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtVehicleMasterCode" as "654"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtDriverName" as "kalai"
  #Then I click on the save button
  #
  @master
  Scenario: checking for Vehicles master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmVehicleMaster.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtVehicleMasterCode" as "4"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDriverName" as "kalai"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I click on the "input#ContentPlaceHolder1_gvVehicleMaster_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDriverName" as "kalai111"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "kalai"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvVehicleMaster_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
