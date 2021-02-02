Feature: Stock > Stock update and Posting #done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Stock update and posting
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmInventoryStockReset.aspx"
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor" as "A.A. AGENCIES"
    When Im waiting for 3 sec
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtDepartment" as "CLEANING"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtCategory" as "bleachingpowder"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtBrand" as "DETTOL"
    #When Im waiting for 2 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtSubCategory" as "ANKLET"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtMerchandise" as "SLOW MOVING PRODUCT"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtManufacture" as "SAKTHI MASALA"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtFloor" as "FOURTH FLOOR"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtSection" as "ADSF"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtBin" as "KJFJDS"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtShelf" as "SJJDFFJSD"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtWarehouse" as "1ST FLOOR"
    #When Im waiting for 3 sec
    #Then I need to press the BackSpace key forElement "input#txtSearch"
    #Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtBatchNo" as "0019588"
    #When Im waiting for 3 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode" as "115 TEA & COFFEE"
    #When Im waiting for 3 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemName" as "FAIRNESS CREAM"
    #When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_gvInvStockReset_ChkSingle_0"
    Given I need to click on the  element "input#ContentPlaceHolder1_btnUpdate.button-blue"
    And I click on the selected Item by text "Yes" for findElements"button.ui-button.ui-corner-all.ui-widget"
