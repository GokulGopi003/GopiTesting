
Feature: Home>Master>Company Master 
Background: 
	As a unixpro user i want to launch the valid URL

	Given Launching the valid URL 
	Given I enter the username 
	When I enter the password 
	Then I clik on the login button 
	Then I verify the page Title 
	@master
 
Scenario Outline: checking for Company master 
	Given I want to launch the "Masters/frmCompanyMaster.aspx" 
	Then I load the testdata form excel to table
	Then I load the CompanyMaster sheet data to map
  Then I load the CompanyMaster rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the CompanyMaster page global Variables
  Then I fill new CompanyMaster data page using excel data
  Then I need to click on the "Save" button
	Then I establish connection to CompanyMaster
  Then I read the values from table "tblcompany" in CompanyMaster
  Then I close connection to CompanyMaster 
	

    Examples: 
      |TestcaseRowName|
      |CompanyMaster1|
      
     

     

    
  
  Scenario Outline: check LocationMaster
  Given I want to launch the "Masters/frmLocationMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the LocationNew sheet data to map
  Then I load the LocationNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the LocationNew page global Variables
  Then I fill new LocationNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to LocationNew
  Then I read the values from table "tbllocation" in LocationNew
  Then I close connection to LocationNew

    Examples: 
      | TestcaseRowName |
      |LocationNew1|
      
      
      

  @tag2
  Scenario Outline: Home > Master > ReasonMaster
   Given I want to launch the "Masters/frmReasonMaster.aspx" 
  
	Then I load the testdata form excel to table
	Then I load the ReasonMasterNew sheet data to map
  Then I load the ReasonMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ReasonMasterNew page global Variables
  Then I fill new ReasonMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to ReasonMasterNew
  Then I read the values from table "tblReasonMaster" in ReasonMasterNew
  Then I close connection to ReasonMasterNew 
    Examples: 
      |TestcaseRowName  |
      |ReasonMasterNew1|
      
   
	
