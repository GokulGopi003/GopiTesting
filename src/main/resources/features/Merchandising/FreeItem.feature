Feature: PoS Master > Location @done

  Background: As a unixpro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Enterpriser_New_Sales_Demo/Merchandising/frmFreeItemView.aspx"
    When I click dynamically on "New" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtGroupCode" as "Shampo2020"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDesc" as "Year end offer"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cbSelectAll"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtQItemCode" as "001569"
    When I press downArrow from element "input#ContentPlaceHolder1_txtQItemCode"  and click enter key
    And I click on on element "tr#dataGridBatchTable_master_row0" in "Batch Detail" alert box
    Then I enter the value forElement "input#ContentPlaceHolder1_txtQQty" as "3"
    When I click dynamically on "Add" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFItemcode" as "001569"
    When I press downArrow from element "input#ContentPlaceHolder1_txtFItemcode"  and click enter key
    And I click on on element "tr#dataGridBatchTable_master_row0" in "Batch Detail" alert box
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFQty" as "1"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLimitQty" as "1"
    When I click dynamically on "AddFreeItem" button
    When I click dynamically on "Save" button
    Given I want to launch the "http://uniproonlineorder.ddns.net/Enterpriser_New_Sales_Demo/Merchandising/frmFreeItemView.aspx"
    When Im waiting for 4 sec
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cbSelectAll"
    When I click dynamically on "RevokeGroup" button
    When Im waiting for 2 sec
    Given I want to launch the "http://uniproonlineorder.ddns.net/Enterpriser_New_Sales_Demo/Merchandising/frmFreeItemView.aspx"
    
    
