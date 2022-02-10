Feature: PoS Inventory > Add Inventory

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmAutoPO.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the AutoPO sheet data to map
    Then I load the rowise AutoPO data for "<TestcaseRowName>" rowname
    Then I update value to the AutoPO page global Variables
    Then I fill new AutoPO data page using excel data
    When Im waiting for 2 sec
  Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
   Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate" 
    Then I establish connection  DB for AutoPO
    Then I read the values from AutoPO table "tblpoheader" in DB
    Then I read the values from AutoPO table "tblpoDetail" in DB
    Then I close connection  DB for AutoPO
    
     Examples: 
      | TestcaseRowName |
      |AutoPO1           |
      
      
 Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost  
    Then I need to click on the  element "h1#ui-id-8"
    Then I load the testdatas form excel to table
    Then I load the AutoPO sheet data to map
    Then I load the rowise AutoPO data for "<TestcaseRowName>" rowname
    Then I update value to the AutoPO page global Variables
    Then I fill new AutoPO data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilterOption"
    #Then I enter the value forElement "input#ContentPlaceHolder1_grdItemDetails_txtOrderQty_0" as "2"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkClearAll"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkPrint"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkStock"
    Then I establish connection  DB for AutoPO
    Then I read the values from AutoPO table "tblpoheader" in DB
    Then I read the values from AutoPO table "tblpoDetail" in DB
    Then I close connection  DB for AutoPO
    
   
    Examples: 
      | TestcaseRowName |
      |AutoPO1           |