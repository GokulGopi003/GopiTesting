Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmFreeItemView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the FreeItem sheet data to map
    Then I load the rowise FreeItem data for "<TestcaseRowName>" rowname
    Then I update value to the FreeItem page global Variables
    Then I fill new FreeItem data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for FreeItem
    #Then I read the values from FreeItem table "tblFreeItemGroup" in DB
    Then I read the values from FreeItem table "tblQualifyingItemsForFree" in DB
    Then I read the values from FreeItem table "tblfreeitemslist" in DB
    Then I close connection  DB for FreeItem
    
     Examples: 
      | TestcaseRowName |
      |FreeItem|
      |FreeItem1|
      |FreeItem2|
      |FreeItem3|
      |FreeItem4|
      |FreeItem5|
      |FreeItem6|
      |FreeItem7|
      |FreeItem8|
      |FreeItem9|
      |FreeItem10|
      

