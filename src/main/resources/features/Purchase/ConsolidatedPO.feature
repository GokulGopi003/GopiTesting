Feature: PoS Inventory > Add Inventory

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmNewPO.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the ConsolidatedPO sheet data to map
    Then I load the rowise ConsolidatedPO data for "<TestcaseRowName>" rowname
    Then I update value to the ConsolidatedPO page global Variables
    Then I fill new ConsolidatedPO data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkClearAll"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
    
    
    
     Examples: 
      | TestcaseRowName |
      |ConsolidatedPO   |
      