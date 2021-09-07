Feature: PoS Inventory > Add Inventory

  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmDisplayandContracts.aspx"
    Then I load the testdatas form excel to table
    Then I load the DisplayandContracts sheet data to map
    Then I load the rowise DisplayandContracts data for "<TestcaseRowName>" rowname
    Then I update value to the DisplayandContracts page global Variables
    Then I fill new DisplayandContracts data page using excel data
    #Then I need to click on the "Clear" button
    Then I need to click on the "Load" button
    Then I need to click on the  element "input#ContentPlaceHolder1_gvDisplay_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnImgEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnDelete_0"
    #Then I need to click on the blue "Yes" button
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    #Then I need to click on the blue "Add" button
    #Then I need to click on the blue "Update" button
    
    
     Examples: 
      | TestcaseRowName |
      | DisplayandContracts1  |
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I need to click on the  element "input#ContentPlaceHolder1_gvDisplay_btnPay_0"
    Then I load the testdatas form excel to table
    Then I load the DisplayandContracts sheet data to map
    Then I load the rowise DisplayandContracts data for "<TestcaseRowName>" rowname
    Then I update value to the DisplayandContracts page global Variables
    Then I fill new DisplayandContracts data page using excel data
    Then I need to click on the  element "input#ContentPlaceHolder1_gvPayment_chkPaySingle_0"
    #Then I need to click on the blue "SelectAllChang" button
    Then I need to click on the blue "Save" button
    
    
         Examples: 
      | TestcaseRowName |
      | DisplayandContracts2  |
      
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdatas form excel to table
    Then I load the DisplayandContracts sheet data to map
    Then I load the rowise DisplayandContracts data for "<TestcaseRowName>" rowname
    Then I update value to the DisplayandContracts page global Variables
    Then I fill new DisplayandContracts data page using excel data
    Then I need to click on the blue "Add" button
    Then I need to click on the blue "Update" button
    #Then I need to click on the "Clear" button
    
         Examples: 
      | TestcaseRowName |
      | DisplayandContracts  |