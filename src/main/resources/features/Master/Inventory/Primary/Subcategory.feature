Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title



 Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmsubCategory.aspx"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0"
   # Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0"
   # Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSubCategoryCode" as "1548780"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSubCategoryName" as "1548780"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "BABY OIL" value forLabel "Category" using Javascript
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscountPercent" as "1548780"
    #Then I need to click on the "Save" button
    Then I load the testdatas form excel to table
    Then I load the Subcategory sheet data to map
    Then I load the rowise Subcategory data for "<TestcaseRowName>" rowname
    Then I update value to the Subcategory page global Variables
    Then I fill new Subcategory data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "Gopi" value forLabel "Category" using Javascript
    Then I need to click on the "Save" button
    Then I establish connection to Subcategory
    Then I read the values from table "tblSubCategory" in Subcategory
    Then I close connection to Subcategory
 
  Examples: 
      | TestcaseRowName |
      | Subcategory      |