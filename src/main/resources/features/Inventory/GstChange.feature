Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @inventory
  Scenario: Verifying GST Change Functionality
    Given I want to launch the "Inventory/frmInventoryGstChangeEdit.aspx"
    Then I click dynamically on "New" button
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor" as "205"
    When Im waiting for 2 sec
    Then I need to click on Vendor with text matching "205"
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
    #Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemType.form-control-res" as <ItemType>
    #Then I need to click on Vendor with text matching <ItemType>
		#Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtPrice.form-control-res" as <Price>    
		#Then I need to click on Vendor with text matching <Price>
		#Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtGst.form-control-res" as <Gst>
		#Then I need to click on Vendor with text matching <Gst>
  	Then I need to click on the filter "Filter" button
  	Then I need to click on IGST DropDown forElement "div#ContentPlaceHolder1_ddlIgst_chzn.chzn-container.chzn-container-single"
    Then I need to click on IGST search forElement "div.chzn-search"
    Then I need to click on IGST value forElement "li#ContentPlaceHolder1_ddlIgst_chzn_o_4.active-result"
    Then I need to click on the red "Add" button
  	And I click on the checkBox forElement "input#ContentPlaceHolder1_grdItemDetails_CheckBox1_0"
  	Then I click dynamically on "Update" button
  	Then I click on button tag with value "Ok"
  	
 