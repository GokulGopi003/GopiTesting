Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #
  #@inventory @Department
  #Scenario: Home > Master > Inventory > Department Master
  #Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmDepartmentMaster.aspx"
  #Given I need to click on the "Clear" button
  #When Im waiting for 3 sec
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptCode.form-control-res" as "EC2020"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptName.form-control-res" as "Electronics"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg.form-control-res" as "Prabhu"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "Newly Added in 2020"
  #Given I need to click on the "Save" button
  #When Im waiting for 5 sec
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Electronics"
  #When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
  #Then I click on the "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0" of "edit" icon
  #When Im waiting for 2 sec
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg" as "Prabhu Editted"
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "5"
  #Given I need to click on the "Save" button
  #When Im waiting for 5 sec
  #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Electronics"
  #When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
  #When Im waiting for 2 sec
  #Then I click on the "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0" of "delete" icon
  #When Im waiting for 5 sec
  #Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
  #
  #
  #
  #
  
  Scenario Outline: Title of your scenario outline
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmDepartmentMaster.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptCode.form-control-res" as <DepartmentCode>
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptName.form-control-res" as <DepartmentName>
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg.form-control-res" as <PersonInCharge>
    Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as <Remarks>
    Given I need to click on the "Save" button
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as <DepartmentName>
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg" as "Prabhu Editted"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as <Discount>
    Given I need to click on the "Save" button
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as <DepartmentName>
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"

    Examples: 
      | DepartmentCode | DepartmentName | PersonInCharge | Remarks                         | Discount |
      | "ECNew"        | "DemoToday"  | "prabhu"       | "Newly added in 2020year"       | "5"      |
     # | "FCNew"        | "FoodItem"     | "Kalaimathy"   | "Newly added in 2021year"       | "7"      |
     # | "FCNew"        | "Accessories"  | "Kalaimathy"   | "Newly added in  2020 Dec year" | "7"      |
