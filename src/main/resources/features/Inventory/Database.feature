
Feature: PoS Inventory > Add Inventory
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost

   Then I load the testdatas form excel to table
    Then I load the OtherPromotion sheet data to map
    Then I load the rowise OtherPromotion data for "<TestcaseRowName>" rowname
        Then I update value to the OtherPromotion page global Variables
    Then I establish connection  DB for OtherPromotion
    Then I read the values from OtherPromotion table "tblPromotionHeader" in DB
    Then I read the values from OtherPromotion table "tblPromotionDetail" in DB
    Then I read the values from OtherPromotion table "tblFreeItemDetail" in DB
    Then I close connection  DB for OtherPromotion
    
     Examples: 
      | TestcaseRowName |
      |OtherPromotion2|
