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

public class Homedeliverytraynew extends PageObject {
	Homedeliverytraynewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public Homedeliverytraynew(Homedeliverytraynewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();

}
	@Then("I load the HomeDeliveryTrayNew sheet data to map")
	public void i_load_the_HomeDeliveryTrayNew_sheet_data_to_map() {
		Globals.Inventory.HomeDeliveryTrayNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME89);
	}

	@Then("I load the HomeDeliveryTrayNew rowise  data for {string} rowname")
	public void i_load_the_HomeDeliveryTrayNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.HomeDeliveryTrayNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.HomeDeliveryTrayNewSheetData, row_name);

		System.out.println(Globals.Inventory.HomeDeliveryTrayNewrowwiseData);
	}

	@Then("I update value to the HomeDeliveryTrayNew page global Variables")
	public void i_update_value_to_the_HomeDeliveryTrayNew_page_global_Variables() {
		Globals.Inventory.BagCode = Globals.Inventory.HomeDeliveryTrayNewrowwiseData.get("bagcode");
		Globals.Inventory.Description = Globals.Inventory.HomeDeliveryTrayNewrowwiseData.get("description");
	}

	@Then("I fill new HomeDeliveryTrayNew data page using excel data")
	public void i_fill_new_HomeDeliveryTrayNew_data_page_using_excel_data() throws Exception {
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BagCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BagCode_String, Globals.Inventory.BagCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);
			
			
		}
		pass.ExcelFourData("homedeliverytray","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("homedeliverytray", "VehicleMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("homedeliverytray","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("homedeliverytray", "VehicleMaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to HomeDeliveryTrayNew")
	public void i_close_connection_to_HomeDeliveryTrayNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	

	@Then("I establish connection to HomeDeliveryTrayNew")
	public void i_establish_connection_to_HomeDeliveryTrayNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in HomeDeliveryTrayNew")
	public void i_read_the_values_from_table_in_HomeDeliveryTrayNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where BagCode='10'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblBagMaster":
				String BagCode = "";
				try {
					BagCode = rs.getString("BagCode");
					System.out.println(BagCode);
					Assert.assertEquals(Globals.Inventory.BagCode.trim(), BagCode.trim());
					pass.Excelcreate("homedeliverytray", "tblBagMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("homedeliverytray", "BagCode", Globals.Inventory.BagCode, BagCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("homedeliverytray", "tblBagMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("homedeliverytray", "BagCode", Globals.Inventory.BagCode, BagCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("homedeliverytray", "Description", Globals.Inventory.Description, Description, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("homedeliverytray", "Description", Globals.Inventory.Description, Description, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
	}

	
		}
	}

	}



