Feature: Security > User_Master #Edit fn index number problem

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for User_Master
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Security/frmUserMaster.aspx"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkNew.button-blue"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUserCode" as "111"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUserName" as "kalaimathy"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtLoginName" as "kalaiprabhu"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPassword" as "kalai"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtConfirmPassword" as "kalai"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtExpiryDays" as "25"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtUserLevel" as "2"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAuthenticationPassword" as "prabhu"
    Then I need to invoke the DropDown by Index 0 if text matching "Select User Group"
    Then I need to select the dropdown "ADMIN" value forLabel "UserGroup" using Javascript
    Then I need to invoke the DropDown by Index 1 if text matching "Select Designation"
    Then I need to select the dropdown "Manager" value forLabel "Designation" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtPhoneNo" as "9787167001"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtEmail" as "kalai@gmail.com"
    When Im waiting for 3 sec
    Then I need to click on DropDown forElement "div#ContentPlaceHolder1_lstLocation_chzn"
    When Im waiting for 3 sec
    Then I need to click on DropDown value forElement "li#ContentPlaceHolder1_lstLocation_chzn_o_1"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave.button-red"
    When Im waiting for 3 sec
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkbtnOk.button-blue"
   # Edit fn
    #Then I enter the value forElement "input#txtUserCode" as "111"
    #When Im waiting for 3 sec
    #Given I need to click on the  element "input#ContentPlaceHolder1_rptUsers_imgbtnEdit_0"
    #Then I need to click on  indexwise element ""
    #When Im waiting for 3 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtgroupname" as "kalaimathyprabhu"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave.button-red"
    #Delete fn
    #When Im waiting for 3 sec
    #Then I enter the value forElement "input#txtGroupCode" as "100"
    #Given I need to click on the  element "input#ContentPlaceHolder1_rptUsers_imgbtnDelete_0"
