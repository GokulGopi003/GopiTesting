Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Sales/frmCustomerReceipts.aspx"
   Then I need to click on the  element "#ContentPlaceHolder1_gvCustomerReceipts > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=button]"
    Then I load the testdatas form excel to table
    Then I load the CustomerReceipts sheet data to map
    Then I load the rowise CustomerReceipts data for "<TestcaseRowName>" rowname
    Then I update value to the CustomerReceipts page global Variables
    Then I fill new CustomerReceipts data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for CustomerReceipts
    Then I read the values from CustomerReceipts table "tblReceiptDetail" in DB
    Then I read the values from CustomerReceipts table "tblReceiptHeader" in DB
    Then I close connection  DB for CustomerReceipts
    
    
     Examples: 
      | TestcaseRowName |
      |CustomerReceipts|
      |CustomerReceipts1|
      |CustomerReceipts2|
      |CustomerReceipts3|
      |CustomerReceipts4|
      |CustomerReceipts5|
      |CustomerReceipts6|
      |CustomerReceipts7|
      |CustomerReceipts8|
      |CustomerReceipts9|
      |CustomerReceipts10|
      