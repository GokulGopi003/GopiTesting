Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Managements/frmCreditInvoice.aspx"
    Then I load the testdatas form excel to table
    Then I load the Creditinvoice sheet data to map
    Then I load the rowise Creditinvoice data for "<TestcaseRowName>" rowname
    Then I update value to the Creditinvoice page global Variables
    Then I fill new Creditinvoice data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for Creditinvoice
    Then I read the values from Creditinvoice table "tblSalesDetailCur" in DB
    #Then I read the values from Creditinvoice table "tblSalesDetail" in DB
    Then I read the values from Creditinvoice table "tblSalesHeaderCur" in DB
    Then I read the values from Creditinvoice table "tblPaymodeDetailCur" in DB
    Then I read the values from Creditinvoice table "tblsalesheaderERP" in DB
    Then I read the values from Creditinvoice table "tbl_pos_Sales_header" in DB
    Then I close connection  DB for Creditinvoice
    
    
     Examples: 
      | TestcaseRowName |
      |Creditinvoice|