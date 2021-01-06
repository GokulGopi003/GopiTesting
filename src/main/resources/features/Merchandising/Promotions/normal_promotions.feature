Feature: PoS Master > Location

  Background: As a unixpro user i want to launch the valid URL
   
	@Promotion
  Scenario: Verifying the Category Attribute Mapping Functionality
   Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    And I want to maxmize the browser
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmPromotionPrice.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "760904"
    #When I press downArrow from element "input#ContentPlaceHolder1_txtItemCode"  and click enter key
    #And I click on on element "tr#dataGridBatchTable_master_row0" in "Batch Detail" alert box
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtPPrice" as "90.00"
    #And I click on the checkBox forElement "input#ContentPlaceHolder1_rbnNormalPro"
    #When I click dynamically on "Add" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "760904"
    When I press downArrow from element "input#ContentPlaceHolder1_txtItemCode"  and click enter key
    And I click on on element "tr#dataGridBatchTable_master_row0" in "Batch Detail" alert box
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPPrice" as "91.32"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_rbnHourlyPro"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFrmTime" as "04"
    Given I need to click on the  element "li.ui-timepicker-am.ui-timepicker-selected"
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtToTime" as "06"
    When Im waiting for 2 sec
    Given I need to click on the  element "li.ui-timepicker-am.ui-timepicker-selected" in index 1
    When Im waiting for 2 sec
    When I click dynamically on "Add" button
    When Im waiting for 2 sec
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cblLocation_0"
    When I click dynamically on "Save" button
    When I click dynamically on "btnOk" button
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmRevokePromotion.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtItemCode" as "76090444"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cbAllRecord"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkviewlivepromotin.button-blue"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cbProfilterheader"
    And I click on the checkBox forElement "a#ContentPlaceHolder1_lnksave.button-blue"
    #Given I need to click on the  element "button.ui-button.ui-corner-all.ui-widget" in index 5
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmRevokePromotion.aspx"
