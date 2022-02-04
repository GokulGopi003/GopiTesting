Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmRevokePromotion.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the RevokePromotion sheet data to map
    Then I load the rowise RevokePromotion data for "<TestcaseRowName>" rowname
    Then I update value to the RevokePromotion page global Variables
    Then I fill new RevokePromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnksave"

    
     Examples: 
      | TestcaseRowName |
      |RevokePromotion|

