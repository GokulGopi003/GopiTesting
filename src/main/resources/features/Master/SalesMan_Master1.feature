Feature: PoS Master > Sales > Sales man > SalesMan Master   #defect for delete fn

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
    Then I enter the SalesMan ID "11"
    Then I need enter the Employee Code "011"
    Then I text the SalesMan name "prabhu12"
    Then I need enter the commission "35"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
    Given I need to click on the "Save" button
