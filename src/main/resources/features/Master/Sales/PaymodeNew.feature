Feature: PoS Master > Sales >pay mode
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmPayMode.aspx"
  Then I load the testdata form excel to table
	Then I load the PaymodeNew sheet data to map
  Then I load the PaymodeNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the PaymodeNew page global Variables
  Then I fill new PaymodeNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to PaymodeNew
  Then I read the values from table "tblPaymode" in PaymodeNew
  Then I close connection to PaymodeNew

    Examples: 
      |TestcaseRowName |
      |PaymodeNew|
      