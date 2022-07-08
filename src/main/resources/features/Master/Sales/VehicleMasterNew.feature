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
      Given I want to launch the "Masters/frmVehicleMaster.aspx"
  Then I load the testdata form excel to table
	Then I load the VehicleMasterNew sheet data to map
  Then I load the VehicleMasterNew rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the VehicleMasterNew page global Variables
  Then I fill new VehicleMasterNew data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to VehicleMasterNew
  Then I read the values from table "tblVehicle" in VehicleMasterNew
  Then I close connection to VehicleMasterNew

    Examples: 
      |TestcaseRowName  |
      |VehicleMasterNew  |
      |VehicleMasterNew1  |
      |VehicleMasterNew2  |
      |VehicleMasterNew3  |
      |VehicleMasterNew4  |
      |VehicleMasterNew5  |
      |VehicleMasterNew6  |
      |VehicleMasterNew7  |
      |VehicleMasterNew8  |
      |VehicleMasterNew9  |
      |VehicleMasterNew10  |
      
     
