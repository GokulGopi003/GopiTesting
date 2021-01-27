Feature: Management > Banking > Registration > Link_Account > Account_Statement  #some coding defect

  # defect for clear button
  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @Registration
  Scenario: checking for Dashboard
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmRegistration.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCORPID " as "30"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUSERID " as "20"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAliasId " as "2"
   # Given I need to click on the  element "a#ContentPlaceHolder1_lnkSelfApproval"  #icici link
    When Im waiting for 2 sec

  @Link_Account
  Scenario: checking for Web Dashboard
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmLinkAccount.aspx"
    Given I need to click on the "Clear" button
    Then I enter the value forElement "input#ContentPlaceHolder1_txtCORPID " as "30"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUSERID " as "20"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAccountNo " as "65655654642"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkPrimary"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    When Im waiting for 2 sec

  @Account_Statement
  Scenario: checking for Dashboard
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmAccountStatement.aspx"
    When Im waiting for 1 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkBalance"
    When Im waiting for 2 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtFromDate " as "21-05-2018"
    Given I need to click on the  element "button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all"
    When Im waiting for 2 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave"
    When Im waiting for 2 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkExport"
