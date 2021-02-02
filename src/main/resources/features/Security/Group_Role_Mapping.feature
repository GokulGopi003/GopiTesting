Feature: Security > Group_Role_Mapping #edit and delete fn pblm

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @management
  Scenario: checking for Group_Role_Mapping
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Security/frmGroupRoleMapping.aspx"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkNew.button-blue"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtgroupcode" as "100"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtgroupname" as "kalaimathy"
    #And I click on the checkBox forElement "input#ContentPlaceHolder1_rptRole_chkAccess_left_8"
    #Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave.button-red"
    #Edit fn
    Then I enter the value forElement "input#txtGroupCode" as "12"
    When Im waiting for 3 sec
     Then I need to find and click on the element "input#ContentPlaceHolder1_rptUsers_imgbtnEdit_" with multiple indexs
    When Im waiting for 3 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_txtgroupname" as "kalaimathyprabhu"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkSave.button-red"

    When Im waiting for 3 sec
    Then I enter the value forElement "input#txtGroupCode" as "100"
    Then I need to find and click on the element "input#ContentPlaceHolder1_rptUsers_imgbtnDelete_" with multiple indexs

    
