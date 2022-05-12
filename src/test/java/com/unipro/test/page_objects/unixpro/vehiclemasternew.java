package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class vehiclemasternew extends PageObject {
	vehiclemasternewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public vehiclemasternew(vehiclemasternewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	} 
	@Then("I load the VehicleMasterNew sheet data to map")
	public void i_load_the_VehicleMasterNew_sheet_data_to_map() {
		Globals.Inventory.VehicleMasterNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME88);
	}

	@Then("I load the VehicleMasterNew rowise  data for {string} rowname")
	public void i_load_the_VehicleMasterNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.VehicleMasterNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.VehicleMasterNewSheetData, row_name);

		System.out.println(Globals.Inventory.VehicleMasterNewrowwiseData);
	}

	@Then("I update value to the VehicleMasterNew page global Variables")
	public void i_update_value_to_the_VehicleMasterNew_page_global_Variables() {
		Globals.Inventory.Vehiclemastercode = Globals.Inventory.VehicleMasterNewrowwiseData.get("vehiclemastercode");
		Globals.Inventory.DriverName = Globals.Inventory.VehicleMasterNewrowwiseData.get("drivername");
	}

	@Then("I fill new VehicleMasterNew data page using excel data")
	public void i_fill_new_VehicleMasterNew_data_page_using_excel_data() throws Exception {
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vehiclemastercode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.vehiclemastercode_String, Globals.Inventory.Vehiclemastercode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DriverName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Drivername_String, Globals.Inventory.DriverName);
			
			
		}
		pass.ExcelFourData("vehiclemaster","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("vehiclemaster", "VehicleMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("vehiclemaster","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("vehiclemaster", "VehicleMaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to VehicleMasterNew")
	public void i_close_connection_to_VehicleMasterNew() {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	
	@Then("I establish connection to VehicleMasterNew")
	public void i_establish_connection_to_VehicleMasterNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in VehicleMasterNew")
	public void i_read_the_values_from_table_in_VehicleMasterNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where DriverName='lorry'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblVehicle":
				String Vehiclemastercode = "";
				try {
					Vehiclemastercode = rs.getString("VehicleNo");
					System.out.println(Vehiclemastercode);
					Assert.assertEquals(Globals.Inventory.Vehiclemastercode.trim(), Vehiclemastercode.trim());
					pass.Excelcreate("vehiclemaster", "tblVehicle", "", 3, 1, 3, 2);
					pass.ExcelFourData("vehiclemaster", "Vehiclemastercode", Globals.Inventory.Vehiclemastercode, Vehiclemastercode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("vehiclemaster", "tblVehicle", "", 3, 1, 3, 2);
					pass.ExcelFourData("vehiclemaster", "Brandcode", Globals.Inventory.Vehiclemastercode, Vehiclemastercode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String DriverName = "";
				try {
					DriverName = rs.getString("DriverName");
					System.out.println(DriverName);
					Assert.assertEquals(Globals.Inventory.DriverName.trim(), DriverName.trim());

					pass.ExcelFourData("vehiclemaster", "DriverName", Globals.Inventory.DriverName, DriverName, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vehiclemaster", "DriverName", Globals.Inventory.DriverName, DriverName, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
	}

	
		}
	}

}
