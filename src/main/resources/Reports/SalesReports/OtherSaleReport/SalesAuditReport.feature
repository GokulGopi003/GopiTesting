Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Reports/frmSalesReport.aspx?id=SalesAudit"
    Then I load the testdatas form excel to table
    Then I load the SalesAuditReport sheet data to map
    Then I load the rowise SalesAuditReport data for "<TestcaseRowName>" rowname
    Then I update value to the SalesAuditReport page global Variables
    Then I fill new SalesAuditReport data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoadSalesAudit"
    
    
    
    
     Examples: 
      | TestcaseRowName |
		  |SalesAuditReport1|