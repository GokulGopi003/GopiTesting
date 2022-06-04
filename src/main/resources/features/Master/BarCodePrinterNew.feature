Feature: Home Master Inventory Barcode Printer
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Home>Master>Inventory>Barcode Printer
      Given I want to launch the "Masters/frmBarcodePrinter.aspx"
  Then I load the testdata form excel to table
	Then I load the BarCodePrinterNew sheet data to map
  Then I load the BarCodePrinterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BarCodePrinterNew page global Variables
  Then I fill new BarCodePrinterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BarCodePrinterNew
  Then I read the values from table "tblPrinterMaster" in BarCodePrinterNew
  Then I close connection to BarCodePrinterNew


    Examples: 
      |TestcaseRowName |
      |BarCodePrinterNew1 |
      
