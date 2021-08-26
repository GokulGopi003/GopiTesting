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
    Given I want to launch the "Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnImgEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnDelete_0"
    #Then I need to click on the blue "Yes" button
    Then I load the testdatas form excel to table
    Then I load the CreditDebitnote sheet data to map
    Then I load the rowise GA data for "<TestcaseRowName>" rowname
    Then I update value to the GA page global Variables
    Then I fill new GA data page using excel data
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    When Im waiting for 2 sec
    Then I want to minimize the browser
    Then I need to click on the "Save" button
    
     Examples: 
      | TestcaseRowName |
      |GA           |