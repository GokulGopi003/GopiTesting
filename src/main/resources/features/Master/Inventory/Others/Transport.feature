Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmTransport.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Transport sheet data to map
    Then I load the rowise Transport data for "<TestcaseRowName>" rowname
    Then I update value to the Transport page global Variables
    Then I fill new Transport data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Transport
    Then I read the values from table "tblTransport" in Transport
    Then I close connection to Transport 
    
      Examples: 
      | TestcaseRowName |
      |Transport      |