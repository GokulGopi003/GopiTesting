Feature: PoS Inventory > Add Inventory

  Background: As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
       
  @july2020
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Security/frmUserMaster.aspx"
    Then I need to click on the "New" button2
    Then I load the testdatas form excel to table
    Then I load the UserMaster sheet data to map
    Then I load the rowise UserMaster data for "<TestcaseRowName>" rowname
    Then I update value to the UserMaster page global Variables
    Then I fill new UserMaster data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to UserMaster
    Then I read the values from table "TBL_USER_MASTER" in UserMaster
    Then I close connection to UserMaster
    
    
     Examples: 
      | TestcaseRowName |
		  |UserMaster|