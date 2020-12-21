Feature: PoS Master > Location

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  
  	@inventory @Department
  Scenario: Home > Master > Inventory > Department Master
  Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmDepartmentMaster.aspx"
  
  Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptCode.form-control-res" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtDeptName.form-control-res" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtPerInChrg.form-control-res" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "1548780"
  
  
  	 @inventory @Category
  Scenario: Home > Master > Inventory > Category Master
  Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmCategoryMaster.aspx"
  
  Then I enter the value forElement "input#ContentPlaceHolder1_txtCateCode" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtCateName" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks.form-control-res" as "1548780"
  Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  Then I need to select the dropdown "CLEANING" value forLabel "Dept" using Javascript
  
  @inventory @Category
  Scenario: Home > Master > Inventory > SubCategory
  Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmsubCategory.aspx"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtSubCategoryCode" as "1548780"
  Then I enter the value forElement "input#ContentPlaceHolder1_txtSubCategoryName" as "1548780"
  Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  Then I need to select the dropdown "BABY OIL" value forLabel "Category" using Javascript
  Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscountPercent" as "1548780"
  @inventory @Category
  Scenario: Home > Master > Inventory > Brand
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/frmBrandMaster.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandCode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtRemarks" as "1548780"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "BABY OIL" value forLabel "Category" using Javascript

  @inventory @Category
  Scenario: Home > Master > Inventory > Floor
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmFloor.aspx"
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "CBE" value forLabel "Location" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFloorCode" as "1548780"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "1548780"
    
    
     @inventory @Category
  Scenario: Home > Master > Inventory > Class
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmClass.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "Description"
     Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "Description"
     
      @inventory @Category
  Scenario: Home > Master > Inventory > Sub Class
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSubClass.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSubclassCode" as "Description"
     Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "Description"
  
       @inventory @Category
  Scenario: Home > Master > Inventory > Tax Master
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmTaxMasterGST.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtnormaligstper" as "10"
    
    
    @inventory @Category
  Scenario: Home > Master > Inventory > UOM
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmUOM.aspx"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUOMCode" as "10"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDescription" as "10"
     Then I enter the value forElement "input#ContentPlaceHolder1_txtUnit" as "10"
   
  
