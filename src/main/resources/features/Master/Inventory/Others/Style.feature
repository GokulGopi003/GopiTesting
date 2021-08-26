Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmstyle.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    Then i send to enter key
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Style sheet data to map
    Then I load the rowise Style data for "<TestcaseRowName>" rowname
    Then I update value to the Style page global Variables
    Then I fill new Style data page using excel data
    Then I need to click on the "Save" button
    
      Examples: 
      | TestcaseRowName |
      |Style     |