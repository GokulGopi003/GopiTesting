Feature: PoS Master > Location

  Background: As a unixpro user i want to launch the valid URL
   
  @Promotion
  Scenario: Verifying the Category Attribute Mapping Functionality
   Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    And I want to maxmize the browser
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Merchandising/frmDayBasedPromotionEdit.aspx"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkBack.button-blue"
    Then I enter the value forElement "textarea#ContentPlaceHolder1_txtPromoDescription" as "Monday Offer"
    Given I need to click on the  element "input.default"
    Then I enter the value forElement "input.default" as "Monday"
    When I press downArrow from element "input.default"  and click enter key
    Then I enter the value forElement "input#ContentPlaceHolder1_txtDiscount" as "20"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_cblLocation_0"
    Then I enter the value forElement "input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode" as "001569"
    When I press downArrow from element "input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode"  and click enter key
    When I click dynamically on "Fetch" button
    When Im waiting for 3 sec
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chSelectAllGrid"
    Given I need to click on the  element "a#ContentPlaceHolder1_lnkAdd.button-green"
