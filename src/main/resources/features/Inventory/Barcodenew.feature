Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @gokul
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Inventory/Barcode.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "C0000"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkSearchGrid"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Barcode sheet data to map
    Then I load the rowise Barcode data for "<TestcaseRowName>" rowname
    Then I update value to the Barcode page global Variables
    Then I fill new Barcode data page using excel data
    #Then I need to click on the blue "btnPrint" button
    #Then I need to click on the blue "btnClear" button
    
      Examples: 
      | TestcaseRowName |
      |Barcode      |
      |Barcode1      |