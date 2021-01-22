Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying Inventory Change Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Stock/frmAverageCostReset.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor" as "222"
    When Im waiting for 3 sec
    #Then I need to click on Vendor with text matching "62"
    Then I need to press the BackSpace key forElement "input#txtSearch"
    Then I click on the "#table-Search > tbody > tr" of "table row" icon
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtDepartment" as ""
    #When Im waiting for 2 sec
    #Then I need to click on Vendor with text matching ""
    #Filtration
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor.form-control-res" as <Vendor>
    #Then I need to click on Vendor with text matching <Vendor>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtDepartment.form-control-res" as <Department>
    #Then I need to click on Vendor with text matching <Department>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtCategory.form-control-res" as <Category>
    #Then I need to click on Vendor with text matching <Category>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtBrand.form-control-res" as <Brand>
    #Then I need to click on Vendor with text matching <Brand>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtSubCategory" as <SubCategory>
    #Then I need to click on Vendor with text matching <SubCategory>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtClass.form-control-res" as <Class>
    #Then I need to click on Vendor with text matching <Class>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtSubClass.form-control-res" as <SubClass>
    #Then I need to click on Vendor with text matching <SubClass>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtMerchandise.form-control-res" as <Merchandise>
    #Then I need to click on Vendor with text matching <Merchandise>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtManufacture.form-control-res" as <Manufacture>
    #Then I need to click on Vendor with text matching <Manufacture>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtFloor.form-control-res" as <Floor>
    #Then I need to click on Vendor with text matching <Floor>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtSection.form-control-res" as <Section>
    #Then I need to click on Vendor with text matching <Section>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtBin.form-control-res" as <Bin>
    #Then I need to click on Vendor with text matching <Bin>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtShelf.form-control-res" as <Shelf>
    #Then I need to click on Vendor with text matching <Shelf>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtWarehouse.form-control-res" as <Warehouse>
    #Then I need to click on Vendor with text matching <Warehouse>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode.form-control-res" as <ItemCode>
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemName.form-control-res" as <ItemName>
  	Then I need to click on the filter "Filter" button
  	And I click on the checkBox forElement "input#ContentPlaceHolder1_grdItemDetails_chkSelect_0"
  	#Then I click dynamically on "Report" button
  	Then I enter the value forElement "input#ContentPlaceHolder1_grdItemDetails_txtNewCost_0.grid-textbox" as "2.25"
  	#Then I enter the value forElement "input#ContentPlaceHolder1_grdItemDetails_txtNewCost_1.grid-textbox" as "5.55"
  	Then I click dynamically on "Update" button
  	Then I need to click alert ok
  	
  	
  	#Examples: 
    #  | Vendor | Department | Category | Brand | SubCategory | Class | SubClass | Merchandise | Manufacture | Floor | Section | Bin | Shelf | Warehouse | ItemCode | ItemName | 
    #  | "205"        | ""  | ""       | ""       | ""      |
  	