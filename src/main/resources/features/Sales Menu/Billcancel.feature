Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Masters/frmBillCancel.aspx"
    Then I load the testdatas form excel to table
    Then I load the Billcancel sheet data to map
    Then I load the rowise Billcancel data for "<TestcaseRowName>" rowname
    Then I update value to the Billcancel page global Variables
    Then I fill new Billcancel data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkBillCancel"
    Then I establish connection  DB for Billcancel
    Then I read the values from Billcancel table "tblSalesReturnDetail" in DB
    Then I read the values from Billcancel table "tblSalesReturnheader" in DB
    Then I close connection  DB for Billcancel
    
    
     Examples: 
      | TestcaseRowName |
      |Billcancel1|