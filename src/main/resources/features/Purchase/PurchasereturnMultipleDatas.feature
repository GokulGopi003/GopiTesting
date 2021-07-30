Feature: PoS Inventory > Add Inventory

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmPurchaseReturnView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I update value to the PR page global Variables
    Then I fill new PR data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the blue "AddInv" button
    
    
    
     Examples: 
      | TestcaseRowName |
      |PR1           |
      
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I update value to the PR page global Variables
    Then I fill new PR data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the blue "AddInv" button
    
    Examples: 
      | TestcaseRowName |
      |PR           |
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I update value to the PR page global Variables
    Then I fill new PR data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the blue "AddInv" button
    Then I need to click on the  element "#ContentPlaceHolder1_ddlRemarks_chzn > a > span"
    Then I need to select the dropdown "DAMAGE" value forLabel "Remarks" using Javascript
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    
    Examples: 
      | TestcaseRowName |
      |PR1           |