Feature: Management > Audit Trails #i cant run the code(comment)

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Audit Trails
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmAuditTrail.Aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "2018-12-30"
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "EDIT" value forLabel "#ContentPlaceHolder1_DropDownAutitCode_chzn > div > div > input[type=text] " using Javascript
    #Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    #Then I need to select the dropdown "DISTRIBUTION" value forLabel "#ContentPlaceHolder1_DropDownFormname_chzn > div > div > input[type=text]" using Javascript
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
