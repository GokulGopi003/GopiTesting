
Feature: Home>Master>Company Master 

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @tag2
  Scenario Outline: Home > Master > ReasonMaster
   Given I want to launch the "Masters/frmReasonMaster.aspx" 
  
	Then I load the testdata form excel to table
	Then I load the ReasonMasterNew sheet data to map
  Then I load the ReasonMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ReasonMasterNew page global Variables
  Then I fill new ReasonMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to ReasonMasterNew
  Then I read the values from table "tblReasonMaster" in ReasonMasterNew
  Then I close connection to ReasonMasterNew 
    Examples: 
      |TestcaseRowName  |
      |ReasonMasterNew|
      |ReasonMasterNew1|
      |ReasonMasterNew2|
      |ReasonMasterNew3|
      |ReasonMasterNew4|
      |ReasonMasterNew5|
      |ReasonMasterNew6|
      |ReasonMasterNew7|
      |ReasonMasterNew8|
      |ReasonMasterNew9|
      |ReasonMasterNew10|
      
      
