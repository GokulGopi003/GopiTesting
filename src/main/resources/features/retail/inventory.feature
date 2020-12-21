Feature: PoS Automation

  Background: 
      As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @unixpro
  Scenario: POS Login Scenario
    Then I click on Add "Inventory"
    Then I click on a dropdown value "Inventory History"
    And I need to enter "FABER CASTELL HAIR BANDS" search text
    And I click on search button
    Then I need to click on Edit Icon
