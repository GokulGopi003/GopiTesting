Feature: 
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmDistributionlist.aspx"
    #Then I need to click on the blue "AddDistb" button
    Then I need to click on the "RetDistb" button
    Then I load the testdatas form excel to table
    Then I load the Distribution sheet data to map
    Then I load the rowise Distribution data for "<TestcaseRowName>" rowname
    Then I update value to the Distribution page global Variables
    Then I fill new Distribution data page using excel data
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |Distribution|
      
      
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdatas form excel to table
    Then I load the Distribution sheet data to map
    Then I load the rowise Distribution data for "<TestcaseRowName>" rowname
    Then I update value to the Distribution page global Variables
    Then I fill new Distribution data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for Distribution
    Then I read the values from Distribution table "tblparentchild" in DB
    Then I close connection  DB for Distribution
    Examples: 
      | TestcaseRowName |
      |Distribution1|
   
