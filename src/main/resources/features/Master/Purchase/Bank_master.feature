Feature: Purchase > Bank master   #alert check pblm

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@master
  #Scenario: checking for  Bank master
  #	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBankMaster.aspx"
  #
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtBankCode" as "666"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtBankName" as "Prabhu"
  #
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
  #	Then I click on the save button
  Scenario: checking for  Bank master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmBankMaster.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtBankCode" as "666"
    Then I enter the value forElement "#ContentPlaceHolder1_txtBankName" as "Prabhu"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkActive"
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Prabhu"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvLocation_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "#ContentPlaceHolder1_txtBankName" as "Prabhu editted"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Prabhu"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvLocation_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
