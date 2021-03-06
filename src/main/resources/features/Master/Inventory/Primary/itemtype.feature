Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmItemType.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvItemType_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Itemtype sheet data to map
    Then I load the rowise Itemtype data for "<TestcaseRowName>" rowname
    Then I update value to the Itemtype page global Variables
    Then I fill new Itemtype data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Itemtype
    Then I read the values from table "tblItemType" in Itemtype
    Then I close connection to Itemtype 
    
      Examples: 
      | TestcaseRowName |
      |Itemtype      |
      |Itemtype1      |
      |Itemtype2      |
      |Itemtype3      |
      |Itemtype4      |
      |Itemtype5      |
      |Itemtype6      |
      |Itemtype7      |
      |Itemtype8      |
      |Itemtype9      |
      |Itemtype10      |
      