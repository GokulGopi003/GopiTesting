Feature: PoS Master > Sales > Sales man >Delivery man @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  #
  #@master
  #Scenario: checking for SalesMan Master
  #	Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmDeliveryMan.aspx"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManId" as "5"
  #	Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManName" as "Prabhu"
  #	Then I click on the Active button
  #	Then I click on the save button
  #
  @master
  Scenario: checking for SalesMan Master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmDeliveryMan.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManId" as "5"
    Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManName" as "qwerer"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I click on the "input#ContentPlaceHolder1_gvDelivery_imgbtnEdit_0" of "edit" icon
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtDeliveryManName" as "qwereradsfd"
    Given I need to click on the "Save" button
    When Im waiting for 5 sec
    # input#ContentPlaceHolder1_gvDelivery_imgbtnDelete_0
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "qw"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 5 sec
    Then I click on the "input#ContentPlaceHolder1_gvDelivery_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
