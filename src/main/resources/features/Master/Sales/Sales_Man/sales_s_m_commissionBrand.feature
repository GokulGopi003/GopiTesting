Feature: PoS Master > Sales > Sales man >commission brand  @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@master
  #Scenario: checking for Commission Brand
  #	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManCommissionBrand.aspx"
  #	Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
  #Then I need to select the dropdown "3 ROSES" value forLabel "BrandCode" using Javascript
  #	Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "5"
  #	Then I enter the value forElement "input#ContentPlaceHolder1_txtCommission" as "23"
  #	Then I click on the save button
  @master
  Scenario: checking for Commission Brand
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmSalesManCommissionBrand.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 2 sec
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "3 ROSES" value forLabel "BrandCode" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "5"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCommission" as "23"
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    # Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as <BrandCode>
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "3"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvSalesManCommissionBrand_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBrandName" as "122"
    Given I need to click on the "Save" button
    When Im waiting for 5 sec
    #  Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as <DepartmentName>
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "3"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvSalesManCommissionBrand_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
