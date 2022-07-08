Feature: PoS Master > Sales > POS Payment @done
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmPosPayment.aspx"
  Then I load the testdata form excel to table
	Then I load the POSPaymentNew sheet data to map
  Then I load the POSPaymentNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the POSPaymentNew page global Variables
  Then I fill new POSPaymentNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to POSPaymentNew
  Then I read the values from table "tblPosPaymentSub" in POSPaymentNew
  Then I close connection to POSPaymentNew

    Examples: 
      |TestcaseRowName|
      |POSPaymentNew|
      |POSPaymentNew1|
      |POSPaymentNew2|
      |POSPaymentNew3|
      |POSPaymentNew4|
      |POSPaymentNew5|
      |POSPaymentNew6|
      |POSPaymentNew7|
      |POSPaymentNew8|
      |POSPaymentNew9|
      |POSPaymentNew10|
     