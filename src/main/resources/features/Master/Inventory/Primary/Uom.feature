Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline:
    Given I want to launch the "Masters/frmUOM.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "1"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvUOM_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvUOM_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Uom sheet data to map
    Then I load the rowise Uom data for "<TestcaseRowName>" rowname
    Then I update value to the Uom page global Variables
    Then I fill new Uom data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Uom
    Then I read the values from table "tblUOM" in Uom
    Then I close connection to Uom
    
      Examples: 
      | TestcaseRowName |
      |Uom      |
      |Uom1      |
      |Uom2      |
      |Uom3      |
      |Uom4      |
      |Uom5      |
      |Uom6      |
      |Uom7      |
      |Uom8      |
      |Uom9      |
      |Uom10      |
      |Uom11      |