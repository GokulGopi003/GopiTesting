Feature: PoS Master > Inventory > Category Attribute Mapping

  Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario: Verifying the Category Attribute Mapping Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Masters/frmTerminalView.aspx"
    Then I need to click on the new button for creating a Terminal
    Then I need to invoke the DropDown by Index 0 if text matching "-- Select --"
    Then I need to select the dropdown "Head Quaters" value using Javascript
    And Im press the sapce bar and enter key
    And typing system name as "Main System"
    Then I need to invoke the DropDown by Index 1 if text matching "-- Select --"
    Then I need to select the dropdown "FOURTH FLOOR" value forLabel "Floor" using Javascript
    Then I need to invoke the DropDown by Index 2 if text matching "-- Select --"
    Then I need to select the dropdown "Standard" value forLabel "PosScreen" using Javascript
    Then I need to invoke the DropDown by Index 3 if text matching "-- Select --"
    Then I need to select the dropdown "Normal" value forLabel "TillType" using Javascript
    Then I enter the value forElement "input#ContentPlaceHolder1_txtTillCode.form-control-res" as "10"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtTillDesc.form-control-res" as "10"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkSpecialCounter"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkIsPrinterAttached"
    When I select radio button forElement "input#ContentPlaceHolder1_rbtBatch"
    And I click on the checkBox forElement "input#ContentPlaceHolder1_chkNetUseCommand"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtNormalPrinter" as "10"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtBarcodePrinter.form-control-res" as "10"