@master 
Scenario Outline: checking for Customer master 
	Given I want to launch the "Masters/frmTerminalView.aspx" 
	Then I need to click on the "New" button2
	Then I load the testdata form excel to table
	Then I load the TerminalNew sheet data to map
  Then I load the TerminalNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the TerminalNew page global Variables
  Then I fill new TerminalNew data page using excel data
  Then I need to click on sub menu with text matching "Pole Display/Cash Drawer"
  Then I fill Pole Display/Cash Drawer
  Then I need to click on sub menu with text matching "Weighing Machine"
  Then I fill Pole Weighing Machine
  Then I need to click on the "Save" button
  Then I establish connection to TerminalNew
  Then I read the values from table "TBL_POS_TERMINAL_MASTER" in TerminalNew
  Then I close connection to TerminalNew
  
 
  
	
    Examples: 
      |TestcaseRowName |
      |TerminalNew|
     
      
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
      | Depatment2      |
      
      
      



 Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Inventory/frmCategoryMaster.aspx"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdDepartmentList_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtCateCode" as "Gopi"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtCateName" as "Gopi"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "Gopi"
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "Gopi" value forLabel "Dept" using Javascript
    #Then I need to click on the "Save" button
    Then I load the testdatas form excel to table
    Then I load the Category sheet data to map
    Then I load the rowise Category data for "<TestcaseRowName>" rowname
    Then I update value to the Category page global Variables
    Then I fill new Category data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "Gopi" value forLabel "Dept" using Javascript
    Then I need to click on the "Save" button
    Then I establish connection to Category
    Then I read the values from table "tblCategory" in Category
    Then I close connection to Category
 
  Examples: 
      | TestcaseRowName |
      | Category1      |
      
      
      



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
      
      
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmFloor.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "HQ" value forLabel "Location" using Javascript
    Then I load the testdatas form excel to table
    Then I load the Floor sheet data to map
    Then I load the rowise Floor data for "<TestcaseRowName>" rowname
    Then I update value to the Floor page global Variables
    Then I fill new Floor data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Floor
    Then I read the values from table "tblFloor" in Floor
    Then I close connection to Floor 
    
      Examples: 
      | TestcaseRowName |
      |Floor      |
      
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmClass.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvClass_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvClass_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Class sheet data to map
    Then I load the rowise Class data for "<TestcaseRowName>" rowname
    Then I update value to the Class page global Variables
    Then I fill new Class data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for ClassMaster
    Then I read the values from Class table "tblclass" in DB
    Then I close connection  DB for ClassMaster
      Examples: 
      | TestcaseRowName |
      |Class      |
      
          
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmSubClass.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvSubclass_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Subclass sheet data to map
    Then I load the rowise Subclass data for "<TestcaseRowName>" rowname
    Then I update value to the Subclass page global Variables
    Then I fill new Subclass data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Subclass
    Then I read the values from table "tblSubClass" in Subclass
    Then I close connection to Subclass
    
      Examples: 
      | TestcaseRowName |
      |Subclass      |
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmItemType.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Gopi"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvItemType_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Itemtype sheet data to map
    Then I load the rowise Itemtype data for "<TestcaseRowName>" rowname
    Then I update value to the Itemtype page global Variables
    Then I fill new Itemtype data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Itemtype
    Then I read the values from table "tblItemType" in Itemtype
    Then I close connection to Itemtype 
    
      Examples: 
      | TestcaseRowName |
      |Itemtype      |
      
          
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmTaxMasterGST.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "C0000"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkSearchGrid"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Tax sheet data to map
    Then I load the rowise Tax data for "<TestcaseRowName>" rowname
    Then I update value to the Tax page global Variables
    Then I fill new Tax data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Tax
    Then I read the values from table "tblTaxMaster" in Tax
    Then I close connection to Tax 
    
      Examples: 
      | TestcaseRowName |
      |Tax      |
      
    
    Scenario Outline:
    Given I want to launch the "Masters/frmUOM.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "1"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvUOM_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvUOM_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Uom sheet data to map
    Then I load the rowise Uom data for "<TestcaseRowName>" rowname
    Then I update value to the Uom page global Variables
    Then I fill new Uom data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Uom
    Then I read the values from table "tblUOM" in Uom
    Then I close connection to Uom
    
      Examples: 
      | TestcaseRowName |
      |Uom      |
      
      
          
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmSection.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "GF" value forLabel "FloorCode" using Javascript
    Then I load the testdatas form excel to table
    Then I load the Section sheet data to map
    Then I load the rowise Section data for "<TestcaseRowName>" rowname
    Then I update value to the Section page global Variables
    Then I fill new Section data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Section
    Then I read the values from table "tblSection" in Section
    Then I close connection to Section
      Examples: 
      | TestcaseRowName |
      |Section      |
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "/Masters/frmBin.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    #Then I need to select the dropdown "NEW" value forLabel "sectionCode" using Javascript
    Then I load the testdatas form excel to table
    Then I load the Bin sheet data to map
    Then I load the rowise Bin data for "<TestcaseRowName>" rowname
    Then I update value to the Bin page global Variables
    Then I fill new Bin data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Bin
    Then I read the values from table "tblBin" in Bin
    Then I close connection to Bin
    
      Examples: 
      | TestcaseRowName |
      |Bin      |
      
          
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmshelf.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    #Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
   # Then I need to select the dropdown "QA" value forLabel "BinCode" using Javascript
    Then I load the testdatas form excel to table
    Then I load the Shelf sheet data to map
    Then I load the rowise Shelf data for "<TestcaseRowName>" rowname
    Then I update value to the Shelf page global Variables
    Then I fill new Shelf data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Shelf 
    Then I read the values from table "tblShelf" in Shelf 
    Then I close connection to Shelf 
    
      Examples: 
      | TestcaseRowName |
      |Shelf      |
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmWarehouse.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Warehouse sheet data to map
    Then I load the rowise Warehouse data for "<TestcaseRowName>" rowname
    Then I update value to the Warehouse page global Variables
    Then I fill new Warehouse data page using excel data
    #Then I need to click on the  element "div#ContentPlaceHolder1_ddlNetCost_chzn"
    #Then I need to select the dropdown "NETCOST" value forLabel "NetCost" using Javascript
    #Then I need to click on the  element "div#ContentPlaceHolder1_ddlType_chzn"
    #Then I need to select the dropdown "A" value forLabel "Type" using Javascript
    Then I need to click on the "Save" button
    Then I establish connection to Warehouse
    Then I read the values from table "tblWareHouse" in Warehouse
    Then I close connection to Warehouse
    
      Examples: 
      | TestcaseRowName |
      |Warehouse     |
      
        
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmSize.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Size sheet data to map
    Then I load the rowise Size data for "<TestcaseRowName>" rowname
    Then I update value to the Size page global Variables
    Then I fill new Size data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Size
    Then I read the values from table "tblSize" in Size
    Then I close connection to Size 
    
      Examples: 
      | TestcaseRowName |
      |Size2      |  
      
      
    
    Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmstyle.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Style sheet data to map
    Then I load the rowise Style data for "<TestcaseRowName>" rowname
    Then I update value to the Style page global Variables
    Then I fill new Style data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Style
    Then I read the values from table "tblInventoryStyle" in Style
    Then I close connection to Style 
    
    
      Examples: 
      | TestcaseRowName |
      |Style     |
      
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmBaseUOM.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Baseuom sheet data to map
    Then I load the rowise Baseuom data for "<TestcaseRowName>" rowname
    Then I update value to the Baseuom page global Variables
    Then I fill new Baseuom data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Baseuom
    Then I read the values from table "TBLUOMCONVMASTER" in Baseuom 
    Then I close connection to Baseuom
    
      Examples: 
      | TestcaseRowName |
      |Baseuom    |
      
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmAddition_Deduction.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the AddDed sheet data to map
    Then I load the rowise AddDed data for "<TestcaseRowName>" rowname
    Then I update value to the AddDed page global Variables
    Then I fill new AddDed data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to AddDed
    Then I read the values from table "tblDiscount" in AddDed
    Then I close connection to AddDed
    
      Examples: 
      | TestcaseRowName |
      |AddDed    |
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmZone.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Zone sheet data to map
    Then I load the rowise Zone data for "<TestcaseRowName>" rowname
    Then I update value to the Zone page global Variables
    Then I fill new Zone data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Zone
    Then I read the values from table "tblZone" in Zone
    Then I close connection to Zone
    
      Examples: 
      | TestcaseRowName |
      |Zone      |
      
       Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Inventory/frmCompanySettings.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the CompanySettings sheet data to map
    Then I load the rowise CompanySettings data for "<TestcaseRowName>" rowname
    Then I update value to the CompanySettings page global Variables
    Then I fill new CompanySettings data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to CompanySettings
    Then I read the values from table "tblcompanyname" in CompanySettings
    Then I close connection to CompanySettings
    
      Examples: 
      | TestcaseRowName |
      |CompanySettings  |
      
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmStockAdjustment.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the StockAdjustmentType sheet data to map
    Then I load the rowise StockAdjustmentType data for "<TestcaseRowName>" rowname
    Then I update value to the StockAdjustmentType page global Variables
    Then I fill new StockAdjustmentType data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to StockAdjustmentType
    Then I read the values from table "tblStockAdjType" in StockAdjustmentType
    Then I close connection to StockAdjustmentType
    
      Examples: 
      | TestcaseRowName |
      |StockAdjustmentType     |
      
      
       Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmManufacturer.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Manufacturer sheet data to map
    Then I load the rowise Manufacturer data for "<TestcaseRowName>" rowname
    Then I update value to the Manufacturer page global Variables
    Then I fill new Manufacturer data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Manufacturer
    Then I read the values from table "tblManufacturer" in Manufacturer
    Then I close connection to Manufacturer
    
      Examples: 
      | TestcaseRowName |
      |Manufacturer      |
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmMerchandise.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvStyle_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Merchandise sheet data to map
    Then I load the rowise Merchandise data for "<TestcaseRowName>" rowname
    Then I update value to the Merchandise page global Variables
    Then I fill new Merchandise data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Merchandise
    Then I read the values from table "tblMerchandise" in Merchandise
    Then I close connection to Merchandise
    
      Examples: 
      | TestcaseRowName |
      |Merchandise      |
      
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmOrigin.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Origion sheet data to map
    Then I load the rowise Origion data for "<TestcaseRowName>" rowname
    Then I update value to the Origion page global Variables
    Then I fill new Origion data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Origion
    Then I read the values from table "tblOrigin" in Origion
    Then I close connection to Origion
    
      Examples: 
      | TestcaseRowName |
      |Origion      |
      
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmTransport.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Transport sheet data to map
    Then I load the rowise Transport data for "<TestcaseRowName>" rowname
    Then I update value to the Transport page global Variables
    Then I fill new Transport data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Transport
    Then I read the values from table "tblTransport" in Transport
    Then I close connection to Transport 
    
      Examples: 
      | TestcaseRowName |
      |Transport      |
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Masters/frmTransport.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "2"
    #Then i send to enter key
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvFloor_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    #Given I need to click on the "Clear" button
    #When Im waiting for 2 sec
    Then I load the testdatas form excel to table
    Then I load the Transport sheet data to map
    Then I load the rowise Transport data for "<TestcaseRowName>" rowname
    Then I update value to the Transport page global Variables
    Then I fill new Transport data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection to Transport
    Then I read the values from table "tblTransport" in Transport
    Then I close connection to Transport 
    
      Examples: 
      | TestcaseRowName |
      |Transport      |
      
      
      Scenario Outline: checking for Vendor master 
	Given I want to launch the "Masters/frmVendorView.aspx" 
	Then I need to click on the "Back" button1
	Then I load the testdata form excel to table
	Then I load the VendorMaster sheet data to map
  Then I load the VendorMaster rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the VendorMaster page global Variables
  Then I fill new VendorMaster data page using excel data
  Then I need to click on the "Save" button
	Then I establish connection to VendorMaster
  Then I read the values from table "tblvendor" in VendorMaster
  Then I close connection to VendorMaster 
	
	
	
	 Examples: 
      | TestcaseRowName|
      |VendorMaster| 
	
	
	Scenario Outline: Title of your scenario outline
   Given I want to launch the "Masters/frmTerms.aspx"
   Then I load the testdata form excel to table
	Then I load the TermsNew sheet data to map
  Then I load the TermsNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the TermsNew page global Variables
  Then I fill new TermsNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to TermsNew
  Then I read the values from table "tblTerms" in TermsNew
  Then I close connection to TermsNew 
    

    Examples: 
      |TestcaseRowName |
      |TermsNew1|
      
	Scenario Outline: check the Display and Contract
    Given I want to launch the "Masters/frmDisplayandContract.aspx"
   Then I load the testdata form excel to table
	Then I load the DisplayandContractNew sheet data to map
  Then I load the DisplayandContractNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the DisplayandContractNew page global Variables
  Then I fill new DisplayandContractNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to DisplayandContractNew
  Then I read the values from table "tblDisplayandContracts" in DisplayandContractNew
  Then I close connection to DisplayandContractNew 

    Examples: 
      |TestcaseRowName|
      |DisplayandContractNew1|
     
      Scenario Outline: check for BankModule
    Given I want to launch the "Masters/frmBankMaster.aspx"
     Then I load the testdata form excel to table
	Then I load the BankNew sheet data to map
  Then I load the BankNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BankNew page global Variables
  Then I fill new BankNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BankNew
  Then I read the values from table "tblBankCode" in BankNew
  Then I close connection to BankNew
    Examples: 
      |TestcaseRowName|
      |BankNew2|
    
    Scenario Outline: checking for SalesMan Master
  Given I want to launch the "Masters/frmSalesManMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the SalesManNew sheet data to map
  Then I load the SalesManNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the SalesManNew page global Variables
  Then I fill new SalesManNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to SalesManNew
  Then I read the values from table "tblSalesMan" in SalesManNew
  Then I close connection to SalesManNew

    Examples: 
      |TestcaseRowName  |
      |SalesManNew |
     
     Scenario Outline: Title of your scenario outline
    Given I want to launch the "Masters/frmDeliveryMan.aspx"
  Then I load the testdata form excel to table
	Then I load the DeliveryManNew sheet data to map
  Then I load the DeliveryManNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the DeliveryManNew page global Variables
  Then I fill new DeliveryManNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to DeliveryManNew
  Then I read the values from table "tblDeliveryMan" in DeliveryManNew
  Then I close connection to DeliveryManNew


    Examples: 
      |TestcaseRowName  |
      |DeliveryManNew  |
      
      
      Scenario Outline: HomeMasterSalesSales ManSales Man Commission Brand
    Given I want to launch the "Masters/frmSalesManCommissionBrand.aspx"
  Then I load the testdata form excel to table
	Then I load the BrandWiseSalesManCommission sheet data to map
  Then I load the BrandWiseSalesManCommission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BrandWiseSalesManCommission page global Variables
  Then I fill new BrandWiseSalesManCommission data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BrandWiseSalesManCommission
  Then I read the values from table "tblSalesManCommissionBrand" in BrandWiseSalesManCommission
  Then I close connection to BrandWiseSalesManCommission

    Examples: 
      |TestcaseRowName|
      |BrandWiseSalesManCommission|
      
      Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmSalesManCommissionItemWise.aspx"
  Then I load the testdata form excel to table
	Then I load the ItemWiseSalesManCommission sheet data to map
  Then I load the ItemWiseSalesManCommission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ItemWiseSalesManCommission page global Variables
  Then I fill new ItemWiseSalesManCommission data page using excel data
  Then I need to click on the "Button11" button3
  Then I fill Add the Item
	Then I need to click on the "Add" button4
	When Im waiting for 2 sec
	Then I need to click on the "Update" button5
	Then I need to click on the "Button3" button6
	Then I need to click on the "Button2" button7
	Then I establish connection to ItemWiseSalesManCommission
  Then I read the values from table "tblSalesManCommissionItem" in ItemWiseSalesManCommission
  Then I close connection to ItemWiseSalesManCommission
  # Given I want to launch the "Masters/frmSalesManCommissionItemsView.aspx"


    Examples: 
      |TestcaseRowName|
      |ItemWiseSalesManCommission|
      
      Scenario Outline: checking for SalesMan Commission 
	Given I want to launch the "Masters/frmSalesManCommissionItemsView.aspx" 
	
	Then I load the testdata form excel to table
	Then I load the SalesManComission sheet data to map
  Then I load the SalesManComission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the SalesManComission page global Variables
  Then I fill new SalesManComission data page using excel data
	Then I need to click on the "Button11" button3
  Then I establish connection to SalesManComission
  Then I read the values from table "tblSalesManCommissionItem" in SalesManComission
  Then I close connection to SalesManComission 
	
	
    Examples: 
      |TestcaseRowName|
      |SalesManComission|
      
       Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmPosPayment.aspx"
  Then I load the testdata form excel to table
	Then I load the POSPaymentNew sheet data to map
  Then I load the POSPaymentNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the POSPaymentNew page global Variables
  Then I fill new POSPaymentNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to POSPaymentNew
  Then I read the values from table "tblPosPaymentSub" in POSPaymentNew
  Then I close connection to POSPaymentNew

    Examples: 
      |TestcaseRowName|
      |POSPaymentNew1|
      
      Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmVehicleMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the VehicleMasterNew sheet data to map
  Then I load the VehicleMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the VehicleMasterNew page global Variables
  Then I fill new VehicleMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to VehicleMasterNew
  Then I read the values from table "tblVehicle" in VehicleMasterNew
  Then I close connection to VehicleMasterNew

    Examples: 
      |TestcaseRowName  |
      |VehicleMasterNew  |
      
      Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmPayMode.aspx"
  Then I load the testdata form excel to table
	Then I load the PaymodeNew sheet data to map
  Then I load the PaymodeNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the PaymodeNew page global Variables
  Then I fill new PaymodeNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to PaymodeNew
  Then I read the values from table "tblPaymode" in PaymodeNew
  Then I close connection to PaymodeNew

    Examples: 
      |TestcaseRowName |
      |PaymodeNew|
      
       Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmHomeDeliveryTrayMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the HomeDeliveryTrayNew sheet data to map
  Then I load the HomeDeliveryTrayNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the HomeDeliveryTrayNew page global Variables
  Then I fill new HomeDeliveryTrayNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to HomeDeliveryTrayNew
  Then I read the values from table "tblBagMaster" in HomeDeliveryTrayNew
  Then I close connection to HomeDeliveryTrayNew


    Examples: 
      |TestcaseRowName |
      |HomeDeliveryTrayNew |
      
      Scenario Outline: Title of your scenario outline
       Given I want to launch the "Masters/frmBarcodePrinter.aspx"
  Then I load the testdata form excel to table
	Then I load the BarCodePrinterNew sheet data to map
  Then I load the BarCodePrinterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BarCodePrinterNew page global Variables
  Then I fill new BarCodePrinterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BarCodePrinterNew
  Then I read the values from table "tblPrinterMaster" in BarCodePrinterNew
  Then I close connection to BarCodePrinterNew


    Examples: 
      |TestcaseRowName |
      |BarCodePrinterNew1 |
      
      
      Scenario Outline: Title of your scenario outline
            Given I want to launch the "Masters/frmParamMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the ParamMasterNew sheet data to map
  Then I load the ParamMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the ParamMasterNew page global Variables
  Then I fill new ParamMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to ParamMasterNew
  Then I read the values from table "TBLPARAMMASTER" in ParamMasterNew
  Then I close connection to ParamMasterNew
      
      Scenario Outline: checking for Picker master 
	Given I want to launch the "Masters/frmPickerMaster.aspx" 
	Then I load the testdata form excel to table
	Then I load the PickerMasterNew sheet data to map
  Then I load the PickerMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the PickerMasterNew page global Variables
  Then I fill new PickerMasterNew data page using excel data
  Then I need to click on the "Save" button
  Then I establish connection to PickerMasterNew
  Then I read the values from table "tblPickerMaster" in PickerMasterNew
  Then I close connection to PickerMasterNew
  
    Examples: 
      |TestcaseRowName|
      |PickerMasterNew1|
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Inventory/Barcode.aspx"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "C0000"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkSearchGrid"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvTaxGST_imgbtnDelete_0"
    #Then I click on button tag with value "YES"
    Then I load the testdatas form excel to table
    Then I load the Barcode sheet data to map
    Then I load the rowise Barcode data for "<TestcaseRowName>" rowname
    Then I update value to the Barcode page global Variables
    Then I fill new Barcode data page using excel data
    Then I need to click on the blue "btnPrint" button
    #Then I need to click on the blue "btnClear" button
    
      Examples: 
      | TestcaseRowName |
      |Barcode      |
      |Barcode1      |
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost

   Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I establish connection  DB for PR
    Then I read the values from PR table "tblPurchaseReturnHeader" in DB
    Then I read the values from PR table "tblAPtransaction" in DB
    Then I read the values from PR table "tblVendorBalance" in DB
    Then I read the values from PR table "tblPurchaseReturnDetail" in DB
    Then I close connection  DB for PR
    
     Examples: 
      | TestcaseRowName |
      |PR1|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmDistributionlist.aspx"
    #Then I need to click on the blue "AddDistb" button
    Then I need to click on the "RetDistb" button
    Then I load the testdatas form excel to table
    Then I load the Distribution sheet data to map
    Then I load the rowise Distribution data for "<TestcaseRowName>" rowname
    Then I update value to the Distribution page global Variables
    Then I fill new Distribution data page using excel data
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |Distribution|
      
      
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Then I load the testdatas form excel to table
    Then I load the Distribution sheet data to map
    Then I load the rowise Distribution data for "<TestcaseRowName>" rowname
    Then I update value to the Distribution page global Variables
    Then I fill new Distribution data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for Distribution
    Then I read the values from Distribution table "tblparentchild" in DB
    Then I close connection  DB for Distribution
    Examples: 
      | TestcaseRowName |
      |Distribution1|
   
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmInventoryChange.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the Inventorychange sheet data to map
    Then I load the rowise Inventorychange data for "<TestcaseRowName>" rowname
    Then I update value to the Inventorychange page global Variables
    Then I fill new Inventorychange data page using excel data
    When Im waiting for 2 sec
    Then I click filter
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I establish connection  DB for InventoryChange
    Then I read the values from InventoryChange table "tblinventory" in DB
    Then I read the values from InventoryChange table "tblinventorypricing" in DB
    Then I read the values from InventoryChange table "tblinventorymaster" in DB
    Then I close connection  DB for InventoryChange
    
     Examples: 
      | TestcaseRowName |
      |Inventorychange5|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Stock/frmAverageCostReset.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the InventoryCostReset sheet data to map
    Then I load the rowise InventoryCostReset data for "<TestcaseRowName>" rowname
    Then I update value to the InventoryCostReset page global Variables
    Then I fill new InventoryCostReset data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I need to click on the  element "input#ContentPlaceHolder1_grdItemDetails_checkAll"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I POPUP handle accept
    Then I establish connection  DB for InventoryCostReset
    Then I read the values from InventoryCostReset table "tblinventory" in DB
    Then I read the values from InventoryCostReset table "tblinventorystock" in DB
    Then I close connection  DB for InventoryCostReset
     Examples: 
      | TestcaseRowName |
      |InventoryCostReset2|
      
   
   Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    Then I fill inventory calculations MRP page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "/Users/macpc/Downloads/download.jpeg"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table "tblinventory" in DB
    Then I read the values from table "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "tblbarcode" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB
    Examples: 
      | TestcaseRowName |
      | cost2            |

    
   Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    When Im waiting for 2 sec
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "12"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table "tblinventory" in DB
    Then I read the values from table "tblinventorypricing" in DB
    Then I read the values from table "tblinventorystock" in DB
    Then I read the values from table "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table "tblInventoryShelfQty" in DB
    Then I close connection to DB

    Examples: 
      | TestcaseRowName |
      | cost1           |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations MRP page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
     Then I establish connection to DB
    Then I read the values from table MRP "tblinventory" in DB
    Then I read the values from table MRP "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB

    Examples: 
      | TestcaseRowName |
      | MRP1            |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP2
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button

    Examples: 
      | TestcaseRowName |
      | MRP2            |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP3
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forimageElement "input#ContentPlaceHolder1_fuimage"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button

    Examples: 
      | TestcaseRowName |
      | MRP3            |

  #Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP4
    #Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    #Then I load the testdata form excel to table
    #Then I load the inventory sheet data to map
    #Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    #Then I update value to the inventory page global Variables
    #Then I fill new inventory data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    #Then I fill the GST values in the inventory page
    #Then I fill inventory calculations page for MRP using excel data
    #Then I verify the actual ui values with expected Excel values
    #Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    #Then I need to click on the "Save" button
    #Then I click dynamically on "NewItemNo" button
