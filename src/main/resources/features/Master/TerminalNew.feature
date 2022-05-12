Feature: Home>Master>Customer>Customer Master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	
@master 
Scenario Outline: checking for Customer master 
	Given I want to launch the "Masters/frmTerminalView.aspx" 
	Then I need to click on the "New" button2
	Then I load the testdata form excel to table
	Then I load the TerminalNew sheet data to map
  Then I load the TerminalNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the TerminalNew page global Variables
  Then I fill new TerminalNew data page using excel data
  Then I need to click on sub menu with text matching "Pole Display/Cash Drawer"
  Then I fill Pole Display/Cash Drawer
  Then I need to click on sub menu with text matching "Weighing Machine"
  Then I fill Pole Weighing Machine
  Then I need to click on the "Save" button
  Then I establish connection to TerminalNew
  Then I read the values from table "TBL_POS_TERMINAL_MASTER" in TerminalNew
  Then I close connection to TerminalNew
  
 
  
	
    Examples: 
      |TestcaseRowName |
      |TerminalNew|
     
