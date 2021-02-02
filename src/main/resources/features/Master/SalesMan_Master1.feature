Feature: PoS Master > Sales > Sales man > SalesMan Master  @done #but one defect for delete fn

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: checking for SalesMan Master
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManMaster.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the SalesMan ID "111"
    Then I need enter the Employee Code "0211"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSalesManName" as "prabhu"
    Then I need enter the commission "35"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
    #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "prabhu"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvSalesMan_imgbtnEdit_0" of "edit" icon
    Then I text the SalesMan name "prabhu12232"
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "prabhu"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvSalesMan_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
