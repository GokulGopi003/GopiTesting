Feature: Master > Customer >Member Gift Voucher

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master  @error_line21
  Scenario: checking for  Member Gift Voucher
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmMemberGiftVoucher.aspx"
    Given I need to click on the "Clear" button
    When Im waiting for 2 sec
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherCode" as "675"
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherAmt" as "098"
    Then I enter the value forElement "#ContentPlaceHolder1_txtRewardUsagePoints" as "900"
    Then I click on the save button
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvMemberGiftVoucher_imgbtnEdit_0" of "edit" icon
    Then I enter the value forElement "#ContentPlaceHolder1_txtVoucherAmt" as "0981"
    When Im waiting for 2 sec
    Then I click on the "input#ContentPlaceHolder1_gvMemberGiftVoucher_imgbtnDelete_0" of "delete" icon
    Then I confirm delete operation by clicking on "button.ui-button.ui-corner-all.ui-widget"
