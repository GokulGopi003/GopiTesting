
Feature: Purchase > Bank master   #alert check pblm

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: check for BankModule
    Given I want to launch the "Masters/frmBankMaster.aspx"
     Then I load the testdata form excel to table
	Then I load the BankNew sheet data to map
  Then I load the BankNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BankNew page global Variables
  Then I fill new BankNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BankNew
  Then I read the values from table "tblBankCode" in BankNew
  Then I close connection to BankNew
    Examples: 
      |TestcaseRowName|
      |BankNew|
      |BankNew1|
      |BankNew2|
      |BankNew3|
      |BankNew4|
      |BankNew5|
      |BankNew6|
      |BankNew7|
      |BankNew8|
      |BankNew9|
      |BankNew10|
      
      
    