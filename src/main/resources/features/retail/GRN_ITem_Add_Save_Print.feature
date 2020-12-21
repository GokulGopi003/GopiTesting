Feature: As GRN User I want ADD,SAVE and Print the Items from GRN entry

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  Scenario: ADD SAVE and Print GRN Items
    Then I click on Add "Purchase"
    Then I click on a dropdown value "GA/GRN"
    Then I need to click on a GoButton
    Then I enter "161071" in GRN Entry Screen


