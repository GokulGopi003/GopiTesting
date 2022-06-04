Feature: master > Purchase > Display and Contract

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: check the Display and Contract
    Given I want to launch the "Masters/frmDisplayandContract.aspx"
   Then I load the testdata form excel to table
	Then I load the DisplayandContractNew sheet data to map
  Then I load the DisplayandContractNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the DisplayandContractNew page global Variables
  Then I fill new DisplayandContractNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to DisplayandContractNew
  Then I read the values from table "tblDisplayandContracts" in DisplayandContractNew
  Then I close connection to DisplayandContractNew 

    Examples: 
      |TestcaseRowName|
      |DisplayandContractNew1|
     