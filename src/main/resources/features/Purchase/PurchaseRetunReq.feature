Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPurchaseReturnList.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the PRR sheet data to map
    Then I load the rowise PRR data for "<TestcaseRowName>" rowname
    Then I update value to the PRR page global Variables
    Then I fill new PRR data page using excel data
    Then I need to click on the  element "div#ContentPlaceHolder1_DropDownVendor_chzn.chzn-container.chzn-container-single"
    Then I need to select the Vendor "DEFAULT" value forLabel "Vendor" using Javascript         
    When Im waiting for 2 sec
     Then I need to click on the "Add" button
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    
    
    
     Examples: 
      | TestcaseRowName |
      |PRR           |