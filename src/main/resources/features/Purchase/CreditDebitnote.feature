Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @gopi1234
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmSupplierNoteSummary.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkNewButton"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkrefresh"
    #Then I need to click on the  print
    #Then I need to click on the  Delete
    #Given I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the CreditDebitnote sheet data to map
    Then I load the rowise CreditDebitnote data for "<TestcaseRowName>" rowname
    Then I update value to the CreditDebitnote page global Variables
    Then I fill new CreditDebitnote data page using excel data
    #Then I need to click on the blue "Save" button
    
    
     Examples: 
      | TestcaseRowName |
      |CreditDebitnote1           |