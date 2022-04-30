Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
  @27042022
  Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page using excel data
    When Im waiting for 2 sec
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as "12"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
    Then I establish connection to DB
    Then I read the values from table "tblinventory" in DB
    Then I read the values from table "tblinventorypricing" in DB
    Then I read the values from table "tblinventorystock" in DB
    Then I read the values from table "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table "tblInventoryShelfQty" in DB
    Then I close connection to DB

    Examples: 
      | TestcaseRowName |
      | cost1           |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP1
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations MRP page using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    Then I need to click on sub menu with text matching "Order & BreakPrice"
    Then I fill Order and break price
    Then I need to click on sub menu with text matching "Activation Settings"
    Then I fill Activationsettings
    Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button
     Then I establish connection to DB
    Then I read the values from table MRP "tblinventory" in DB
    Then I read the values from table MRP "tblinventorypricing" in DB
    Then I read the values from table MRP "tblinventorystock" in DB
    Then I read the values from table MRP "TBLBATCHINVENTORYCONTROL" in DB
    Then I read the values from table MRP "tblInventoryShelfQty" in DB
    Then I close connection to DB

    Examples: 
      | TestcaseRowName |
      | MRP1            |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP2
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button

    Examples: 
      | TestcaseRowName |
      | MRP2            |

  Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP3
    Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    Then I load the testdata form excel to table
    Then I load the inventory sheet data to map
    Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    Then I update value to the inventory page global Variables
    Then I fill new inventory data page using excel data
    Then I check the purchased by radio button for "<TestcaseRowName>"
    Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    Then I fill the GST values in the inventory page
    Then I fill inventory calculations page for MRP using excel data
    Then I verify the actual ui values with expected Excel values
    Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    When Im waiting for 5 sec
    Then I enter the value forimageElement "input#ContentPlaceHolder1_fuimage"
    Then I need to click on the "Save" button
    Then I click dynamically on "NewItemNo" button

    Examples: 
      | TestcaseRowName |
      | MRP3            |

  #Scenario Outline: Verifying Add Inventory Functionality Purchased by MRP4
    #Given I want to launch the "Inventory/frmInventoryMaster.aspx"
    #Then I load the testdata form excel to table
    #Then I load the inventory sheet data to map
    #Then I load the rowise inventory data for "<TestcaseRowName>" rowname
    #Then I update value to the inventory page global Variables
    #Then I fill new inventory data page using excel data
    #Then I check the purchased by radio button for "<TestcaseRowName>"
    #Then I need to click on the  element "input#ContentPlaceHolder1_imgPriceChange"
    #Then I fill the GST values in the inventory page
    #Then I fill inventory calculations page for MRP using excel data
    #Then I verify the actual ui values with expected Excel values
    #Then I click on button tag with value "Back"
    #Then I need to click on sub menu with text matching "Image"
    #When Im waiting for 5 sec
    #Then I enter the value forElement "input#ContentPlaceHolder1_fuimage" as ""
    #Then I need to click on the "Save" button
    #Then I click dynamically on "NewItemNo" button
#
    #Examples: 
      #| TestcaseRowName |
      #| MRP4            |
