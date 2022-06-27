Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Reports/frmPurchaseReport.aspx?id=PurchaseOrder"
    Then I load the testdatas form excel to table
    Then I load the PurchaseOrderReport sheet data to map
    Then I load the rowise PurchaseOrderReport data for "<TestcaseRowName>" rowname
    Then I update value to the PurchaseOrderReport page global Variables
    Then I fill new PurchaseOrderReport data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkPOReport"
    
    
    
    
     Examples: 
      | TestcaseRowName |
		  |PurchaseOrderReport3|