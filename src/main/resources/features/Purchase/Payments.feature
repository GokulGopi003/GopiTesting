Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPaymentsView.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrPayment_btnPay_0"
    Then I load the testdatas form excel to table
    Then I load the Payments sheet data to map
    Then I load the rowise Payments data for "<TestcaseRowName>" rowname
    Then I update value to the Payments page global Variables
    Then I fill new Payments data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for Payments
    Then I read the values from Payments table "tblPaymentHeader" in DB
    Then I read the values from Payments table "tblPaymentDetail" in DB
    Then I read the values from Payments table "tblRTGS" in DB
    Then I read the values from Payments table "tblAPTransaction" in DB
    Then I read the values from Payments table "tblDebitNote" in DB
    Then I read the values from Payments table "tblCreditNote" in DB
    Then I read the values from Payments table "tblDisplayheader" in DB
    Then I read the values from Payments table "tblReceiptDetail" in DB
    Then I close connection  DB for Payments
    
    
     Examples: 
      | TestcaseRowName |
      |Payments|