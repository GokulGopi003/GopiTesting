Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmDayBasedPromotionEdit.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkBack"
    Then I load the testdatas form excel to table
    Then I load the DayBasedPromotion sheet data to map
    Then I load the rowise DayBasedPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the DayBasedPromotion page global Variables
    Then I fill new DayBasedPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for DayBasedPromotion
    Then I read the values from DayBasedPromotion table "tblPromotionDayBased" in DB
    Then I close connection  DB for DayBasedPromotion
    
     Examples: 
      | TestcaseRowName |
      |DayBasedPromotion3|