#
    #Examples: 
      #| TestcaseRowName |
      #| MRP4            |
   
   
   Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    When Im waiting for 2 sec
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "12"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table "tblinventory" in DB
    Then I read the values from table "tblinventorypricing" in DB
    Then I read the values from table "tblinventorystock" in DB
    Then I read the values from table "tblbarcode" in DB
    Then I read the values from table "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table "tblInventoryShelfQty" in DB
    Then I close connection to DB

    Examples: 
      | TestcaseRowName |
      | cost1           |
      
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations MRP page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table MRP "tblinventory" in DB
    Then I read the values from table MRP "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "tblbarcode" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB
    Examples: 
      | TestcaseRowName |
      | MRP1            |
      
    Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations MRP page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table MRP "tblinventory" in DB
    Then I read the values from table MRP "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "tblbarcode" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB
    Examples: 
      | TestcaseRowName |
      | MRP2            |
      | MRP3            |
      | MRP4            |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMasterView.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I Search Inventory
    Then I fill new inventory data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    #Then I fill the GST values in the inventory page
    #Then I fill inventory calculations MRP page using excel data
    #Then I verify the actual ui values with expected Excel values
    #Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    #Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    #Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table MRP "tblinventory" in DB
    Then I read the values from table MRP "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "tblbarcode" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB
    Examples: 
      | TestcaseRowName |
      |Gopi|

    
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Managements/frmInventoryMovement.aspx"
    Then I load the testdatas form excel to table
    Then I load the Inventorymovement sheet data to map
    Then I load the rowise Inventorymovement data for "<TestcaseRowName>" rowname
    Then I update value to the Inventorymovement page global Variables
    Then I fill new Inventorymovement data page using excel data
    When Im waiting for 2 sec
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkPrint"

    
    
     Examples: 
      | TestcaseRowName |
      |Inventorymovement1|
      
      
       Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmInventoryParameter.aspx"
    Then I load the testdatas form excel to table
    Then I load the InventoryParameter sheet data to map
    Then I load the rowise InventoryParameter data for "<TestcaseRowName>" rowname
    Then I update value to the InventoryParameter page global Variables
    Then I fill new InventoryParameter data page using excel data
    Then I need to click on the "Save" button
    Then I establish connection  DB for InventoryParameter
    Then I read the values from InventoryParameter table "tblinventorybulkstock" in DB
    Then I read the values from InventoryParameter table "tblInventoryBulk" in DB
    Then I close connection  DB for InventoryParameter
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |InventoryParameter|
      
      
       Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmDistributionlist.aspx"
    Then I load the testdatas form excel to table
    Then I load the Distribution sheet data to map
    Then I load the rowise Distribution data for "<TestcaseRowName>" rowname
    Then I update value to the Distribution page global Variables
    Then I fill new Distribution data page using excel data
    #When Im waiting for 2 sec
    Then I need to click on the "Add" button
    Then I need to click on the "Save" button
    Then I establish connection  DB for InventoryParentChildSetting
    Then I read the values from InventoryParentChildSetting table "tblparentchild" in DB
    Then I close connection  DB for InventoryParentChildSetting

    
    
     Examples: 
      | TestcaseRowName |
      |InventoryParentChildSetting|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
      As a unipro user i want to launch the valid URL
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmPackageInventory.aspx"
    Then I load the testdatas form excel to table
    Then I load the Packageinventory sheet data to map
    Then I load the rowise Packageinventory data for "<TestcaseRowName>" rowname
    Then I update value to the Packageinventory page global Variables
    Then I fill new Packageinventory data page using excel data
    Then I need to click on the blue "AddToList" button
    Then I need to click on the "Update" button
    Then I establish connection  DB for Packageinventory
    Then I read the values from Packageinventory table "tblPackageHeader" in DB
    Then I read the values from Packageinventory table "tblPackageDetail" in DB
    Then I close connection  DB for Packageinventory
    #When Im waiting for 2 sec
    
     Examples: 
      | TestcaseRowName |
      |PackageInventory2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmRefillingSchedule.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    Then I load the testdatas form excel to table
    Then I load the RefillingScheduling sheet data to map
    Then I load the rowise RefillingScheduling data for "<TestcaseRowName>" rowname
    Then I update value to the RefillingScheduling page global Variables
    Then I fill new RefillingScheduling data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for RefillingScheduling
    Then I read the values from RefillingScheduling table "tblRefillingSchedule" in DB
    Then I close connection  DB for RefillingScheduling
    
     Examples: 
      | TestcaseRowName |
      |RefillingScheduling4|
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryChange.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_hypReorder"
    When Im waiting for 2 sec
    Then I load the testdata form excel to table
    Then I load the ReorderSettings sheet data to map
    Then I load the rowise ReorderSettings data for "<TestcaseRowName>" rowname
    Then I update value to the ReorderSettings page global Variables
    Then I fill new ReorderSettings data page using excel data
    Then I fill min and maxqty
    Then I need to click on the blue "Update" button
    Then I establish connection  DB for Reordersettings
    Then I read the values from Reordersettings table "tblinventory" in DB
    Then I close connection  DB for Reordersettings

    Examples: 
      | TestcaseRowName |
      |ReorderSettings  |
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmQuickPriceChange.aspx"
    #Then I need to click on sub menu with text matching "Repack"
    Then I load the testdatas form excel to table
    Then I load the LocationWisePriceChange sheet data to map
    Then I load the rowise LocationWisePriceChange data for "<TestcaseRowName>" rowname
    Then I update value to the LocationWisePriceChange page global Variables
    Then I fill new LocationWisePriceChange data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate_Regular"
    Then I establish connection  DB for LocationWisePriceChange
    Then I read the values from LocationWisePriceChange table "tblOutletPricingControl" in DB
    Then I close connection  DB for LocationWisePriceChange
    
     Examples: 
      | TestcaseRowName |
      |LocationWisePriceChange2|
      
  Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPriceChangeBatch.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkBulkBatch"
    Then I load the testdatas form excel to table
    Then I load the PriceChangeBatchItem sheet data to map
    Then I load the rowise PriceChangeBatchItem data for "<TestcaseRowName>" rowname
    Then I update value to the PriceChangeBatchItem page global Variables
    Then I fill new PriceChangeBatchItem data page using excel data
    Then I need to click on the blue "Update" button
    Then I establish connection  DB for PriceChangeBatchItem
    Then I read the values from PriceChangeBatchItem table "tblinventory" in DB
    Then I read the values from PriceChangeBatchItem table "tblinventorypricing" in DB
     Then I read the values from PriceChangeBatchItem table "tblinventorystock" in DB
    Then I read the values from PriceChangeBatchItem table "TBLBATCHINVENTORYCONTROL" in DB
    Then I close connection  DB for PriceChangeBatchItem
    
     Examples: 
      | TestcaseRowName |
      |PriceChangeBatchItem2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPriceChangeNonBatch.aspx"
    Then I load the testdatas form excel to table
    Then I load the PriceChangeNonBatchItem sheet data to map
    Then I load the rowise PriceChangeNonBatchItem data for "<TestcaseRowName>" rowname
    Then I update value to the PriceChangeNonBatchItem page global Variables
    Then I fill new PriceChangeNonBatchItem data page using excel data
    Then I need to click on the blue "Update" button
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkBulkBatch"
    Then I establish connection  DB for PriceChangeNonBatchItem
    Then I read the values from PriceChangeNonBatchItem table "tblOutletPricingControl" in DB
    Then I read the values from PriceChangeNonBatchItem table "tblinventory" in DB
    Then I read the values from PriceChangeNonBatchItem table "tblinventorypricing" in DB
    Then I close connection  DB for PriceChangeNonBatchItem
    
     Examples: 
      | TestcaseRowName |
      |PriceChangeNonBatchItem2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Inventory/frmExportImportPrice.aspx"
    Then I need to click on sub menu with text matching "Import Price"
    Then I enter the value forElement "input#ContentPlaceHolder1_FileUpload1" as "/Users/macpc/Downloads/Sample.xlsx"
    Then I load the testdatas form excel to table
    Then I load the PriceImportExport sheet data to map
    Then I load the rowise PriceImportExport data for "<TestcaseRowName>" rowname
    Then I update value to the PriceImportExport page global Variables
    Then I fill new PriceImportExport data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_Check"
    Then I need to click on the  element "a#ContentPlaceHolder1_InkExport"
    Then I establish connection  DB for PriceImportExport
    Then I read the values from PriceImportExport table "tblOutletPricingControl" in DB
    Then I read the values from PriceImportExport table "tblinventory" in DB
    Then I read the values from PriceImportExport table "tblinventorypricing" in DB
    Then I close connection  DB for PriceImportExport
    
     Examples: 
      | TestcaseRowName |
      |PriceImportExport2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmDayBasedPromotionEdit.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkBack"
    Then I load the testdatas form excel to table
    Then I load the DayBasedPromotion sheet data to map
    Then I load the rowise DayBasedPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the DayBasedPromotion page global Variables
    Then I fill new DayBasedPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for DayBasedPromotion
    Then I read the values from DayBasedPromotion table "tblPromotionDayBased" in DB
    Then I close connection  DB for DayBasedPromotion
    
     Examples: 
      | TestcaseRowName |
      |DayBasedPromotion2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmFreeItemView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the FreeItem sheet data to map
    Then I load the rowise FreeItem data for "<TestcaseRowName>" rowname
    Then I update value to the FreeItem page global Variables
    Then I fill new FreeItem data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for FreeItem
    #Then I read the values from FreeItem table "tblFreeItemGroup" in DB
    Then I read the values from FreeItem table "tblQualifyingItemsForFree" in DB
    Then I read the values from FreeItem table "tblfreeitemslist" in DB
    Then I close connection  DB for FreeItem
    
     Examples: 
      | TestcaseRowName |
      |FreeItem|
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPromotionPrice.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkPromotionfilteration"
    Then I load the testdatas form excel to table
    Then I load the NormalPromotion sheet data to map
    Then I load the rowise NormalPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the NormalPromotion page global Variables
    Then I fill new NormalPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for NormalPromotion
    Then I read the values from NormalPromotion table "tblPromotionPriceChange" in DB
    Then I read the values from NormalPromotion table "tblPromotionHistory" in DB
    Then I read the values from NormalPromotion table "tblRevokePromotionPrice" in DB
    Then I close connection  DB for NormalPromotion
    
     Examples: 
      | TestcaseRowName |
      |NormalPromotion2|
      
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmPromotion.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the OtherPromotion sheet data to map
    Then I load the rowise OtherPromotion data for "<TestcaseRowName>" rowname
    Then I update value to the OtherPromotion page global Variables
    Then I fill new OtherPromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for OtherPromotion
    Then I read the values from OtherPromotion table "tblPromotionHeader" in DB
    Then I read the values from OtherPromotion table "tblPromotionDetail" in DB
    Then I read the values from OtherPromotion table "tblFreeItemDetail" in DB
    Then I close connection  DB for OtherPromotion
    
     Examples: 
      | TestcaseRowName |
      |OtherPromotion3|
      
      Scenario Outline: Title of your scenario outline
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Merchandising/frmRevokePromotion.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkNew"
    Then I load the testdatas form excel to table
    Then I load the RevokePromotion sheet data to map
    Then I load the rowise RevokePromotion data for "<TestcaseRowName>" rowname
    Then I update value to the RevokePromotion page global Variables
    Then I fill new RevokePromotion data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnksave"

    
     Examples: 
      | TestcaseRowName |
      |RevokePromotion|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmAutoPO.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the AutoPO sheet data to map
    Then I load the rowise AutoPO data for "<TestcaseRowName>" rowname
    Then I update value to the AutoPO page global Variables
    Then I fill new AutoPO data page using excel data
    When Im waiting for 2 sec
  Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
   Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate" 
    Then I establish connection  DB for AutoPO
    Then I read the values from AutoPO table "tblpoheader" in DB
    Then I read the values from AutoPO table "tblpoDetail" in DB
    Then I close connection  DB for AutoPO
    
     Examples: 
      | TestcaseRowName |
      |AutoPO1           |
      
      
 Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost  
    Then I need to click on the  element "h1#ui-id-8"
    Then I load the testdatas form excel to table
    Then I load the AutoPO sheet data to map
    Then I load the rowise AutoPO data for "<TestcaseRowName>" rowname
    Then I update value to the AutoPO page global Variables
    Then I fill new AutoPO data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilter"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkFilterOption"
    #Then I enter the value forElement "input#ContentPlaceHolder1_grdItemDetails_txtOrderQty_0" as "2"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkClearAll"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkPrint"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkStock"
    Then I establish connection  DB for AutoPO
    Then I read the values from AutoPO table "tblpoheader" in DB
    Then I read the values from AutoPO table "tblpoDetail" in DB
    Then I close connection  DB for AutoPO
    
   
    Examples: 
      | TestcaseRowName |
      |AutoPO1           |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnGrn_0"
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Yes" button
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    #When Im waiting for 2 sec
    #Then I want to minimize the browser
    #Then I need to click on the "Save" button
    Then I need to click on the blue "Save" button
    Then I establish connection GRN to DB 
    Then I read the values GRN from table "TBLGIDDETAIL" in DB
    Then I read the values GRN from table "TBLGIDHEADER" in DB
    #Then I read the values GRN from table "tblinventory" in DB
    #Then I read the values GRN from table "tblinventorypricing" in DB
    #Then I read the values GRN from table "tblinventorystock" in DB
    #Then I read the values GRN from table "tblBatchInventoryControl" in DB
    #Then I read the values GRN from table "tblInventoryShelfQty" in DB
    Then I close connection GRN to DB
    
    Examples: 
      | TestcaseRowName |
      |GRN           |
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnGrn_0"
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    #Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Yes" button
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    #When Im waiting for 2 sec
    #Then I want to minimize the browser
    #Then I need to click on the "Save" button
    #Then I need to click on the blue "Save" button 
    
    
    Examples: 
      | TestcaseRowName |
      |GRN          |
      
      
      

