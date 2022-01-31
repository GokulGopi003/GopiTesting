Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPromotionPrice.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkPromotionfilteration"
    Then I load the testdatas form excel to table
    Then I load the NormalPromotion sheet data to map
    Then I load the rowise NormalPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the NormalPromotion page global Variables
    Then I fill new NormalPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for NormalPromotion
    #Then I read the values from NormalPromotion table "tblFreeItemGroup" in DB
    Then I read the values from NormalPromotion table "tblQualifyingItemsForFree" in DB
    Then I read the values from NormalPromotion table "tblfreeitemslist" in DB
    Then I close connection  DB for NormalPromotion
    
     Examples: 
      | TestcaseRowName |
      |NormalPromotion1|

