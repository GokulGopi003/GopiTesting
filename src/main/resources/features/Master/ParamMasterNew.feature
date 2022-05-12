
Feature: Home >Master >ParamCode Master @done
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmParamMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the ParamMasterNew sheet data to map
  Then I load the ParamMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ParamMasterNew page global Variables
  Then I fill new ParamMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to ParamMasterNew
  Then I read the values from table "TBLPARAMMASTER" in ParamMasterNew
  Then I close connection to ParamMasterNew

    Examples: 
      |TestcaseRowName |
      |ParamMasterNew  |
      
