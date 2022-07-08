Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @0512
  Scenario Outline: Home > Master > Inventory > Department Master
    Given I want to launch the "Inventory/frmDepartmentMaster.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptName.form-control-res" as "Food Items"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg.form-control-res" as "Food Items"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "Food Items"
    #Then I need to click on the "Save" button
    Then I load the testdataa form excel to table
    Then I load the Department sheet data to map
    Then I load the rowise Department data for "<TestcaseRowName>" rowname
    Then I update value to the Department page global Variables
    Then I fill new Department data page using excel data
    #Then i send to enter key
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then Im press the sapce bar and enter key
    Then I need to click on the "Save" button
    Then I establish connection  DB
    Then I read the values from department table "tbldepartment" in DB
    Then I close connection  DB
    
 
  Examples: 
      | TestcaseRowName |
      | Depatment      |
      | Depatment1      |
      | Depatment2      |
      | Depatment3      |
      | Depatment4      |
      | Depatment5      |
      | Depatment6      |
      | Depatment7      |
      | Depatment8      |
      | Depatment9      |
      | Depatment10      |
      | Depatment11      |