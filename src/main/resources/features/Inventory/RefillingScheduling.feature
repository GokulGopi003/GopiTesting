Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmRefillingSchedule.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    Then I load the testdatas form excel to table
    Then I load the RefillingScheduling sheet data to map
    Then I load the rowise RefillingScheduling data for "<TestcaseRowName>" rowname
    Then I update value to the RefillingScheduling page global Variables
    Then I fill new RefillingScheduling data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for RefillingScheduling
    Then I read the values from RefillingScheduling table "tblRefillingSchedule" in DB
    Then I close connection  DB for RefillingScheduling
    
     Examples: 
      | TestcaseRowName |
      |RefillingScheduling1|
      
  
