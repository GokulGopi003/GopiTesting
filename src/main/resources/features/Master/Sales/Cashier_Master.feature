Feature: PoS Master > Sales >Cashier Master

  Background: 
    As a unixpro user i want to launch the valid URL   #1 failed

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #
  #@master
  #Scenario: checking for Cashier Master
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmCashier.aspx"
  #Given I need to click on the "Clear" button
  #Then I enter the value forElement "#ContentPlaceHolder1_txtCashierID" as "654"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtCashierName" as "kalai"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtPassword" as "kalai455"
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
  #Given I need to click on the "Save" button
  @master
  Scenario: checking for Cashier Master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmCashier.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtCashierID" as "654"
    Then I enter the value forElement "#ContentPlaceHolder1_txtCashierName" as "kalai"
    Then I enter the value forElement "#ContentPlaceHolder1_txtPassword" as "kalai455"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvCashier_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtPassword" as "kalai000"
    Given I need to click on the "Save" button
    When Im waiting for 5 sec
    # input#ContentPlaceHolder1_gvDelivery_imgbtnDelete_0
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "kalai"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvCashier_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 2 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
