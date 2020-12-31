Feature: Management > Branch Wise Sales

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Branch_Wise_Sales
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Reports/SalesDetailsBranchwise.Aspx"
    Then I need to invoke the DropDown by Index 0 if text matching "Tax Rate"
    Then I need to select the dropdown "Brand" value forLabel "GroupBy" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "All Branches"
    Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    
