Feature: InventoryChange
  I want to use this template for my feature file
  
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Stock/frmAverageCostReset.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the InventoryCostReset sheet data to map
    Then I load the rowise InventoryCostReset data for "<TestcaseRowName>" rowname
    Then I update value to the InventoryCostReset page global Variables
    Then I fill new InventoryCostReset data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_txtVendor"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    When Im waiting for 1 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkReport"
    
    
    
    
    
     Examples: 
      | TestcaseRowName |
      |InventoryCostReset|
      
   