Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmQuickPriceChange.aspx"
    #Then I need to click on sub menu with text matching "Repack"
    Then I load the testdatas form excel to table
    Then I load the LocationWisePriceChange sheet data to map
    Then I load the rowise LocationWisePriceChange data for "<TestcaseRowName>" rowname
    Then I update value to the LocationWisePriceChange page global Variables
    Then I fill new LocationWisePriceChange data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate_Regular"
    Then I establish connection  DB for LocationWisePriceChange
    Then I read the values from LocationWisePriceChange table "tblOutletPricingControl" in DB
    Then I close connection  DB for LocationWisePriceChange
    
     Examples: 
      | TestcaseRowName |
      |LocationWisePriceChange2|
      
  