Scenario Outline:      
      
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    #Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Save" button 

     Examples: 
      | TestcaseRowName |
            |GRN1           |
      |GRN2           |
      |GRN3           |
      |GRN4           |
      |GRN5           |
      |GRN6           |
      |GRN7           |
      |GRN8           |
      |GRN9           | 
      |GRN10           |
      |GRN11           |
      |GRN12           |
      |GRN13           |
      |GRN14           |
      |GRN15           |
      |GRN16           |
      |GRN17           |
      |GRN18           |
      |GRN19           |
      |GRN20           |
      |GRN21           |
      |GRN22           |
      |GRN23           |
      |GRN24           |
      |GRN25           |
      |GRN26           |
      |GRN27           |
      |GRN28           |
      |GRN29           |
      |GRN30           |
      |GRN31           |
      |GRN32           |
      |GRN33           |
      |GRN34           |
      |GRN35           |
      |GRN36           |
      |GRN37           |
      |GRN38           |
      |GRN39           |
      |GRN40           |
      |GRN41           |
      |GRN42           |
      |GRN43           |
      |GRN44           |
      |GRN45           |
      |GRN46           |
      |GRN47           |
      |GRN48           |
      |GRN49           |
      |GRN50           |
      |GRN51           |
      |GRN52           |
      |GRN53           |
      |GRN54           |
      |GRN55           |
      |GRN56           |
      |GRN57           |
      |GRN58           |
      |GRN59           |
      |GRN60           |
      |GRN61           |
      |GRN62           |
      |GRN63           |
      |GRN64           |
      |GRN65           |
      |GRN66           |
      |GRN67           |
      |GRN68           |
      |GRN69           |
      |GRN70           |
      |GRN71           |
      |GRN72           |
      |GRN73           |
      |GRN74           |
      |GRN75           |
      |GRN76           |
      |GRN77           |
      |GRN78           |
      |GRN79           |
      |GRN80           |
      |GRN81           |
      |GRN82           |
      |GRN83           |
      |GRN84           |
      |GRN85           |
      |GRN86           |
      |GRN87           |
      |GRN88           |
      |GRN89           |
      |GRN90           |
      |GRN91           |
      |GRN92           |
      |GRN93           |
      |GRN94           |
      |GRN95           |
      |GRN96           |
      |GRN97           |
      |GRN98           |
      |GRN99           |
      |GRN100           |
      |GRN101           |
      |GRN102           |
      |GRN104           |
      |GRN105           |
      |GRN106           |
      |GRN107           |
      |GRN108           |
      |GRN109           |
      |GRN110           |
      |GRN111           |
      |GRN112           |
      |GRN113           |
      |GRN114          |
      |GRN115          |
      |GRN116          |
      |GRN117          |
      |GRN118          |
      |GRN120          | 
      |GRN121          |
      |GRN122          |
      |GRN123          |
      |GRN124          |
      |GRN125          |
      |GRN126          |
      |GRN128          |
      |GRN129          |
      |GRN130          |
      |GRN131          |
      |GRN132          |
      |GRN133          |
      |GRN134          |
      |GRN136          |
      |GRN137          |
      |GRN138          |
      |GRN139          |
      |GRN140          |
      |GRN141          |
      |GRN142          |
      |GRN143          |
      |GRN144          |
      |GRN145          |
      |GRN146          |
      |GRN147          |
      |GRN148          |
      |GRN149          |
      |GRN150          |
      |GRN151          |
      |GRN152          |
      |GRN153          |
      |GRN154          |
      |GRN155          |
      |GRN156          |
      |GRN157          |
      |GRN158          |
      |GRN159          |
      |GRN160          |
      |GRN161          |
      |GRN162          |
      |GRN163          |
      |GRN164          |
      |GRN165          |
      |GRN166          |
      |GRN167          |
      |GRN168          |
      |GRN169          |
      |GRN170          |
      |GRN171          |
      |GRN172          |
      |GRN173          |
      |GRN174          |
      |GRN175          |
      |GRN176          |
      |GRN177          |
      |GRN178          |
      |GRN179          |
      |GRN180          |
      |GRN181          |
      |GRN182          |
      |GRN183          |
      |GRN184          |
      |GRN185          |
      |GRN186          |
      |GRN187          |
      |GRN188          |
      |GRN189          |
      |GRN190          |
      |GRN191          |
      |GRN192          |
      |GRN193          |
      |GRN194          |
      |GRN195          |
      |GRN196          |
      |GRN197          |
      |GRN198          |


      
   Scenario Outline:      
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    Then I need to click on the blue "Save" button 
    
       Examples: 
      | TestcaseRowName |
      |GRN199           |
    
    
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmSupplierNoteSummary.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkNewButton"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkrefresh"
    #Then I need to click on the  print
    #Then I need to click on the  Delete
    #Given I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the CreditDebitnote sheet data to map
    Then I load the rowise CreditDebitnote data for "<TestcaseRowName>" rowname
    Then I update value to the CreditDebitnote page global Variables
    Then I fill new CreditDebitnote data page using excel data
    Then I need to click on the blue "Save" button
    Then I establish connection  DB for CreditDebitnote
    Then I read the values from CreditDebitnote table "tbldebitnote" in DB
    Then I read the values from CreditDebitnote table "tblAPtransaction" in DB
    Then I close connection  DB for CreditDebitnote
    
    
     Examples: 
      | TestcaseRowName |
      |CreditDebitnote|
      
       Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPaymentsView.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrPayment_btnPay_0"
    Then I load the testdatas form excel to table
    Then I load the Payments sheet data to map
    Then I load the rowise Payments data for "<TestcaseRowName>" rowname
    Then I update value to the Payments page global Variables
    Then I fill new Payments data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for Payments
    Then I read the values from Payments table "tblPaymentHeader" in DB
    Then I read the values from Payments table "tblPaymentDetail" in DB
    Then I read the values from Payments table "tblRTGS" in DB
    Then I read the values from Payments table "tblAPTransaction" in DB
    Then I read the values from Payments table "tblDebitNote" in DB
    Then I read the values from Payments table "tblCreditNote" in DB
    Then I read the values from Payments table "tblDisplayheader" in DB
    Then I read the values from Payments table "tblReceiptDetail" in DB
    Then I close connection  DB for Payments
    
    
     Examples: 
      | TestcaseRowName |
      |Payments|
      
      Scenario Outline: Home > Master > Inventory > Category Master
    Given I want to launch the "Purchase/frmVenderChangeForPO.aspx"
    Then I load the testdatas form excel to table
    Then I load the PoVendorChange sheet data to map
    Then I load the rowise PoVendorChange data for "<TestcaseRowName>" rowname
    Then I update value to the PoVendorChange page global Variables
    Then I fill new PoVendorChange data page using excel data
    Then I need to click on the "Update" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the "Clear" button
    Then I establish connection  DB for PoVendorChange
    Then I read the values from PoVendorChange table "tblpoheader" in DB
    Then I read the values from PoVendorChange table "tblpoDetail" in DB
    Then I close connection  DB for PoVendorChange
    
      Examples: 
      | TestcaseRowName |
      |PoVendorChange   |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPurchaseOrderView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_chkApporved"
    #Then I need to click on the  element "a#ContentPlaceHolder1_gvPO_lnkApporve_0"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoad"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPO_imgbtnEdit_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPO_imgbtnDelete_0"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the blue "Yes" button
    Then I load the testdatas form excel to table
    Then I load the PO sheet data to map
    Then I load the rowise PO data for "<TestcaseRowName>" rowname
    Then I update value to the PO page global Variables
    Then I fill new PO data page using excel data
    When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_0" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_1" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_2" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_3" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_4" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_5" as "1"
    #Then I enter the send Keys "input#ContentPlaceHolder1_txtItemCodeAdd" as "F3"
    #When Im waiting for 2 sec
    Then I need to click on the blue "AddInv" button
    Then I need to click on the blue "Save" button
     Then I establish connection  DB for PO
    Then I read the values from PO table "tblpoheader" in DB
    Then I read the values from PO table "tblpoDetail" in DB
    Then I close connection  DB for PO
    #Then I need to click on the  Xpath "/html/body/div[5]/div[3]/div/button"
    
    
    
     Examples: 
      | TestcaseRowName |
      |PO           |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPurchaseReturnList.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdPurchaseReturnList_btnVendorChange_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_grdPurchaseReturnList > tbody > tr > td:nth-child(1) > input[type=button]"
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    #Then I need to click on the  element "div#ContentPlaceHolder1_ReturnTypeDropDown_chzn"
    #Then I need to select the Vendor "RETURN" value forLabel "ReturnType" using Javascript  
    Then I load the testdatas form excel to table
    Then I load the PRR sheet data to map
    Then I load the rowise PRR data for "<TestcaseRowName>" rowname
    Then I update value to the PRR page global Variables
    Then I fill new PRR data page using excel data       
    When Im waiting for 2 sec
    Then I need to click on the "Add" button
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    Then I establish connection  DB for PRR
    Then I read the values from PRR table "tblPurchaseReturnReqDetail" in DB
    Then I read the values from PRR table "tblPurchaseReturnReqHeader" in DB
    Then I close connection  DB for PRR
    
    
    
     Examples: 
      | TestcaseRowName |
      |PRR           |
      
       Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Purchase/frmPurchaseReturnView.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the PR sheet data to map
    Then I load the rowise PR data for "<TestcaseRowName>" rowname
    Then I update value to the PR page global Variables
    Then I fill new PR data page using excel data
    When Im waiting for 2 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorItem_txtLQty_0" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_1" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_2" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_3" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_4" as "1"
    #Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorLoadItemList_txtQty_5" as "1"
    #Then I enter the send Keys "input#ContentPlaceHolder1_txtItemCodeAdd" as "F3"
    #When Im waiting for 2 sec
    Then I need to click on the "Save" button
    Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button"
    Then I establish connection  DB for PR
    Then I read the values from PR table "tblPurchaseReturnHeader" in DB
    Then I read the values from PR table "tblAPtransaction" in DB
    Then I read the values from PR table "tblVendorBalance" in DB
    Then I read the values from PR table "tblPurchaseReturnDetail" in DB
    Then I close connection  DB for PR
    
    
     Examples: 
      | TestcaseRowName |
      |PR1           |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmVendorCataLog.aspx"
    #Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    #Then I need to search vendor
    When Im waiting for 2 sec
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnPrint_0"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvPR_imgbtnDelete_0"
    #Then I need to click on the blue "Yes" 
    #Then I need to click on the  Xpath "/html/body/div[6]/div[3]/div/button[1]"
    Then I load the testdatas form excel to table
    Then I load the Vendorcatelog sheet data to map
    Then I load the rowise Vendorcatelog data for "<TestcaseRowName>" rowname
    Then I update value to the Vendorcatelog page global Variables
    Then I fill new Vendorcatelog data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtMrp_0" as "200"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtBasicCostNew_0" as "150"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPerNew_0" as "1"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPer2_0" as "1"
    Then I enter the value forElement "input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPer3_0" as "1"
    #Then I need to click on the  element "input#ContentPlaceHolder1_gvVendorCat_chkSingle_0"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for Vendorcatelog
    Then I read the values from Vendorcatelog table "tblvendorcatlog" in DB
    Then I read the values from Vendorcatelog table "tblInventoryPricing" in DB
    Then I close connection  DB for Vendorcatelog
  
    
    
    
     Examples: 
      | TestcaseRowName |
      |Vendorcatelog1    |
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Masters/frmBillCancel.aspx"
    Then I load the testdatas form excel to table
    Then I load the Billcancel sheet data to map
    Then I load the rowise Billcancel data for "<TestcaseRowName>" rowname
    Then I update value to the Billcancel page global Variables
    Then I fill new Billcancel data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkBillCancel"
    Then I establish connection  DB for Billcancel
    Then I read the values from Billcancel table "tblSalesReturnDetail" in DB
    Then I read the values from Billcancel table "tblSalesReturnheader" in DB
    Then I close connection  DB for Billcancel
    
    
     Examples: 
      | TestcaseRowName |
      |Billcancel1|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Managements/frmCreditInvoice.aspx"
    Then I load the testdatas form excel to table
    Then I load the Creditinvoice sheet data to map
    Then I load the rowise Creditinvoice data for "<TestcaseRowName>" rowname
    Then I update value to the Creditinvoice page global Variables
    Then I fill new Creditinvoice data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for Creditinvoice
    Then I read the values from Creditinvoice table "tblSalesDetailCur" in DB
    #Then I read the values from Creditinvoice table "tblSalesDetail" in DB
    Then I read the values from Creditinvoice table "tblSalesHeaderCur" in DB
    Then I read the values from Creditinvoice table "tblPaymodeDetailCur" in DB
    Then I read the values from Creditinvoice table "tblsalesheaderERP" in DB
    Then I read the values from Creditinvoice table "tbl_pos_Sales_header" in DB
    Then I close connection  DB for Creditinvoice
    
    
     Examples: 
      | TestcaseRowName |
      |Creditinvoice|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Sales/frmCustomerReceipts.aspx"
    Then I need to click on the  element "#ContentPlaceHolder1_gvCustomerReceipts > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=button]"
    Then I load the testdatas form excel to table
    Then I load the CustomerReceipts sheet data to map
    Then I load the rowise CustomerReceipts data for "<TestcaseRowName>" rowname
    Then I update value to the CustomerReceipts page global Variables
    Then I fill new CustomerReceipts data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for CustomerReceipts
    Then I read the values from CustomerReceipts table "tblReceiptDetail" in DB
    Then I read the values from CustomerReceipts table "tblReceiptHeader" in DB
    Then I close connection  DB for CustomerReceipts
    
    
     Examples: 
      | TestcaseRowName |
      |CustomerReceipts|
      
      
       Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Sales/frmSalesOrder.aspx"
    Then I load the testdatas form excel to table
    Then I load the SalesOrder sheet data to map
    Then I load the rowise SalesOrder data for "<TestcaseRowName>" rowname
    Then I update value to the SalesOrder page global Variables
    Then I fill new SalesOrder data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for SalesOrder
    Then I read the values from SalesOrder table "tblSODetail" in DB
    Then I read the values from SalesOrder table "tblSOHeaderERP" in DB
    Then I read the values from SalesOrder table "tbl_pos_sales_order_header" in DB
    Then I read the values from SalesOrder table "tblSODetailERP" in DB
    Then I close connection  DB for SalesOrder
    
    
     Examples: 
      | TestcaseRowName |
      |SalesOrder|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Sales/frmSalesTransaction.aspx"
    #Then I need to click on the  element "#ContentPlaceHolder1_gvCustomerReceipts > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=button]"
    Then I load the testdatas form excel to table
    Then I load the SalesTransaction sheet data to map
    Then I load the rowise SalesTransaction data for "<TestcaseRowName>" rowname
    Then I update value to the SalesTransaction page global Variables
    Then I fill new SalesTransaction data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkLoadData"
    Then I establish connection  DB for SalesTransaction
    Then I read the values from SalesTransaction table "vwPaymodeDetail" in DB
    Then I read the values from SalesTransaction table "vwSalesheader" in DB
    #Then I read the values from SalesTransaction table "tbl_pos_sales_order_header" in DB
    #Then I read the values from SalesTransaction table "tblSODetailERP" in DB
    Then I close connection  DB for SalesTransaction
    
    
     Examples: 
      | TestcaseRowName |
      |SalesTransaction1|
    
    
    Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmExpiredDateChange.aspx"
    Then I load the testdatas form excel to table
    Then I load the ExpiredDateChange sheet data to map
    Then I load the rowise ExpiredDateChange data for "<TestcaseRowName>" rowname
    Then I update value to the ExpiredDateChange page global Variables
    Then I fill new ExpiredDateChange data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for ExpiredDateChange
    Then I read the values from ExpiredDateChange table "tblBatchInventoryControl" in DB
    Then I read the values from ExpiredDateChange table "tblExpireDate_Modification" in DB
    Then I close connection  DB for ExpiredDateChange
    
    
     Examples: 
      | TestcaseRowName |
      |ExpiredDateChange|
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmStockAdjustmentSummery.aspx"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I load the testdatas form excel to table
    Then I load the StockAdjustment sheet data to map
    Then I load the rowise StockAdjustment data for "<TestcaseRowName>" rowname
    Then I update value to the StockAdjustment page global Variables
    Then I fill new StockAdjustment data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    Then I establish connection  DB for StockAdjustment
    #Then I read the values from StockAdjustment table "tblStockAdjHeader" in DB
    Then I read the values from StockAdjustment table "tblStockAdjDetail" in DB
    Then I read the values from StockAdjustment table "tblBatchInventoryControl" in DB
    Then I read the values from StockAdjustment table "tblinventorystock" in DB
    Then I close connection  DB for StockAdjustment
    
    
     Examples: 
      | TestcaseRowName |
      |StockAdjustment2|
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryStockReset.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockReset sheet data to map
    Then I load the rowise StockReset data for "<TestcaseRowName>" rowname
    Then I update value to the StockReset page global Variables
    Then I fill new StockReset data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I establish connection  DB for StockReset
    Then I read the values from StockReset table "tblBatchInventoryControl" in DB
    Then I read the values from StockReset table "tblinventorystock" in DB
    Then I read the values from StockReset table "tblInventoryStockReset" in DB
    Then I close connection  DB for StockReset
    
    
     Examples: 
      | TestcaseRowName |
      |StockReset4|
      
      
      Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmStockUpdate.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockUpdate sheet data to map
    Then I load the rowise StockUpdate data for "<TestcaseRowName>" rowname
    Then I update value to the StockUpdate page global Variables
    Then I fill new StockUpdate data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter"
    Then I fill new Qty data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for StockUpdate
    Then I read the values from StockUpdate table "tblBatchStockTake" in DB
    #Then I read the values from StockUpdate table "tblPaymentDetail" in DB
    Then I close connection  DB for StockUpdate
    
    
     Examples: 
      | TestcaseRowName |
		  |StockUpdate4|
		  
		  
		   Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Stock/frmStockUpdatePosting.aspx"
    Then I load the testdatas form excel to table
    Then I load the StockUpdatePosting sheet data to map
    Then I load the rowise StockUpdatePosting data for "<TestcaseRowName>" rowname
    Then I update value to the StockUpdatePosting page global Variables
    Then I fill new StockUpdatePosting data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkUpdate"
    Then I need to click on the  element "a#ContentPlaceHolder1_LinkButton3"
    Then I establish connection  DB for StockUpdatePosting
    Then I read the values from StockUpdatePosting table "tblStockTakeAdjustment" in DB
    Then I read the values from StockUpdatePosting table "vwInventoryStockLoc" in DB
    Then I close connection  DB for StockUpdatePosting
    
    
     Examples: 
      | TestcaseRowName |
      |StockUpdatePosting|
      
      