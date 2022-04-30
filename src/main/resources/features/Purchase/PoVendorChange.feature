Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Purchase/frmVenderChangeForPO.aspx"
    Then I load the testdatas form excel to table
    Then I load the PoVendorChange sheet data to map
    Then I load the rowise PoVendorChange data for "<TestcaseRowName>" rowname
    Then I update value to the PoVendorChange page global Variables
    Then I fill new PoVendorChange data page using excel data
    Then I need to click on the "Update" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the "Clear" button
    Then I establish connection  DB for PoVendorChange
    Then I read the values from PoVendorChange table "tblpoheader" in DB
    Then I read the values from PoVendorChange table "tblpoDetail" in DB
    Then I close connection  DB for PoVendorChange
    
      Examples: 
      | TestcaseRowName |
      |PoVendorChange   |