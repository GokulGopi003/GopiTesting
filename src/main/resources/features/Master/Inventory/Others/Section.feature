Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmSection.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "GF" value forLabel "FloorCode" using Javascript
    Then I load the testdatas form excel to table
    Then I load the Section sheet data to map
    Then I load the rowise Section data for "<TestcaseRowName>" rowname
    Then I update value to the Section page global Variables
    Then I fill new Section data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Section
    Then I read the values from table "tblSection" in Section
    Then I close connection to Section
      Examples: 
      | TestcaseRowName |
      |Section      |
      |Section1      |
      |Section2      |
      |Section3      |
      |Section4      |
      |Section5      |
      |Section6      |
      |Section7      |
      |Section8      |
      |Section9      |
      |Section10      |
     