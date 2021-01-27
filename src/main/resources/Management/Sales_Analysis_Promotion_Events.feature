Feature: Management > Sales_Analysis_Promotion_Events

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @Inventory_wise_Profit
  Scenario: checking for Location_wise_Profit
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmSalesAnalysis.aspx?id=SalesAnalysisPromotion"
    When Im waiting for 2 sec
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromotionEvents_0"
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromoType_1"
    Then I need to invoke the DropDown by Index 0 if text matching "All"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "ACCESORIES" value forElement "#ContentPlaceHolder1_rptDeptDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "BABY DRESS" value forElement "#ContentPlaceHolder1_rptCatDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forElement "#ContentPlaceHolder1_rptBrandDrop_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClearSearch"
    When Im waiting for 2 sec

  @Department_wise_Profit
  Scenario: checking for Location_wise_Profit
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmSalesAnalysis.aspx?id=SalesAnalysisPromotion"
    When Im waiting for 2 sec
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromotionEvents_1"
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromoType_0"
    Then I need to invoke the DropDown by Index 0 if text matching "All"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "ACCESORIES" value forElement "#ContentPlaceHolder1_rptDeptDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "BABY DRESS" value forElement "#ContentPlaceHolder1_rptCatDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forElement "#ContentPlaceHolder1_rptBrandDrop_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClearSearch"
    When Im waiting for 2 sec

  @Category_wise_Profit
  Scenario: checking for Location_wise_Profit
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmSalesAnalysis.aspx?id=SalesAnalysisPromotion"
    When Im waiting for 2 sec
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromotionEvents_2"
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromoType_2"
    Then I need to invoke the DropDown by Index 0 if text matching "All"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "ACCESORIES" value forElement "#ContentPlaceHolder1_rptDeptDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "BABY DRESS" value forElement "#ContentPlaceHolder1_rptCatDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forElement "#ContentPlaceHolder1_rptBrandDrop_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClearSearch"
    When Im waiting for 2 sec

  @Brand_wise_Profit
  Scenario: checking for Location_wise_Profit
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmSalesAnalysis.aspx?id=SalesAnalysisPromotion"
    When Im waiting for 2 sec
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromotionEvents_3"
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromoType_1"
    Then I need to invoke the DropDown by Index 0 if text matching "All"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "ACCESORIES" value forElement "#ContentPlaceHolder1_rptDeptDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "BABY DRESS" value forElement "#ContentPlaceHolder1_rptCatDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forElement "#ContentPlaceHolder1_rptBrandDrop_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClearSearch"
    When Im waiting for 2 sec

  @Free_Item_Profit
  Scenario: checking for Location_wise_Profit
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Managements/frmSalesAnalysis.aspx?id=SalesAnalysisPromotion"
    When Im waiting for 2 sec
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromotionEvents_4"
    When I select radio button forElement "input#ContentPlaceHolder1_rdoListPromoType_0"
    Then I need to invoke the DropDown by Index 0 if text matching "All"
    Then I need to select the dropdown "CBE" value forElement "#ContentPlaceHolder1_DropDownLocation_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "ACCESORIES" value forElement "#ContentPlaceHolder1_rptDeptDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "BABY DRESS" value forElement "#ContentPlaceHolder1_rptCatDrop_chzn > div > div > input[type=text]" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forElement "#ContentPlaceHolder1_rptBrandDrop_chzn > div > div > input[type=text]" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 2 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "20-06-2019"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkLoadReport"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkClearSearch"
    When Im waiting for 2 sec

  