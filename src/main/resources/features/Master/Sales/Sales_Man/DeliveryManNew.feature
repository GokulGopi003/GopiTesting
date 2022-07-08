Feature: PoS Master > Sales > Sales man >Delivery man @done
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: Title of your scenario outline
    Given I want to launch the "Masters/frmDeliveryMan.aspx"
  Then I load the testdata form excel to table
	Then I load the DeliveryManNew sheet data to map
  Then I load the DeliveryManNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the DeliveryManNew page global Variables
  Then I fill new DeliveryManNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to DeliveryManNew
  Then I read the values from table "tblDeliveryMan" in DeliveryManNew
  Then I close connection to DeliveryManNew


    Examples: 
      |TestcaseRowName  |
      |DeliveryManNew  |
      |DeliveryManNew1  |
      |DeliveryManNew2  |
      |DeliveryManNew3  |
      |DeliveryManNew4  |
      |DeliveryManNew5  |
      |DeliveryManNew6  |
      |DeliveryManNew7  |
      |DeliveryManNew8  |
      |DeliveryManNew9  |
      |DeliveryManNew10  |
      
      
