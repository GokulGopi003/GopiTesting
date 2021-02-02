Feature: PoS Master > Sales >pay mode  #pending for enterpriser web

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #@master
  #Scenario: checking for Pay mode
  #Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmPayMode.aspx"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtPosition" as "654"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtPayMode" as "kalai"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtCommission" as "65"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtServiceCharge" as "90"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtGLAccountCode" as "88"
  #Then I enter the value forElement "#ContentPlaceHolder1_txtDiscount" as "11"
  #And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
  #Then I click on the save button
  @master
  Scenario: checking for Pay mode
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmPayMode.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtPosition" as "654"
    Then I enter the value forElement "#ContentPlaceHolder1_txtPayMode" as "kalai"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai"
    Then I enter the value forElement "#ContentPlaceHolder1_txtCommission" as "65"
    Then I enter the value forElement "#ContentPlaceHolder1_txtServiceCharge" as "90"
    Then I enter the value forElement "#ContentPlaceHolder1_txtGLAccountCode" as "88"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDiscount" as "11"
    # And I click on the checkBox forElement "input#ContentPlaceHolder1_chkStatus"
    # And I click on the checkBox forElement  "input#ContentPlaceHolder1_chkDenamination"
    Given I need to click on the "Save" button
    Then I need to click on OK button "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 3 sec
    Then I click on the "input#ContentPlaceHolder1_gvPayMode_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtDescription" as "kalai111"
    Given I need to click on the "Save" button
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 5 sec
    # input#ContentPlaceHolder1_gvDelivery_imgbtnDelete_0
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "kalai"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvPayMode_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 2 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
