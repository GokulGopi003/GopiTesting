Feature: PoS Master > Sales >Vehicles master @done
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
      Given I want to launch the "Masters/frmHomeDeliveryTrayMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the HomeDeliveryTrayNew sheet data to map
  Then I load the HomeDeliveryTrayNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the HomeDeliveryTrayNew page global Variables
  Then I fill new HomeDeliveryTrayNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to HomeDeliveryTrayNew
  Then I read the values from table "tblBagMaster" in HomeDeliveryTrayNew
  Then I close connection to HomeDeliveryTrayNew


    Examples: 
      |TestcaseRowName |
      |HomeDeliveryTrayNew |
      |HomeDeliveryTrayNew1 |
      |HomeDeliveryTrayNew2 |
      |HomeDeliveryTrayNew3 |
      |HomeDeliveryTrayNew4 |
      |HomeDeliveryTrayNew5 |
      |HomeDeliveryTrayNew6 |
      |HomeDeliveryTrayNew7 |
      |HomeDeliveryTrayNew8 |
      |HomeDeliveryTrayNew9 |
      |HomeDeliveryTrayNew10 |
      
