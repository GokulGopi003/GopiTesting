Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPromotion.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the OtherPromotion sheet data to map
    Then I load the rowise OtherPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the OtherPromotion page global Variables
    Then I fill new OtherPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for OtherPromotion
    Then I read the values from OtherPromotion table "tblPromotionHeader" in DB
    Then I read the values from OtherPromotion table "tblPromotionDetail" in DB
    Then I read the values from OtherPromotion table "tblFreeItemDetail" in DB
    Then I close connection  DB for OtherPromotion
    
     Examples: 
      | TestcaseRowName |
      |OtherPromotion3|

