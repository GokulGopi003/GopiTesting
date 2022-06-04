Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Sales/frmSalesTransaction.aspx"
    #Then I need to click on the  element "#ContentPlaceHolder1_gvCustomerReceipts > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=button]"
    Then I load the testdatas form excel to table
    Then I load the SalesTransaction sheet data to map
    Then I load the rowise SalesTransaction data for "<TestcaseRowName>" rowname
    Then I update value to the SalesTransaction page global Variables
    Then I fill new SalesTransaction data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData"
    Then I establish connection  DB for SalesTransaction
    Then I read the values from SalesTransaction table "vwPaymodeDetail" in DB
    Then I read the values from SalesTransaction table "vwSalesheader" in DB
    #Then I read the values from SalesTransaction table "tbl_pos_sales_order_header" in DB
    #Then I read the values from SalesTransaction table "tblSODetailERP" in DB
    Then I close connection  DB for SalesTransaction
    
    
     Examples: 
      | TestcaseRowName |
      |SalesTransaction1|