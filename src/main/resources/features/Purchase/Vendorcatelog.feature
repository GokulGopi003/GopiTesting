Feature: PoS Inventory > Add Inventory

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmVendorCataLog.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the Vendorcatelog sheet data to map
    Then I load the rowise Vendorcatelog data for "<TestcaseRowName>" rowname
    Then I update value to the Vendorcatelog page global Variables
    Then I fill new Vendorcatelog data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtMrp_0" as "200"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtBasicCostNew_0" as "150"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPerNew_0" as "1"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPer2_0" as "1"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPer3_0" as "1"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvVendorCat_chkSingle_0"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for Vendorcatelog
    Then I read the values from Vendorcatelog table "tblvendorcatlog" in DB
    Then I read the values from Vendorcatelog table "tblInventoryPricing" in DB
    Then I close connection  DB for Vendorcatelog
  
    
    
    
     Examples: 
      | TestcaseRowName |
      |Vendorcatelog1    |
      
      
