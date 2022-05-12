Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    @go
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Inventory/frmBrandMaster.aspx"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandCode" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks" as "1548780"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "BABY OIL" value forLabel "Category" using Javascript
    #Then I need to click on the "Save" button
    Then I load the testdatas form excel to table
    Then I load the Brand sheet data to map
    Then I load the rowise Brand data for "<TestcaseRowName>" rowname
    Then I update value to the Brand page global Variables
    Then I fill new Brand data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then I fill the Category values in the inventory page
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "Gopi1" value forLabel "Category" using Javascript
    Then I need to click on the "Save" button
    #Then I establish connection to DB
    #Then I read the values from table "tblinventory" in DB
    #Then I close connection to DB
    Then I establish connection to Brand
    Then I read the values from table "tblBrand" in Brand
    Then I close connection to Brand
    
      Examples: 
      | TestcaseRowName |
      | Brand      |