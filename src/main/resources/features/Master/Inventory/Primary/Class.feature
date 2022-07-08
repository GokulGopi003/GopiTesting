Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmClass.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvClass_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvClass_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Class sheet data to map
    Then I load the rowise Class data for "<TestcaseRowName>" rowname
    Then I update value to the Class page global Variables
    Then I fill new Class data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for ClassMaster
    Then I read the values from Class table "tblclass" in DB
    Then I close connection  DB for ClassMaster
      Examples: 
      | TestcaseRowName |
      |Class      |
      |Class1      |
      |Class2      |
      |Class3      |
      |Class4      |
      |Class5      |
      |Class6      |
      |Class7      |
      |Class8      |
      |Class9      |
      |Class10      |
      |Class11      |
      |Class12      |
      |Class13      |