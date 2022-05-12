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

public class PickerMasterNew extends PageObject {
	PickerMasterNewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;

	public PickerMasterNew(PickerMasterNewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr =new Screenshot();
	}
	@Then("I load the PickerMasterNew sheet data to map")
	public void i_load_the_PickerMasterNew_sheet_data_to_map() {
		Globals.Inventory.PickerMasterNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME91);
	}

	@Then("I load the PickerMasterNew rowise  data for {string} rowname")
	public void i_load_the_PickerMasterNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.PickerMasterNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PickerMasterNewSheetData, row_name);

		System.out.println(Globals.Inventory.PickerMasterNewrowwiseData);

	}

	@Then("I update value to the PickerMasterNew page global Variables")
	public void i_update_value_to_the_PickerMasterNew_page_global_Variables() {
				
		Globals.Inventory.PickerMasterId = Globals.Inventory.PickerMasterNewrowwiseData.get("Id");
		Globals.Inventory.PickerMasterName = Globals.Inventory.PickerMasterNewrowwiseData.get("PickerName");
		Globals.Inventory.PickerStatus = Globals.Inventory.PickerMasterNewrowwiseData.get("PickerStatus");
	}

	@Then("I fill new PickerMasterNew data page using excel data")
	public void i_fill_new_PickerMasterNew_data_page_using_excel_data() throws Exception {
		
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PickerMasterId)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PickerId_String, Globals.Inventory.PickerMasterId);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PickerMasterName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PickerName_String, Globals.Inventory.PickerMasterName);

		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.PickerStatus)) {
			terPage.get_radioButton_element(icp.PickerStatus_String).click();
		}*/
		pass.ExcelFourData("pickermaster","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("pickermaster", "PickerMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("pickermaster","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("pickermaster", "PickerMaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to PickerMasterNew")
	public void i_close_connection_to_PickerMasterNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	


	@Then("I establish connection to PickerMasterNew")
	public void i_establish_connection_to_PickerMasterNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	
	}

	

	@Then("I read the values from table {string} in PickerMasterNew")
	public void i_read_the_values_from_table_in_PickerMasterNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where PickerId='ABC'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblPickerMaster":
				String PickerMasterId = "";
				try {
					PickerMasterId = rs.getString("PickerId");
					System.out.println(PickerMasterId);
					Assert.assertEquals(Globals.Inventory.PickerMasterId.trim(), PickerMasterId.trim());
					pass.Excelcreate("pickermaster", "tblPickerMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("pickermaster", "PickerMasterId", Globals.Inventory.PickerMasterId, PickerMasterId, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("pickermaster", "tblPickerMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("pickermaster", "PickerMasterId", Globals.Inventory.PickerMasterId, PickerMasterId, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String PickerMasterName = "";
				try {
					PickerMasterName = rs.getString("PickerName");
					System.out.println(PickerMasterName);
					Assert.assertEquals(Globals.Inventory.PickerMasterName.trim(), PickerMasterName.trim());

					pass.ExcelFourData("pickermaster", "PickerMasterName", Globals.Inventory.PickerMasterName, PickerMasterName, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("pickermaster", "PickerMasterName", Globals.Inventory.PickerMasterName, PickerMasterName, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String PickerStatus = "";
				try {
					PickerStatus = rs.getString("PickerStatus");
					System.out.println(PickerStatus);
					Assert.assertEquals(Globals.Inventory.PickerStatus.trim(), PickerStatus.trim());

					pass.ExcelFourData("pickermaster", "PickerStatus", Globals.Inventory.PickerStatus, PickerStatus, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("pickermaster", "PickerStatus", Globals.Inventory.PickerStatus, PickerStatus, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
		
	}

	
		}
	}

}