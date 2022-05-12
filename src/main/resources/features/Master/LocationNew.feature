Feature: PoS Master > Location @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: check LocationMaster
  Given I want to launch the "Masters/frmLocationMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the LocationNew sheet data to map
  Then I load the LocationNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the LocationNew page global Variables
  Then I fill new LocationNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to LocationNew
  Then I read the values from table "tbllocation" in LocationNew
  Then I close connection to LocationNew

    Examples: 
      | TestcaseRowName |
      |LocationNew|
    