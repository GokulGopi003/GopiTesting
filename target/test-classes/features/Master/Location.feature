Feature: PoS Master > Location @done

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: Home> Master> LocationMaster
    Given I want to launch the"http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmLocationMaster.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 3 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtLocCode" as "6"
    Then I text the location name "Trichy"
    Then I enter the value forElement "#ContentPlaceHolder1_txtAddress1" as "412"
    Then I enter the value forElement "#ContentPlaceHolder1_txtAddress2" as "karapakkam"
    Then I enter the value forElement "#ContentPlaceHolder1_txtAddress3" as "chennai"
    Then I enter the value forElement "#ContentPlaceHolder1_txtPhone" as "4645782341"
    Then I enter the value forElement "#ContentPlaceHolder1_txtFax" as "467"
    Then I text the incharge name "kalaimathy"
    Then I enter the SortCode "5"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkWareHouse"
    Then I need to select the dropdown value as "1ST FLOOR" for warehouse
    Given I need to click on the "Save" button
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Trichy"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    Then I click on the "input#ContentPlaceHolder1_gvLocation_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "#ContentPlaceHolder1_txtAddress3" as "chennai editted"
    Given I need to click on the "Save" button
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtSearch" as "Trichy"
    When I press downArrow from element "input#ContentPlaceHolder1_txtSearch"  and click enter key
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvLocation_imgbtnDelete_0" of "delete" icon
    When Im waiting for 5 sec
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
